/*
Given a list of words, you have to find a pair of words A and B, such that joined word A + B forms a palindrome.

If such pair exists, then return array [A, B]. If no such pair exists then return empty array.

There can be multiple pairs, just return the first one if found.

Example 1:-

Consider a list {bat, tab, cat}. Then bat and tab can be joined together to form a palindrome.

Example 2 :-

{ab, deedba} can be joined to form a palindrome.

Example 3 :-

{'ant', 'cat', 'dog'}: No two words here can be joined to form a palindrome.

Note:

This problem is under development according to IK standards. If you'd like to contribute, then please feel free to email soham@interviewkickstart.com

Till we finish developing this problem, you can look at:

https://leetcode.com/problems/palindrome-pairs/

About expected solutions:

Given n = number of words and k is length of the longest word, O(N.K^2) solution for this problem is relatively straightforward to come by, using Maps or Tries. That may suffice for most interviews.

e.g.

https://discuss.leetcode.com/topic/40657/150-ms-45-lines-java-solution

or

https://discuss.leetcode.com/topic/39585/o-n-k-2-java-solution-with-trie-structure-n-total-number-of-words-k-average-length-of-each-word

In order to increase the average case efficiency, see if you can apply the Mancher technique we learnt in the class. That can bring it down to O(N.K): https://www.quora.com/Given-a-list-of-words-can-two-words-be-joined-together-to-form-a-palindrome
 */

import java.util.*;

class TrieNode {
    TrieNode[] children;
    int wordIndex;
    List<Integer> suffixPal;

    TrieNode(){
        this.children = new TrieNode[26];
        wordIndex=-1;
        suffixPal = new ArrayList<>();
    }
}

public class PalindromePairs {


    public static void main(String[] args) {
        String[] words = new String[]{"am", "dog", "god", "racee", "joy", "mad", "pluto", "car", "hulu", "stuff"};
        List<List<Integer>> result = palindromePairs(words);
        System.out.println(result);
    }

    public static List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> result = new ArrayList<>();

        TrieNode root = new TrieNode();

        for (int i = 0; i < words.length; i++)
            addWordToReverseTrie(words[i], root, i);

        for (int i = 0; i < words.length; i++)
            searchPalindromePairs(words[i], i, result, root);

        return result;
    }

    private static TrieNode addWordToReverseTrie(String word, TrieNode root, int wordIndex) {
        for (int c = word.length() - 1; c >= 0; c++) {
            int charIndex = word.charAt(c) - 'a';
            if (root.children[charIndex] == null)
                root.children[charIndex] = new TrieNode();

            if (isPalindrome(word, 0, c))
                root.suffixPal.add(wordIndex);

            root = root.children[charIndex];
        }
        root.wordIndex = wordIndex;
        root.suffixPal.add(wordIndex);

        return root;
    }

    private static void searchPalindromePairs(String word, int iWord, List<List<Integer>> result, TrieNode root) {
        for (int c = 0; c < word.length(); c++) {

            if (root.wordIndex > -1 && root.wordIndex != iWord && isPalindrome(word, c, word.length() - 1))
                result.add(Arrays.asList(iWord, root.wordIndex));

            else {
                root = root.children[word.charAt(c) - 'a'];
                if (root == null) return;
            }
        }
        for (int j : root.suffixPal) {
            if (iWord == j)
                continue;
            result.add(Arrays.asList(iWord, j));
        }
    }

    private static boolean isPalindrome(String word, int start, int end){
        while(start <= end) {
            if (word.charAt(start) != word.charAt(end))
                return false;
            else {
                start++;
                end--;
            }
        }
        return true;
    }
}
