/**
 * Shortest Distance From the Guard
 *
 *
 *
 * Problem Statement:
 *
 *
 *
 * You are given a 2D character grid of size n * m. Each element of the grid is either a GUARD, an OPEN space or a WALL. Every GUARD can move up, down, left and right in the open space. They cannot move on the wall.
 *
 *
 *
 * Find, for every cell, the distance from the nearest guard cell. Consider -1 as this distance for WALL cells and unreachable cells.
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
 * You will be given a string array rowStr of size n, where each string rowStr[i] is of length m. rowStr represents the grid. Each character in the grid will be G, O or W.
 *
 *
 *
 * G - Guard
 *
 * O - Open space
 *
 * W - Wall
 *
 *
 *
 * Output Format:
 *
 *
 *
 * Return 2D integer array resArr, of size n * m, where resArr[i][j] representing the distance from cell in ith row and jth column to its nearest guard.
 *
 * Put -1 in case of wall cells and unreachable cells.
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
 * The first line of input should contain an integer n, denoting no. of rows in input grid, which is also a size of array rowStr. In next n lines, ith line should contain a string rowStr[i], denoting value at index i of rowStr.
 *
 *
 *
 * If n = 5, m = 5 and rowStr = [“OOOOG”, “OWWOO”, “OOOWO”, “GWWWO”, “OOOOG”], then input should be:
 *
 *
 *
 * 5
 *
 * OOOOG
 *
 * OWWOO
 *
 * OOOWO
 *
 * GWWWO
 *
 * OOOOG
 *
 *
 *
 * Output Format:
 *
 *
 *
 * Let’s denote dimensions of resArr as nOutput * mOutput, where resArr is the result array returned by solution function.
 *
 *
 *
 * There will be nOutput lines of output, where ith line contains mOutput space separated integers. So, jth integer in ith line is value resArr[i][j], denoting value at index (i, j) of resArr.
 *
 *
 *
 * For input n = 5, m = 5 and rowStr = [“OOOOG”, “OWWOO”, “OOOWO”, “GWWWO”, “OOOOG”], output will be:
 *
 *
 *
 * 3 3 2 1 0
 *
 * 2 -1 -1 2 1
 *
 * 1 2 3 -1 2
 *
 * 0 -1 -1 -1 1
 *
 * 1 2 2 1 0
 *
 *
 *
 * Constraints:
 *
 * 1 <= n, m <= 10^3
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
 * OOOOG
 *
 * OWWOO
 *
 * OOOWO
 *
 * GWWWO
 *
 * OOOOG
 *
 *
 *
 * Sample Output 1:
 *
 *
 *
 * 3 3 2 1 0
 *
 * 2 -1 -1 2 1
 *
 * 1 2 3 -1 2
 *
 * 0 -1 -1 -1 1
 *
 * 1 2 2 1 0
 *
 *
 *
 * Explanation 1:
 *
 *
 *
 * All the walls are -1. All other cells have the minimum distance to a Guard.
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
 * GWOWG
 *
 *
 *
 * Sample Output 2:
 *
 *
 *
 * 0 -1 -1 -1 0
 *
 *
 *
 * Explanation 2:
 *
 *
 *
 * Open space at the middle is unreachable for the guards.
 */

/**
 * Editorial by IK
 * If you are getting wrong answer then first thing to check is that you are using appropriate data type to store the values. int will not work, need to use long long int.
 *
 *
 *
 * Given graph is dag. In dag we can divide our nodes in different levels, with "each edge" going from upper level to lower level.
 *
 *
 *
 * So we can start updating maximum length level wise, starting from upper level and then moving to level below it!
 *
 *
 *
 * To divide nodes level wise with each edge going from upper level to lower level, we can use topological sort!
 *
 *
 *
 * For more clear idea have a look at the solution provided by us.
 *
 *
 *
 * Time complexity of the solution is O(number of nodes in dag + number of edges in dag) and that can be re-written as O(number of edges in dag) from given constraints.
 *
 *
 *
 * Auxiliary space used by the solution is O(number of nodes in dag + number of edges in dag) and that can be re-written as O(number of edges in dag) from given constraints.
 *
 *
 *
 * Space complexity of the solution is also O(number of nodes in dag + number of edges in dag) and that can be re-written as O(number of edges in dag) from given constraints.
 *
 *
 *
 * Note that we should not write any of them as O(numberber of nodes in dag) because number of edges in dag can be way larger than number of nodes!
 */

import java.util.LinkedList;
public class ShortestDistanceFromGuard {

  /*
   * Complete the find_shortest_distance_from_a_guard function below.
   */

//  static class Cell{
//    int x, y, dist;
//    public Cell(int x, int y, int dist){
//      this.x=x;
//      this.y=y;
//      this.dist=dist;
//    }
//  }
//
//  private static int[] rowDirections = new int[]{0,0,-1,1};
//  private static int[] colDirections = new int[]{1,-1,0,0};
//
//  public static int[] find_shortest_distance_from_a_guard(char[][] grid) {
//    Queue<Cell> q = new LinkedList<Cell>();
//    int rows = grid.length;
//    int cols = grid[0].length;
//    int[][] output = new int[rows][cols];
//
//    for(int i=0; i<rows; i++){
//      for(int j=0;j<cols; j++){
//        if(grid[i][j] == 'G'){
//          q.add(new Cell(i,j,0));
//          output[i][j] = 0;
//        }
//        else
//          output[i][j] = -1;
//      }
//    }
//
//    while(!q.isEmpty()){
//      Cell current = q.poll();
//      for(int k=0;k<4;k++){
//        int i = current.x+rowDirections[k];
//        int j = current.y+colDirections[k];
//
//        if(isValid(i,j,rows,cols) && isOpen(i,j,rows,cols,grid) && output[i][j]!= -1){
//          int d = current.dist + 1;
//          output[i][j] = d;
//          q.add(new Cell(i,j,d));
//        }
//      }
//    }
//    //How to I return a single dimensional output array???????
//    return output;
//  }
//
//  private static boolean isValid(int x, int y, int rows, int cols){
//    if(x<0 || x>=rows || y<0 || y>=cols)
//      return false;
//    return true;
//  }
//
//  private static boolean isOpen(int x, int y, int rows, int cols, char[][] grid){
//    if(grid[x][y] != 'O')
//      return false;
//    return true;
//  }

}
