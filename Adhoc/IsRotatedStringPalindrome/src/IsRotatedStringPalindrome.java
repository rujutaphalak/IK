/**
 * Is It A Rotation Of A Palindrome?
 *
 *
 *
 * Problem Statement:
 *
 *
 *
 * Given a string s of length N containing only lower case letters (a - z), we have to check if it is a rotation of some palindromic string or not.
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
 * There is only one argument denoting string s.
 *
 *
 *
 * Output Format:
 *
 *
 *
 * Return one integer res. Return 1 if given string s is a rotation of some palindromic string else return 0.
 *
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
 * There should be one line, containing input string s.
 *
 *
 *
 * If s = “aab”, then input should be:
 *
 *
 *
 * aab
 *
 *
 *
 * Output Format:
 *
 *
 *
 * There will be one line, containing the returned integer res.
 *
 *
 *
 * For input s = “aab”, output will be:
 *
 *
 *
 * 1
 *
 *
 *
 * Constraints:
 *
 * 1 <= N <= 4000
 * s will only contain lower case letters (a - z).
 * String may or may not be sorted.
 *
 *
 * Sample Test Case:
 *
 *
 *
 * Sample Input:
 *
 *
 *
 * aab
 *
 *
 *
 * Sample Output:
 *
 *
 *
 * 1
 *
 *
 *
 * Explanation:
 *
 *
 *
 * Given string aab is a rotation of palindromic string aba. Right rotation on aba will give aab.
 *
 *
 *
 * Notes:
 *
 *
 *
 * Expected solution is O(N ^ 2). That will be very easy to write in an interview.
 *
 *
 *
 * Maximum time allowed in interview: 20 Minutes.
 *
 *
 *
 * Python: If getting run time error then try to use iterative version to check if string is a palindrome or not.
 */

/**
 * Editorial by IK
 *
 * For any string of length N, number of different string obtained by rotating it will be <= N (in some cases it can be < N, due to duplicates). Initially we might think that there are many ways to apply rotations like (left rotation -> left rotation -> left rotation -> right rotation...). But left rotation and right rotation cancel out each other. Also applying left shift x times is same as applying left shift by x % N times and applying right shift x times is same as applying right shift by x % N times. For better understanding try some examples.
 *
 *
 *
 * If any string x is rotations of some palindromic string p, then at least one rotation of x will be p. So we can try all N rotations of given string and check if resulting string is palindrome or not.
 *
 *
 *
 * Finding if a given string is palindrome or not is O(N). So, overall time complexity will be O(N) * O(N) = O(N ^ 2).
 *
 *
 *
 * Space complexity of the programme will be O(N) because space complexity includes the input space also. Auxiliary space used by programme will depend on our implementation. It can be O(N) or (1). Solution provided by us is using O(1) auxiliary space.
 *
 *
 *
 *
 *
 * Just for information:
 *
 *
 *
 * More efficient solution like O(N logN) possible using suffix array and LCP array.
 *
 *
 *
 * Link for suffix array:
 *
 * http://www.geeksforgeeks.org/suffix-array-set-2-a-nlognlogn-algorithm/
 *
 * Link for LCP array:
 *
 * http://www.geeksforgeeks.org/%C2%AD%C2%ADkasais-algorithm-for-construction-of-lcp-array-from-suffix-array/
 *
 *
 *
 *
 *
 * Also more efficient solution like O(N) possible using longest palindromic substring.
 *
 *
 *
 * Link for longest palindromic substring:
 *
 * https://en.wikipedia.org/wiki/Longest_palindromic_substring
 */
public class IsRotatedStringPalindrome {

  public static void main(String[] args)
  {
    String s = "aabc";
    int result = check_if_rotated(s);
    System.out.println(result);
  }

  static int check_if_rotated(String s) {

    if(isPal(s))
      return 1;

    //check if any of the rotations of the string is a palindrome. Rotating left is simpler to understand then rotating right. abc
    for(int i=0;i<s.length()-1;i++){
      String s1 = s.substring(0,i+1);
      String s2 = s.substring(i+1);

      if(isPal(s2+s1))
        return 1;
    }
    return 0;
  }

  static boolean isPal(String s){
    int i=0,j=s.length()-1;
    while(i<=j){
      if(s.charAt(i)==s.charAt(j)) {
        i++;
        j--;
      }
      else
        return false;
    }
    return true;
  }

}
