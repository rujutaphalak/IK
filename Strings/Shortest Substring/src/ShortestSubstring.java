import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Map;


public class ShortestSubstring {

    public static void main(String[] args) {
//        String s = "helloworld";
        String s = "AYZABOBECODXBANC";
//        String pattern = "lrw";
        String pattern = "ABC";
        String result = shortestSubstring(s, pattern);
        System.out.println(result);
    }

    private static void InitializeSet(Set<Character> set, char[] p) {
        for (char c : p)
            set.add(c);
    }

    public static String shortestSubstring(String s, String pattern) {

        if (pattern.length() > s.length())
            return "";
        return minimum_window(s, pattern);
    }

//    //This solution does not work for test cases with duplicates in the t. For example if s=abcda and t=aa,
//    // or s=123475879545634 and t = 3445, but works for all non duplicates
//    public static String minimum_window(String s, String t) {
//        int tLength = t.length();
//        if(s.length() < tLength)
//            return "-1";
//
//        String result = "-1";
//        Map<Character,Integer> freq = new HashMap<>();
//        int missing=tLength;
//
//        //Initialize the map with the characters in t we want to find. Does not take care of duplicates.
//        // For all characters in t the freq is 0.
//        for(int i=0;i<tLength;i++){
//            char tChar = t.charAt(i);
//            if(!freq.containsKey(tChar))
//                freq.put(tChar,0);
//        }
//
//        int start=0,end=start;
//        int minLength = s.length()+1;
//
//        while(start < s.length()){
//            //find the extreme right/end position/index that encompasses all characters from t.
//            while(end < s.length()) {
//                char eChar = s.charAt(end);
//                if (freq.containsKey(eChar)) {
//                    if (freq.get(eChar) == 0) {
//                        freq.put(eChar, freq.get(eChar) + 1);
//                        missing--;
//                    }
//                    else {
//                        freq.put(eChar, freq.get(eChar) + 1);
//                    }
//                    if(missing == 0)
//                        break;
//                }
//                end++;
//            }
//
//                if(missing==0){
//                    //Shrink the left/start position so find the min window/string.
//                    while(start<end) {
//                        char sChar = s.charAt(start);
//                        if (freq.containsKey(sChar)) {
//                            if (freq.get(sChar) > 0) {
//                                freq.put(sChar, freq.get(sChar) - 1);
//                            }
//                            if (freq.get(sChar) == 0){
//                                missing++;
//                                break;
//                            }
//                        }
//                        start++;
//                    }
//                }//end if
//
//                //if the length is less than the min length
//                int length = end-start+1;
//                if(length < minLength){
//                    minLength = length;
//                    result = s.substring(start,end+1);
//
//                }
//
//                //to continue through the string to find other shorter min window substring from next start position.
//                // for example in helloworld, in first pass after shrinking start=3 and end=6 which we already know is the first found min window substring.
//                //For next start from start+1 and keep going to the right/end as much as possible to cover all characters in t. Hence end+1.
//                //Also since both are in while loop, they need to be incremented.
//                start++;
//                end++;
//            }//end while
//        return result;
//        } //end method
//    //This solution does not work for test cases with duplicates in the t. For example if s=abcda and t=aa,
//    // or s=123475879545634 and t = 3445, but works for all non duplicates


    public static String minimum_window(String s, String t) {
    int tLength = t.length();
    int sLength = s.length();
        if(sLength < tLength)
        return "-1";

    String result = "-1";
    Map<Character,Integer> tMap = new HashMap<>();
    Map<Character,Integer> sMap = new HashMap<>();

    //Initialize the map with the characters in t we want to find
        for(int i=0;i<tLength;i++){
        char tChar = t.charAt(i);
        if(!tMap.containsKey(tChar))
            tMap.put(tChar,1);
        else
            tMap.put(tChar,tMap.get(tChar)+1);
    }

    int start=0;
    int minLength = s.length()+1;
    int count=0;

        for(int end=0;end<sLength;end++) {
        char eChar = s.charAt(end);
        if(!sMap.containsKey(eChar))
            sMap.put(eChar, 1);
        else
            sMap.put(eChar, sMap.get(eChar)+1);

        if (tMap.containsKey(eChar) && sMap.get(eChar) <= tMap.get(eChar))
            count++;

        //if count is reached the size of t, shrink the window by moving the left/start pointer
        if(count == tLength){
            while(start<end){
                if(tMap.containsKey(s.charAt(start)) && sMap.get(s.charAt(start)) > tMap.get(s.charAt(start))) {
                    sMap.put(s.charAt(start), sMap.get(s.charAt(start))-1);
                }
                start++;
            }


            int length = end-start+1;
            if(length < minLength){
                minLength = length;
                result = s.substring(start,end+1);
            }
        }
    }//end for
    return result;
}

}


