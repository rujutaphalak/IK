/**
 * n Queen Problem
 *
 *
 *
 * Problem Statement:
 *
 *
 *
 * The n-queen problem is the problem of placing n chess queens on an n * n chessboard, so that no two queens attack each other.
 *
 *
 *
 * Your task is to find ALL possible arrangements for the n-queen problem.
 *
 *
 *
 * You have to solve this problem using recursion. (There may be other ways of solving this problem, but for the purpose of this exercise, please use recursion only).
 *
 *
 *
 * A queen can move horizontally, vertically, or diagonally.
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
 * There is only one argument denoting integer n.
 *
 *
 *
 * Output Format:
 *
 *
 *
 * Return 2D string array res, of size m * n, where length of each string is n and m is the total no. of distinct arrangements possible.
 *
 *
 *
 * Each character in res[i][j] describes a square on chessboard. So, any character in string should be one of {'q', '-'}. Character 'q' means queen is present on it and character '-' means it is empty.
 *
 *
 *
 * To be precise, character at kth position of string res[i][j] describes content of square in kth column of jth row of chessboard in ith arrangement.
 *
 *
 *
 * (To be more clear about the output, look at the sample test case.)
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
 * The first and only line of input should contain an integer n.
 *
 *
 *
 * If n = 4, then input should be:
 *
 *
 *
 * 4
 *
 *
 *
 * Output Format:
 *
 *
 *
 * There will be (m*(n+1)) lines of output, describing m different possible arrangements. Order of printing of arrangements will be as per order in res array, i.e. res[0], res[1], …, res[m-1].
 *
 *
 *
 * For ith arrangement (described by res[i]):
 *
 * There will be total n + 1 lines. In first n lines, jth line contains a string res[i][j], denoting string at index j of res[i]. Last line will be an empty line.
 *
 *
 *
 * For input n = 4, output will be:
 *
 *
 *
 * -q--
 *
 * ---q
 *
 * q---
 *
 * --q-
 *
 *
 *
 * --q-
 *
 * q---
 *
 * ---q
 *
 * -q--
 *
 *
 *
 *
 *
 * Constraints:
 *
 * 1 <= n <= 13
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
 * Suppose name of the returned array is ret.
 *
 *
 *
 * ret [0] =
 *
 *
 *
 * [
 *
 * "--q-",
 *
 * "q---",
 *
 * "---q",
 *
 * "-q--"
 *
 * ]
 *
 *
 *
 * ret [1] =
 *
 *
 *
 * [
 *
 * "-q--",
 *
 * "---q",
 *
 * "q---",
 *
 * "--q-"
 *
 * ]
 *
 *
 *
 * Explanation:
 *
 *
 *
 * There are 2 possible solutions for 4 queen problem, hence size of ret is 2 * 4, and length of each string is 4.
 *
 *
 *
 * ret [i] will denote ith arrangement.
 *
 * ret [i][j] will denote jth row of ith arrangement.
 *
 * ret [i][j][k] will denote kth character (if it is a queen or empty cell) of jth row in ith arrangement.
 *
 *
 *
 * You need not to worry about the order of arrangements in your returned. So output
 *
 *
 *
 * ret [0] =
 *
 *
 *
 * [
 *
 * "-q--",
 *
 * "---q",
 *
 * "q---",
 *
 * "--q-"
 *
 * ]
 *
 *
 *
 * ret [1] =
 *
 *
 *
 * [
 *
 * "--q-",
 *
 * "q---",
 *
 * "---q",
 *
 * "-q--"
 *
 * ]
 *
 *
 *
 * will also be considered as a valid answer.
 *
 *
 *
 * Notes:
 *
 * Suggested time in interview: 30 minutes; this is only a variation of permutations problems
 *
 * The “Suggested Time” is the time expected to complete this question during a real-life interview, not now in homework i.e. For the first attempt of a given homework problem, the focus should be to understand what the problem is asking, what approach you are using, coding it, as well as identifying any gaps that you can discuss during a TC session. Take your time, but limit yourself to 2 one hour sessions for most problems.
 *
 *
 *
 * For slow languages like Python, test case having n = 13, might not pass, so if your solution passes all other test cases, then consider your solution as correct solution.
 */

/**
 * Editorial - BY IK - Solution explanation
 *
 We have provided 3 solutions for the problem (other_solution.cpp, optimal_solution.cpp and optimal_solution2.cpp), all of them uses backtracking.



 optimal_solution.cpp is an improvement over other_solution.cpp.



 Queen can move horizontally, vertically, or diagonally.



 No two queens to attack each other, we need to satisfy the following conditions:



 1) There must be only one queen in one row.

 2) There must be only one queen in one column.

 3) There must be only one queen in diagonal from top-left to bottom-right (that is like \ , so we will call it back-slash diagonal.)

 4) There must be only one queen in diagonal from top-right to bottom-left (that is like / , so we will call it slash diagonal.)



 We can start placing queens row wise, from top row to bottom row. Once we have placed any queen in any row we will move to next next row. (So this will ensure that condition 1 is satisfied!) Now for condition 2, 3 and 4 we can perform a check before placing queen at any position.



 This was very basic overview. Once look at the other_solution.cpp and it will be more clear.



 In other_solution.cpp, is_safe function will visit one slash diagonal, one back-slash diagonal and one column, to check if there is any clash. So this function is O(n). But it can be easily reduced to O(1). Let's see how.



 Lets take n = 5,



 so matrix 5 * 5, with positions will look like:



 00 01 02 03 04

 10 11 12 13 14

 20 21 22 23 24

 30 31 32 33 34

 40 41 42 43 44



 1) identify column of element matrix[row][col] as:



 0 1 2 3 4

 0 1 2 3 4

 0 1 2 3 4

 0 1 2 3 4

 0 1 2 3 4



 that is column id = "col".



 2) identify slash diagonal of element matrix[row][col] as:



 0 1 2 3 4

 1 2 3 4 5

 2 3 4 5 6

 3 4 5 6 7

 4 5 6 7 8



 that is slash diagonal id = "row + col".



 3) identify back-slash diagonal of element matrix[row][col] as:



 4 3 2 1 0

 5 4 3 2 1

 6 5 4 3 2

 7 6 5 4 3

 8 7 6 5 4



 that is back-slash diagonal id = "row - col + n - 1".



 Number of columns are n (from 0 to n - 1).

 Number of slash and back-slash diagonals are 2*n - 1 (from 0 to 2*n - 2).



 Now we can take 3 boolean vectors, one for columns, one for slash diagonals and one for back-slash diagonals.

 When we put any queen we can mark appropriate column, slash diagonal and back-slash diagonal as occupied.

 Now in is_safe function instead of looping, we only need to check if any of the column, slash diagonal or back-slash diagonal is used or not.



 Have a look at the optimal_solution.cpp and it will be more clear.



 Now let's discuss optimal_solution2.cpp.



 We know that in one row we will have only one queen (and total n queens), so instead of 2-D grid we can store the information of queens' position in 1D array.



 Grid:



 --q-

 q---

 ---q

 -q--



 has queens at positions,

 row -> col



 0 -> 2,

 1 -> 0,

 2 -> 3,

 3 -> 1



 In a 1D array it can be represented as:



 arrangement[0] = 2,

 arrangement[1] = 0,

 arrangement[2] = 3,

 arrangement[3] = 1



 So we have the same information now stored in 1D array (space O(n)) instead of 2D array (space O(n^2)).



 In this problem, we are asked to return actual grids as answer. So, in this solution what we are doing is that first generate all arrangements in 1D and then generate 2D arrangements from 1D arrangements. But in optimal_solution.cpp, we are directly generating it. So when we are asked to return the actual grids, this solution is not the best. optimal_solution.cpp is better.



 But think about the similar question where we are asked to return positions of the n queens as answer (not the actual grids). Here optimal_solution2.cpp will be better than both other_solution.cpp and optimal_solution.cpp! Because other_solution.cpp and optimal_solution.cpp will first generate 2D grids and then convert to positions, but optimal_solution2.cpp will directly find positions, avoiding 2d grids (of O(n^2) space)!



 For all three solutions:



 Time Complexity is exponential. (Exact bound is complex to derive and explain.)



 Auxiliary Space Used is also exponential, as we are storing the valid solutions. (Exact bound is complex to derive and explain.)



 Space Complexity is also exponential, as auxiliary space used is also exponential. (Exact bound is complex to derive and explain.)



 (If you are looking at other solutions online and wondering why they are faster, then pay attention that they are printing only ONE VALID arrangement, not all possible arrangements!)
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class nQueens {

  public static void main(String[] args) {
    int n = 4;
    String[][] arr = nQueens(n);
    for (int i = 0; i < arr.length; i++) {
      System.out.println(Arrays.toString(arr[i]));
    }
  }

  private static String[][] nQueens(int n) {
    int[] board = new int[n];
    List<String[]> result = new ArrayList<>();
    //Initialize the board to -1
    for (int i = 0; i < n; i++) {
      board[i] = -1;
    }

    nQueensRec(board, 0, result);
    return result.toArray(new String[result.size()][]);
  }

  private static List<String[]> nQueensRec(int[] board, int col, List<String[]> result) {

    if (col == board.length) {
      String[] innerResult = new String[board.length];
      char[] c = new char[board.length];

      for (int i = 0; i < board.length; i++) {
        for (int j = 0; j < board.length; j++) {
          if (board[i] == j)
            c[j] = 'q';
          else
            c[j] = '-';
        }
        innerResult[i]=new String(c);
      }
      result.add(innerResult);
      return result;
    }

    for (int row = 0; row < board.length; row++) {
      board[col] = row;
      if (validQueenPosition(board, col)) {
        nQueensRec(board, col + 1, result);
      }
    }
    return result;
  }

  private static boolean validQueenPosition(int[] board, int col) {
    //if any other queen is diagonal or on the same row, it is invalid
    for (int i = 0; i < col; i++) {
      if (board[col] == board[i] || (col - i == Math.abs(board[i] - board[col])))
        return false;
    }
    return true;
  }
}

//  private static void nQueens(int n){
//    board = new int[n];
//    //Initialize the board to -1
//    for(int i=0; i<n; i++){
//      board[i] = -1;
//    }
//
//    nQueensRec(board, 0);
//  }
//
//  private static void nQueensRec(int[] board, int col) {
//
//    if(col == board.length){
//      System.out.println("n queens placed on the board");
//      for(int i=0; i<board.length; i++){
//        System.out.print(board[i]+" ");
//      }
//      return;
//    }
//
//    for(int row=0; row<board.length; row++) {
//      board[col] = row;
//      if (validQueenPosition(board, col)) {
//        nQueensRec(board, col + 1);
//      }
//    }
//  }
//
//  private static boolean validQueenPosition(int[] board, int col) {
//    //if any other queen is diagonal or on the same row, it is invalid
//    for(int i=0;i<col;i++){
//      if(board[col] == board[i] || (col - i == Math.abs(board[i] - board[col])))
//        return false;
//    }
//    return true;
//  }
//}
