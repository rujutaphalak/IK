/**
 * Palindromic Decomposition Of A String
 *
 *
 *
 * Problem Statement:
 *
 *
 *
 * A palindromic decomposition of string is a decomposition of the string into substrings, such that all those substrings are valid palindromes.
 *
 *
 *
 * Given a string s, you have to find ALL possible palindromic decompositions of it.
 *
 *
 *
 * Note that string s itself is also a substring of s.
 *
 *
 *
 * Input/Output Format For The Function:
 *
 *
 *
 * Input Format:
 *
 *
 *
 * There is only one argument: string s.
 *
 *
 *
 * Output Format:
 *
 *
 *
 * Return array of string res, containing ALL possible palindromic decompositions of given string.
 *
 *
 *
 * To separate substrings in the decomposed string, use '|' as a separator between them. (Look at the sample test cases for more clarity.)
 *
 *
 *
 * Note that:
 *
 * You need not to worry about the order of strings in your output array. Like for s = "aa", arrays ["a|a", "aa"] and ["aa", "a|a"] both will be accepted.
 * In any string in your returned array res, order of characters should remain same as in given string. (i.e. for s = "ab" you should return ["a|b"] and not ["b|a"].)
 * Any string in the returned array should not contain any spaces. e.g. s = "ab" then ["a|b"] is expected, ["a |b"] or ["a| b"] or ["a | b"] will give wrong answer.
 *
 *
 * Input/Output Format For The Custom Input:
 *
 *
 *
 * Input Format:
 *
 *
 *
 * The first and only line of input should contain a string s, denoting the input string.
 *
 *
 *
 * If s = “abracadabra”, then input should be:
 *
 *
 *
 * abracadabra
 *
 *
 *
 * Output Format:
 *
 *
 *
 * Let’s denote size of res array as m, where res is the resultant array of string returned by solution function.
 *
 * Then, there will be m lines of output, where ith line contains a string res[i], denoting string at index i of res.
 *
 *
 *
 * For input s = “abracadabra”, output will be:
 *
 *
 *
 * a|b|r|a|c|ada|b|r|a
 *
 * a|b|r|aca|d|a|b|r|a
 *
 * a|b|r|a|c|a|d|a|b|r|a
 *
 *
 *
 * Constraints:
 *
 * 1 <= |s| <= 20
 * s only contains lowercase letters ('a' - 'z').
 *
 *
 * Sample Test Cases:
 *
 *
 *
 * Sample Input:
 *
 *
 *
 * "abracadabra"
 *
 *
 *
 * Sample Output:
 *
 *
 *
 * [
 *
 *    "a|b|r|a|c|a|d|a|b|r|a",
 *
 *    "a|b|r|a|c|ada|b|r|a",
 *
 *    "a|b|r|aca|d|a|b|r|a"
 *
 * ]
 *
 *
 *
 * Notes:
 *
 * Suggested time in interview: 40 minutes
 *
 * The “Suggested Time” is the time expected to complete this question during a real-life interview, not now in homework i.e. For the first attempt of a given homework problem, the focus should be to understand what the problem is asking, what approach you are using, coding it, as well as identifying any gaps that you can discuss during a TC session. Take your time, but limit yourself to 2 one hour sessions for most problems.
 */

/**
 *
 We have provided two solutions:



 1) Solution Using Recursion: other_solution.cpp

 2) Solution Using Dynamic Programming: optimal_solution.cpp



 Try to solve the problem using both the approaches.



 First look at the solution using recursion and then solution using dynamic programming.



 In solution using dynamic programming we have pre-calculated is_palindrome array, but in solution using recursion we have not. But you should do it in recursive solution also. (To make code readable and easy to understand, we have not pre-calculated in recursive solution.)



 Time Complexity Of The Optimal Solution:



 O((2^(n - 1)) * n).



 Consider input s = "aaaaaaaaaaaaaaaaaaaa" (20 times.)



 For strings like this, every substring will be a palindrome, hence total number of palindromic decomposition in worst case will be 2^(n - 1).



 (Try s = "aaa" and it will be more clear why 2^(n - 1).)



 We will store 2^(n - 1) palindromic decomposition and length of each will be O(n) hence time complexity will be O((2^(n - 1)) * n).



 Auxiliary Space Used Of The Optimal Solution:



 O((2^(n - 1)) * n).



 In answer array we will store all 2^(n - 1) palindromic decomposition of length O(n).



 Also is_palindrome array is O(n ^ 2) so O((2^(n - 1)) * n) + O(n ^ 2) -> O((2^(n - 1)) * n).



 Space Complexity Of The Optimal Solution:



 O((2^(n - 1)) * n).



 Auxiliary space used is O((2^(n - 1)) * n) and input size is O(n) hence O((2^(n - 1)) * n) + O(n) -> O((2^(n - 1)) * n).
 */

import java.util.List;
import java.util.ArrayList;

public class PalindromeDecomposition {

    public static void main(String []args){
        String s = "abcbr";
        String[] palSubsets = generate_palindromic_decompositions(s);
        for(String str:palSubsets)
            System.out.println(str);
    }

    static String[] generate_palindromic_decompositions(String s) {
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        palDecompose(s, sb, 0, result);
        return result.toArray(new String[0]);
    }

    private static void palDecompose(String s, StringBuilder sb, int start, List<String> result){
        if(start == s.length()){
            result.add(sb.toString());
            return;
        }

        for(int end=start; end<s.length(); end++){
            if (isPalindrome(s,start,end)){
            String pal = s.substring(start,end+1);
            sb.append(pal);
            int palLen = pal.length();
            if(end != s.length()-1){
                palLen++;
                sb.append("|");
            }
            palDecompose(s,sb,end+1,result);
            sb.setLength(sb.length()-palLen);
            }
        }
    }

    private static boolean isPalindrome(String s, int i, int j){
        while(j>=i){
            if(s.charAt(i)==s.charAt(j)){
                i++;
                j--;
            }
            else {
                return false;
            }
        }
        return true;
    }
}
