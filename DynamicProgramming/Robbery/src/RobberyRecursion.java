/**
 * Robbery
 *
 *
 *
 * Problem Statement:
 *
 *
 *
 * There are n houses built in a line, each of which contains some value in it. A thief is going to steal the maximal value in these houses, but he cannot steal in two adjacent houses because the owner of a stolen house will tell his two neighbors on the left and right side. What is the maximal stolen value?
 *
 *
 *
 * For example, if there are four houses with values [6, 1, 2, 7], the maximal stolen value is 13, when the first and fourth houses are stolen.
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
 * You will be given an array of integer values, containing the value in each house.
 *
 *
 *
 * Output Format:
 *
 *
 *
 * Return an integer max, denoting the maximum possible robbery.
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
 * The first line of input should contain a number n, denoting the number of houses. In next n lines, ith line should contain a number values[i], denoting ith index entry in values, i=(0,1,...,n-1).
 *
 *
 *
 * If n = 4 and values = [6, 1, 2, 7], then input should be:
 *
 *
 *
 * 4
 *
 * 6
 *
 * 1
 *
 * 2
 *
 * 7
 *
 *
 *
 * Output Format:
 *
 *
 *
 * There will be one line, containing a number max, denoting the result returned by solution function.
 *
 *
 *
 * For input n = 4 and values = [6, 1, 2, 7], output will be:
 *
 *
 *
 * 13
 *
 *
 *
 * Constraints:
 *
 *
 *
 * 1 <= n <= 10^5
 * 1 <= values[i] <= 10^4
 *
 *
 * Sample Test Case:
 *
 *
 *
 * Sample Test Case 1:
 *
 *
 *
 * Sample Input 1:
 *
 *
 *
 * values = [6, 1, 2, 7]
 *
 *
 *
 * Sample Output 1:
 *
 *
 *
 * 13
 *
 *
 *
 * Explanation 1:
 *
 *
 *
 * Steal from the first and the last house.
 *
 *
 *
 * Sample Test Case 2:
 *
 *
 *
 * Sample Input 2:
 *
 *
 *
 * values = [1, 2, 4, 5, 1]
 *
 *
 *
 * Sample Output 2:
 *
 *
 *
 * 7
 *
 *
 *
 * Explanation 2:
 *
 *
 *
 * Steal from the second and the fourth house.
 */

/**
 * Editorial section by IK
 *
 *
 Recursive solution



 A function f(i) is defined to denote the maximal stolen value from the first house to the ith house, and the value contained in the ith house is denoted as values[i]. When the thief reaches the ith house, he has two choices: to steal or not.



 If he steals then he will obtain

 f(i-2) + values[i]



 If he does not steal he can obtain

 f(i-1)



 Thus, the relationship can be written as

 f(i) = max(f(i-2) + values[i], f(i-1))



 Base case would be 0 and 1. We can make values[0] at 0 and max(values[0], values[1]) at 1.





 Optimal solution



 We can memoize the recurrence relationship mentioned above or build an iterative version for the same problem.

 We can see for any random x, f(x) depends on f(x-1) and f(x-2). Thus we can iteratively move from 0 to n and at each step we can have

 f[i] = max(f[i-2] + values[i], f[i-1])

 and f[n] will be the final answer.



 Space Complexity: O(length(values))

 Time Complexity: O(length(values))


 */
public class RobberyRecursion {

  public static void main(String[] args){
    int[] values = {6,1,4,7};
    int stolen = maxStolenValue(values,0);
    System.out.println(stolen);
  }

  static int maxStolenValue(int[] values, int i) {
    if(i>=values.length)
      return 0;

    int opt1 = maxStolenValue(values,i+1);
    int opt2 = values[i] + maxStolenValue(values,i+2);

    return Math.max(opt1, opt2);
  }
}
