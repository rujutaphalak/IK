/**
 * Pascal's Triangle
 *
 *
 *
 * Problem Statement:
 *
 *
 *
 * Pascal’s triangle is a triangular array of the binomial coefficients. Write a function that takes an integer value n as
 *
 * input and returns 2d Array representing pascal’s triangle.
 *
 *
 *
 * pascalTriangleArray is a 2D array of size n*n, where
 *
 * pascalTriangleArray[i][j] = BinomialCoefficient(i, j); if j<=i,
 *
 * pascalTriangleArray[i][j] = 0; if j>i
 *
 *
 *
 * Following are the first 6 rows of Pascal’s Triangle:
 *
 *
 *
 * 1
 *
 * 1 1
 *
 * 1 2 1
 *
 * 1 3 3 1
 *
 * 1 4 6 4 1
 *
 * 1 5 10 10 5 1
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
 * There is only one argument n, denoting the number of lines of Pascal's triangle to be considered.
 *
 *
 *
 * Output Format:
 *
 *
 *
 * Return an 2d integer array result, denoting pascal’s triangle where each value of result 2d array must be modulo with (10^9 + 7).
 *
 *
 *
 * Size of result[i] for 0 <= i < n should be (i + 1) i.e. 0s for pascalTriangleArray[i][j] = 0; if j>i, should be ignored.
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
 * There should be one line for input, containing a single integer n, denoting the number of lines of Pascal's triangle to be considered.
 *
 *
 *
 * If n = 6, then input should be:
 *
 *
 *
 * 6
 *
 *
 *
 * Output Format:
 *
 *
 *
 * There will be 2d array of integers, where each row of result 2d array will denotes row of pascal’s triangle in same order.
 *
 *
 *
 * For input n = 6, output will be:
 *
 *
 *
 * 1
 *
 * 1 1
 *
 * 1 2 1
 *
 * 1 3 3 1
 *
 * 1 4 6 4 1
 *
 * 1 5 10 10 5 1
 *
 *
 *
 * Constraints:
 *
 *
 *
 * 1 <= n <= 1700
 *
 *
 * Sample Test Cases:
 *
 *
 *
 * Sample Input 1:
 *
 *
 *
 * 4
 *
 *
 *
 * Sample Output 1:
 *
 *
 *
 * 1
 *
 * 1 1
 *
 * 1 2 1
 *
 * 1 3 3 1
 *
 *
 *
 * Explanation 1:
 *
 *
 *
 * Pascal's Triangle for given n=4:
 *
 * Using equation,
 *
 * pascalTriangleArray[i][j] = BinomialCoefficient(i, j); if j<=i,
 *
 * pascalTriangleArray[i][j] = 0; if j>i
 *
 * Generated pascal’s triangle will be:
 *
 * 1
 *
 * 1 1
 *
 * 1 2 1
 *
 * 1 3 3 1
 *
 *
 *
 * Sample Input 2:
 *
 *
 *
 * 6
 *
 *
 *
 * Sample Output 2:
 *
 *
 *
 * 1
 *
 * 1 1
 *
 * 1 2 1
 *
 * 1 3 3 1
 *
 * 1 4 6 4 1
 *
 * 1 5 10 10 5 1
 *
 *
 *
 * Explanation 2:
 *
 *
 *
 * Pascal's Triangle for given n=6:
 *
 * Using equation,
 *
 * pascalTriangleArray[i][j] = BinomialCoefficient(i, j); if j<=i,
 *
 * pascalTriangleArray[i][j] = 0; if j>i
 *
 * Generated pascal’s triangle will be:
 *
 * 1
 *
 * 1 1
 *
 * 1 2 1
 *
 * 1 3 3 1
 *
 * 1 4 6 4 1
 *
 * 1 5 10 10 5 1
 */

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Editorial by IK
 */
public class PascalsTriangle {

  public static void main(String[] args)
  {
    int n=4;
    List<List<Integer>> result = pascalsTriangle(n);
    for(List e: result)
      System.out.println(e);
  }

  private static List<List<Integer>> pascalsTriangle(int n) {
    List<List<Integer>> result = new ArrayList<>();
    List subResult = new ArrayList<>();
    subResult.add(1);
    result.add(subResult);

    for(int i=1; i<n; i++) {
      int len = result.get(i - 1).size() + 1;
      List<Integer> prevList = result.get(i - 1);
      List<Integer> curList = new ArrayList<>();
      for (int j = 0; j < len; j++) {
        if (j == 0 || j == len - 1)
          curList.add(1);
        else
          curList.add(prevList.get(j - 1) + prevList.get(j));
      }
      result.add(curList);
    }
    return result;
  }
}
