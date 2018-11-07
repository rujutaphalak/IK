/*
Longest Substring With Exactly Two Distinct Characters

Problem Statement:

Given a string s of length n, find the length of the longest substring ss that contains exactly two distinct characters.

There are t test cases.

Input Format:

There is only one argument s, denoting input string.

s may contain upper case alphabets, lower case alphabets and numerical values.

Output Format:

Return an integer len, denoting length of longest substring as asked in problem

(If there are no such substrings, then return 0)

Constraints:

1 <= t <= 1000

1 <= n <= 10^5

Sample Test Cases:

Sample Input 1:

2
eceba
abcdef

Sample Output 1:

3
2

Explanation 1:

In first case, 'ece' is the largest substring with exactly 2 distinct characters.

In second case, 'ab' is the largest substring with exactly 2 distinct characters. Also, 'bc', 'cd', 'de', 'ef' can be

considered as substring with exactly 2 distinct characters.

Sample Input 2:
3
ababababa
e
baabcbab

Sample Output 2:

9
0
4

Explanation 2:

In first case, whole string 'ababababa' is the largest substring with exactly 2 distinct characters.

In second case, there is no substring with exactly 2 distinct characters.

In third case, 'baab' is the largest substring with exactly 2 distinct characters.
 */

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithDistinctCharacters {

    public static void main(String[] args) {
        String s = "aaaabbbccc";
        int result = getLongestSubstringLengthExactly2DistinctChars(s);
        System.out.println(result);
    }

    public static int getLongestSubstringLengthExactly2DistinctChars(String s){
        return getLongestStringDistinctChar(s);
    }

    private static int getLongestStringDistinctChar(String s){
        if (s.length() < 2)
            return 0;

        Set<Character> map = new HashSet<>();
        int maxLength=0, start=0,end;

        while(start<s.length()) {
            map.clear();

            for (end=start;end < s.length();end++) {
                if (!map.contains(s.charAt(end))){
                    if (map.size() == 2) {
                        break;
                    }
                    else
                        map.add(s.charAt(end));
                }
            }
            if(map.size()==2) {
                end--;
                if ((end - start + 1) > maxLength)
                    maxLength = end - start + 1;
            }

            if(end!=s.length()) {
                while (end >= 1) {
                    if (s.charAt(end - 1) == s.charAt(end))
                        end--;
                    else
                        break;
                }
            }
            start=end;
        }
        return maxLength;
    }

    /*
    Implemented using hashmap, but we really dont need the count of characters, we just
    need ot keep the count of dictinct characters for which set is enough.
     */
//    private static int getLongestStringDistinctChar(String s){
//        if (s.length() < 2)
//            return 0;
//
//        Map<Character, Integer> map = new HashMap<>();
//        int maxLength=0, start=0,end;
//
//        while(start<s.length()) {
//            map.clear();
//            boolean done = false;
//
//            for (end=start;end < s.length();end++) {
//                if (!map.containsKey(s.charAt(end))){
//                    if (map.size() == 2) {
//                        break;
//                    }
//                    else
//                        map.put(s.charAt(end), 1);
//                }
//                else{
//                    map.put(s.charAt(end), map.get(s.charAt(end))+1);
//                }
//            }
//            if(map.size()==2) {
//                done = true;
//                end--;
//            }
//            if(done) {
//                if ((end - start + 1) > maxLength) {
//                    maxLength = end - start + 1;
//                }
//            }
//            if(end!=s.length()) {
//                while (end >= 1) {
//                    if (s.charAt(end - 1) == s.charAt(end))
//                        end--;
//                    else
//                        break;
//                }
//            }
//            start=end;
//        }
//        return maxLength;
//    }
}
