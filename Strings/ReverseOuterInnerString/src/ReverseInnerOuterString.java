import java.util.Arrays;

public class ReverseInnerOuterString {

    public static void main(String[] args) {
        String s = "I will do it.";
        String result = reverse_ordering_of_words(s);
        System.out.println(result);
    }

    static String reverse_ordering_of_words(String s) {
        /*
         * Write your code here.
         */
        char[] arr = s.toCharArray();
        reverseString(arr, 0, arr.length - 1);

        reverseInnerString(arr);
        return new String(arr);

    }

    private static void reverseString(char[] arr, int i, int j) {
        while (i <= j) {
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }

    private static void reverseInnerString(char[] arr) {
        int i = 0,j=0;
        while (i < arr.length) {
            j = i;
            while (j < arr.length) {
                if (arr[j] != ' ')
                    j++;
                else
                    break;
            }
            reverseString(arr, i, j - 1);
            i = j + 1;
            }
        }
    }
