import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Map;


public class ShortestSubstring {

    public static void main(String[] args) {
        String s = "helloworld";
        String pattern = "lrw";
        String result = shortestSubstring(s, pattern);
        System.out.println(result);
    }

    private static void InitializeSet(Set<Character> set, char[] p) {
        for (char c : p)
            set.add(c);
    }

    public static String shortestSubstring(String s, String pattern) {

        if (pattern.length() > s.length()) return "";
        return shortestSubstringInternal(s, pattern);
    }

    private static String shortestSubstringInternal(String str, String pattern) {

        char[] p = pattern.toCharArray();
        Set<Character> set = new HashSet<>();
        InitializeSet(set, p);

        char[] s = str.toCharArray();
        int minLength = Integer.MAX_VALUE, lIndex = 0, rIndex = 0;
        Map<Character, Integer> map = new HashMap<>();
        Set<Character> tempSet = new HashSet<>();

        for (int start = 0; start < str.length(); start++) {

            boolean found = false;
            tempSet.clear();
            InitializeSet(tempSet, p);
            int missing = set.size();
            int totalFound = 0;
            map.clear();
            //Skip the first few characters that are not in the set to prune the string.

            int right = start;
            while (right < s.length) {
                if (tempSet.contains(s[right])) {
                    tempSet.remove(s[right]);
                    missing--;
                }
                if (set.contains(s[right])) {
                    if (map.containsKey(s[right])) {
                        int count = map.get(s[right]);
                        map.put(s[right], count + 1);
                        totalFound++;
                    } else {
                        map.put(s[right], 1);
                        totalFound++;
                    }
                }

                if (missing == 0) {
                    found = true;
                    break;
                }
                right++;
            }

            //Optimize my checking if there are more than 1 for the characters in the set. If yes move the window to the right.
            if (found) {
                int left = start;
                while (left < right && totalFound != map.size()) {
                    if (map.containsKey(s[left]) && map.get(s[left]) > 1) {
                        int count = map.get(s[left]);
                        map.put(s[left], count - 1);
                        totalFound--;
                    }
                    left++;
                }

                if ((right - left + 1) < minLength) {
                    minLength = right - left + 1;
                    rIndex = right;
                    lIndex = left;
                }
            }
        }
        return str.substring(lIndex, rIndex+1);
    }
}

