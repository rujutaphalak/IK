import java.util.HashSet;

public class subsetPalindrome {

    public static void main(String []args){
        String s = "abracadabra";
        String[] palSubsets = generate_palindromic_decompositions(s);
        for(String str:palSubsets)
            System.out.println(str);
    }

    public static String[] generate_palindromic_decompositions(String s){
        HashSet<String> set = new HashSet<>();
        return subsetPal(s,0,0,set);
    }

    private static String[] subsetPal(String s, int i, int j, HashSet<String> set){
        while(i<s.length()){
            j=i;
            while(j<s.length()){
                if(isPalindrome(s,i,j)) {
                    //create the decoration string
//                    String pal = s.substring(0,i)
//                    System.out.println("|"+)
                    set.add(s.substring(i, j + 1));
                }
                j++;
            }
            i++;
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

