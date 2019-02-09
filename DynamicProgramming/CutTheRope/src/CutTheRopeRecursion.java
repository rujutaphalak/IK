/**
 * Cut The Rope
 *
 *
 *
 * Problem Statement:
 *
 *
 *
 * Given a rope with length n, find the maximum value maxProduct, that can be achieved for product len[0] * len[1] * ... * len[m - 1], where len[] is the array of lengths obtained by cutting the given rope into m parts.
 *
 *
 *
 * Note that
 *
 * there should be atleast one cut, i.e. m >= 2.
 * All m parts obtained after cut should have non-zero integer valued lengths.
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
 * There is only one argument, an integer denoting n.
 *
 *
 *
 * Output Format:
 *
 *
 *
 * Return a number maxProduct, denoting maximum possible product as asked in the problem.
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
 * There should be only one line, containing an integer n, denoting length of rope.
 *
 *
 *
 * If n = 5, then input should be:
 *
 *
 *
 * 5
 *
 *
 *
 * Output Format:
 *
 *
 *
 * There will be one line, containing an integer maxProduct.
 *
 *
 *
 * For input n = 5, output will be:
 *
 *
 *
 * 6
 *
 *
 *
 * Constraints:
 *
 * 2 <= n <= 111
 * We have to cut at least once. (2 <= m).
 * Length of the rope, as well as the length of each part are in positive integer value. (i.e. can't do partial cuts.)
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
 * 4
 *
 *
 *
 * Sample Output:
 *
 *
 *
 * 4
 *
 *
 *
 * Explanation:
 *
 * For n = 4, there are two cuts possible: 1 + 3 and 2 + 2.
 *
 * We'll pick 2 + 2, because their product 2 * 2 = 4 is greater than product of the first one 1 * 3 = 3.
 *
 * (So our m = 2, n[0] = 2 and n[1] = 2 and product is n[0] * n[1] = 4.)
 */

/**
 * Editorial section by IK
 * If getting wrong answer then first check if you are using appropriate data type in intermediate calculations. (For the given constraints integer will overflow.)
 *
 *
 *
 * We have provided three solutions:
 *
 * 1) other_solution_1.cpp: dp quadratic solution.
 *
 * 2) other_solution_2.cpp: dp linear solution. Solution from observing fixed pattern.
 *
 * 3) optimal_solution.cpp: solution from observing fixed pattern. (Even though if you are able to directly come to this solution, we expect you to write dp solution once.)
 *
 *
 *
 * Have a look at the solutions. All of them contain detailed comments.
 *
 *
 *
 *
 *
 * other_solution_1.cpp:
 *
 *
 *
 * Time Complexity:
 *
 *
 *
 * O(n^2).
 *
 * We are finding maximum product for all the rope lengths, from 1 to n.
 *
 * And to find maximum product for each rope length we are iterating over all previous rope lengths.
 *
 * So that is O(1 + 2 + 3 + ... + (n - 1)) = O(n^2).
 *
 *
 *
 *
 *
 * Auxiliary Space Used:
 *
 *
 *
 * O(n).
 *
 * Because we are using array of length n + 1.
 *
 *
 *
 *
 *
 * Space Complexity:
 *
 *
 *
 * O(n).
 *
 * Because auxiliary space used is O(n).
 *
 *
 *
 *
 *
 *
 *
 * other_solution_2.cpp:
 *
 *
 *
 * Time Complexity:
 *
 *
 *
 * O(n).
 *
 * We are finding maximum product for all the rope lengths, from 1 to n, in constant time.
 *
 * So that is O(n).
 *
 *
 *
 *
 *
 * Auxiliary Space Used:
 *
 *
 *
 * O(n).
 *
 * Because we are using array of length n + 1.
 *
 *
 *
 *
 *
 * Space Complexity:
 *
 *
 *
 * O(n).
 *
 * Because auxiliary space used is O(n).
 *
 *
 *
 *
 *
 *
 *
 * optimal_solution.cpp:
 *
 *
 *
 * Time Complexity:
 *
 *
 *
 * O(log(n)). (or more specifically O(log(n / 3)).)
 *
 * Because we are using power function.
 *
 *
 *
 *
 *
 * Auxiliary Space Used:
 *
 *
 *
 * O(log(n)).
 *
 * YES IT IS NOT O(1).
 *
 * Power function is recursive hence due to recursive function call stack it will be O(log(n)).
 *
 * Note that here we can use iterative power function to reduce the auxiliary space used to O(1).
 *
 * But for readability purpose we have used recursive power function.
 *
 *
 *
 *
 *
 * Space Complexity:
 *
 *
 *
 * O(log(n)).
 *
 * Because auxiliary space used is O(log(n)).
 *
 *
 *
 *
 *
 * Other Note:
 *
 *
 *
 * We can use direct multiplication instead of power function but its time complexity will be O(n / 3) instead of O(log(n / 3)).
 */
public class CutTheRopeRecursion {

  public static void main(String[] args){
    long n = 5;
    long maxProduct = ropeProduct(n);
    System.out.println(maxProduct);
  }

  private static long ropeProduct(long n) {

    if(n==0)
      return 0;

    if(n==1)
      return 1;

    long max=0;
    for(long part=1;part<n;part++){
      long maxProduct = Math.max(part * (n - part), part*ropeProduct(n-part),ropeProduct(part)*(n-part),ropeProduct(part) * ropeProduct(n - part)); ;
      if(maxProduct > max) {
        max = maxProduct;
      }
    }
    return max;
  }
}
