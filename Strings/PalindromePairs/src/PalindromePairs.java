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

/**
 * Editorial by IK is without trie node, it uses but only one hashmap and returns only the first found pair.
 *
 * We have provided solutions which contain necessary comments to understand the approach used:
 *
 *
 *
 * 1) brute_force_solution.java
 *
 *
 *
 * Description:
 *
 *
 *
 * A naive approach would be to iterate over all ordered pairs of words from list words, i.e. (words[i], words[j]) such that i != j, 0<=i<n, 0<=j<n, check if words[i] + words[j] is palindrome or not. If we found such pair of words of forming palindrome then return that pair of words.
 *
 *
 *
 * Time Complexity:
 *
 *
 *
 * O((n^2)*l), where n is size of list words and l is the maximum length of words in list words.
 *
 *
 *
 * As there are total 2*(nC2) ordered pair of words, and for each pair, for finding whether that pair is forming palindrome or not will take O(l).So, time complexity of this solution will be O((n^2)*l).
 *
 *
 *
 * Auxiliary Space Used:
 *
 *
 *
 * O(l) where l is the maximum length of words in list words.
 *
 *
 *
 * As we are storing result list of two words of maximum length l.
 *
 *
 *
 * Space Complexity:
 *
 *
 *
 * O(n*l) where n is size of list words and l is the maximum length of words in list words.
 *
 *
 *
 * Input will take space O(n*l) because we are storing n words of list words where maximum possible length of word can be l and auxiliary space used is O(l). So, O(n*l) + O(l) -> O(n*l).
 *
 *
 *
 * 2) optimal_solution.java
 *
 *
 *
 * Description:
 *
 *
 *
 * A better approach would be as follows from some observations:
 *
 *
 *
 * Let say there exists a pair of words (words[x], words[y]), such that result = (words[x] + words[y]) is a palindrome.
 *
 *
 *
 * Two cases are possible here:
 *
 *
 *
 * CASE 1: words[x].length() >= words[y].length()
 *
 *
 *
 * Iterating over words, considering the word in the current iteration as xth word in words. Task is to find out if there exists some yth word, such that words[x] + words[y] is a palindrome. Now, if such y exists, it must be of the form stringReverse(words[x].substring(0, k)), for some 0 <= k < words[x].length().
 *
 * So, now we only need to find such k, such that (words[y] == stringReverse(words[x].substring(0, k))) and (words[x].substring(k+1, words[x].length())) is a palindrome, if (k+1< words[x].length())
 *
 *
 *
 * CASE 2: words[x].length() < words[y].length()
 *
 * Iterating over words, considering the word in the current iteration as xth word in words. Task is to find out if there exists some yth word, such that words[y] + words[x] is a palindrome. Now, if such y exists, it must be of the form stringReverse(words[x].substring(k, words[x].length())), for some 0 <= k < words[x].length().
 *
 * So, now we only need to find such k, such that (words[y] == stringReverse(words[x].substring(k, words[x].length()))) and (words[x].substring(0, k)) is a palindrome, if (k>0)
 *
 *
 *
 * Both cases requires a quick lookup of words in list words. So, we can use hashset or hashMap here for constant time (amortized time) lookup of words. Also, in some cases, for eg. "aaaaa", we need to know the frequency of words so that
 *
 * same word (same indexed word in list of words) doesn't get picked up as other word to make a palindrome. So, hashmap having word as key and frequency of that word as value will work here.
 *
 *
 *
 * See the implementation for better understanding.
 *
 *
 *
 *
 *
 * Time Complexity:
 *
 *
 *
 * O(n*(l^2)) where n is size of list words and l is the maximum length of words in list words.
 *
 *
 *
 * As while iterating over list of words, considering the word in current iteration as left_word, we have to do two lookups and two palindrome check for each k, 0 <= k < length(left_word), time complexity will be O(l^2) for each word left_word.
 *
 * So, total time complexity will be O(n*(l^2)).
 *
 *
 *
 * Auxiliary Space Used:
 *
 *
 *
 * O(n*l) where n is size of list words and l is the maximum length of words in list words.
 *
 *
 *
 * As we are maintaining a hashmap of frequencies of words for n words of list words, space complexity to maintain this will be O(n*l) and we are storing result list of two words of maximum length l.
 *
 * O(n*l) + O(l) → O(n*l)
 *
 *
 *
 * Space Complexity:
 *
 *
 *
 * O(n*l) where n is size of list words and l is the maximum length of words in list words.
 *
 *
 *
 * Input will take space O(n*l) because we are storing n words of list words where maximum possible length of word can be l and auxiliary space used is O(n*l). So, O(n*l) + O(n*l) -> O(n*l).
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
        String[] words = new String[]{"am", "dog", "god", "racee", "joy", "mad", "pluto", "car",
            "hulu", "stuff"};
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

    private static void searchPalindromePairs(String word, int iWord, List<List<Integer>> result,
        TrieNode root) {
        for (int c = 0; c < word.length(); c++) {

            if (root.wordIndex > -1 && root.wordIndex != iWord && isPalindrome(word, c,
                word.length() - 1))
                result.add(Arrays.asList(iWord, root.wordIndex));

            else {
                root = root.children[word.charAt(c) - 'a'];
                if (root == null)
                    return;
            }
        }
        for (int j : root.suffixPal) {
            if (iWord == j)
                continue;
            result.add(Arrays.asList(iWord, j));
        }
    }

    private static boolean isPalindrome(String word, int start, int end) {
        while (start <= end) {
            if (word.charAt(start) != word.charAt(end))
                return false;
            else {
                start++;
                end--;
            }
        }
        return true;
    }
    /*
    //-------------------------------------Using single Hashmap, returns one pair-------------------------//

        static String[] join_words_to_make_a_palindrome(String[] words) {
            String[] result = new String[2];
            result[0] = "NOTFOUND";
            result[1] = "DNUOFTON";
            Map<String, Integer> map = new HashMap<>();
            for(String word:words){
                if(map.containsKey(word))
                    map.put(word,map.get(word)+1);
                else
                    map.put(word, 1);
            }

//            To find (left_word + right_word) exist which form palindrome where
//            left_word and right_word in given list of words

        String wordy = "";
        for(String wordx:words){
            wordy = "";

//             Two cases are possible here:
//
//             CASE 1: words[x].length() >= words[y].length()

//             Iterating over words, considering the word in the current iteration as xth word in words.
//             Task is to find out if there exists some yth word, such that
//             words[x] + words[y] is a palindrome.
//             Now, if such y exists, it must be of the form
//             stringReverse(words[x].substring(0, k)), for some 0 <= k < words[x].length().
//             So, now we only need to find such k,
//             such that (words[y] == stringReverse(words[x].substring(0, k))) and
//             (words[x].substring(k+1,words[x].length())) is a palindrome, if (k+1<words[x].length())

            for(int i = 0;i<wordx.length(); i++){

                // Here, current string denotes stringreverse(left_word.substring(0, j))
                // Check if current string is present in words or not
                wordy = wordx.charAt(i) + wordy;
                if(map.containsKey(wordy)){

                    if(wordx.equals(wordy)){
                        if(map.get(wordy)>1){
                            result[0] = wordx;
                            result[1] =wordy;
                            return result;
                        }
                    }
                    // Check if left_word.substring(j+1, len(left_word)) is a palindrome or not
                    else if(isPalindrome(wordx.substring(i+1))){
                        result[0] = wordx;
                        result[1] = wordy;
                        return result;
                    }
                }
            }
            wordy = "";

            // CASE 2: words[x].length() < words[y].length()

            // Iterating over words, considering the word in the current iteration as xth word in words.
            // Task is to find out if there exists some yth word, such that
            // words[y] + words[x] is a palindrome.
            // Now, if such y exists, it must be of the form
            // stringReverse(words[x].substring(k, words[x].length())), for some 0 <= k < words[x].length().
            // So, now we only need to find such k,
            // such that (words[y] == stringReverse(words[x].substring(k, words[x].length()))) and
            // (words[x].substring(0, k)) is a palindrome, if (k>0)
            for(int i=wordx.length()-1;i>=0;i--){
                // Here, current string denotes stringreverse(left_word.substring(j+1, len(left_word)))
                // Check if current string is present in words or not

                wordy = wordy + wordx.charAt(i);
                if(map.containsKey(wordy)){
                    // Handles that case so that same string itself doesn't get picked
                    // up as other string in pair to form a palindrome
                    if(wordx.equals(wordy)){
                        if(map.get(wordy)>1){
                            result[0] = wordy;
                            result[1] = wordx;
                            return result;
                        }
                    }
                    // Check if left_word.substring(0, j) is a palindrome or not
                    else if(isPalindrome(wordx.substring(0,i))){
                        result[0] = wordy;
                        result[1] = wordx;
                        return result;
                    }
                }
            }
        }
        return result;
    }

    private static boolean isPalindrome(String word){
        int i =0,j=word.length()-1;
        while(i<=j){
            if(word.charAt(i) != word.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }

*/
//-------------------------------------Using single Hashmap, returns one pair-------------------------//
}