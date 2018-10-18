
import java.util.HashSet;

public class PalindromeDecomposition {

    public static void main(String []args){
        String s = "aaaa";
        String[] palSubsets = generate_palindromic_decompositions(s);
        for(String str:palSubsets)
            System.out.println(str);
    }

    public static String[] generate_palindromic_decompositions(String s){
        HashSet<String> set = new HashSet<>();

/*        StringBuilder str = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (i == s.length() - 1)
                str.append(s.substring(i, i + 1));
            else
                str.append(s.substring(i, i + 1) + "|");
        }
        System.out.println(str);
        return subsetPal(str.toString(), 0, 0, set);
*/
        return subsetPal(s.toString(), 0, 0, set);
    }

    private static String[] subsetPal(String s, int i, int j, HashSet<String> set){
        int len = s.length();
        while(i<len){
            j=i;
            while(j<len){
                boolean isPalFlag = false;
                StringBuilder part1 = new StringBuilder(s.substring(0, i));
                if(isPalindrome(s,0,i)) {
                    isPalFlag = true;
                    part1 = new StringBuilder(s.substring(0, i).replace("|", ""));
                }
                StringBuilder part2 = new StringBuilder(s.substring(i,j+1));
                if(isPalindrome(s,i,j)) {
                    isPalFlag = true;
                    part2 = new StringBuilder(s.substring(i,j+1).replace("|",""));
//                    set.add(palString);
                }
                StringBuilder part3 = new StringBuilder(s.substring(j+1));
                if(isPalindrome(s,j,len)) {
                    isPalFlag = true;
                    part3 = new StringBuilder(s.substring(j+1).replace("|", ""));
                }
                if(isPalFlag == true)
                    set.add(part1.append(part2).append(part3).toString());
                j=j+2;
            }
            i=i+2;
        }
        return set.stream().toArray(String[]::new);
    }

    private static boolean isPalindrome(String s, int i, int j){
        char[] arr = s.toCharArray();
        while(j>=i){
            if(arr[i]==arr[j]){
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
