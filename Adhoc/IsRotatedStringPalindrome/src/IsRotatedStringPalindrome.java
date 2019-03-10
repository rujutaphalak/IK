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

/**
 * Other more optimal solution
 *
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

 //------------------------Other more optimal solution -------------------------------//
  /*
Problem is very easy. Here is the link for one solution.
http://www.geeksforgeeks.org/check-given-string-rotation-palindrome/
Still I will like to present other solution with same time complexity O(N^2) but more efficient.
In the above solution substring and string concatination is used, but we can build our solution
using just two pointers!
First we will see when N is odd. Consider s = cdcbaab. Here observe that if we consider d as
middle element then new string will look like abcdcba. So we only need to check if for atleast one
position after considering it as middle element we can get palindromic string or not.
When N is even we do the same thing but now there will be two middle elements. Consider s =
cddcbaab then we need to consider each two adj chars and check for palindromic string. If we
consider dd as middle elements then new string will look like abcddcba.
We are not using substring and concatination hence it will be more effective than the previous
solition.
*/

  /*
  Consider N = 7. When idx = 5 then after decrement idx = 4, when idx = 0 then after decrement
  idx = 6.
  */

//  int decrement_index(int idx, int N)
//  {
//    return (idx - 1 + N) % N;
//  }

  /*
  Consider N = 7. When idx = 5 then after increment idx = 6, when idx = 6 then after increment
  idx = 0.
  */

//  int increment_index(int idx, int N)
//  {
//    return (idx + 1) % N;
//  }

//  int check_if_rotated(string s)
//  {
//    int N = s.length();
//	/*
//	When we start from the middle element/elements checking for palindrome, how many pairs we need
//	to check. Take example of both odd and even and will get it.
//	*/
//    int steps = (N + 1) / 2;
//
//    for (int i = 0; i < N; i++)
//    {
//      int l = i;
//      int r = i;
//      if (N % 2 == 0)
//      {
//        // N is even then two elements!
//        r = increment_index(r, N);
//      }
//      bool valid = true;
//
//      for (int j = 0; j < steps && valid; j++)
//      {
//        if (s[l] != s[r])
//        {
//          valid = false;
//        }
//        else
//        {
//          l = decrement_index(l, N);
//          r = increment_index(r, N);
//        }
//      }
//      if (valid == true)
//      {
//        return 1;
//      }
//    }
//    return 0;
//  }
  //------------------------Other more optimal solution -------------------------------//

}
