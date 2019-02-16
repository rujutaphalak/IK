/**
 * Knight's Tour On A Chess Board
 *
 *
 *
 *
 *
 * Problem Statement:
 *
 *
 *
 * You are given a rows * cols chessboard and a knight that moves like in normal chess.
 *
 *
 *
 * Currently knight is at starting position denoted by start_row th row and start_col th col, and want to reach at ending position denoted by end_row th row and end_col th col.
 *
 *
 *
 * The goal is to calculate the minimum number of moves that the knight needs to take to get from starting position to ending position.
 *
 *
 *
 * start_row, start_col, end_row and end_col are 0-indexed.
 *
 *
 *
 * Input Format:
 *
 *
 *
 * There are six arguments. First is an integer denoting rows, second is an integer denoting cols, third is an integer denoting start_row, fourth is an integer denoting start_col, fifth is an integer denoting end_row and sixth is an integer denoting end_col.
 *
 *
 *
 * Output Format:
 *
 *
 *
 * Return an integer.
 *
 *
 *
 * If it is possible to reach from starting position to ending position then return minimum number of moves that the knight needs to take to get from starting position to ending position.
 *
 *
 *
 * If it is not possible to reach from starting position to ending position then return -1.
 *
 *
 *
 * Constraints:
 *
 *
 *
 * 1 <= rows * cols <= 10^5
 * 0 <= start_row, end_row < rows
 * 0 <= start_col, end_col < cols
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
 * rows = 5
 *
 * cols = 5
 *
 * start_row = 0
 *
 * start_col = 0
 *
 * end_row = 4
 *
 * end_col = 1
 *
 *
 *
 * Sample Output:
 *
 *
 *
 * 3
 *
 *
 *
 * Explanation:
 *
 *
 *
 * 3 moves to reach from (0, 0) to (4, 1):
 *
 *
 *
 * (0, 0) -> (1, 2) -> (3, 3) -> (4, 1).
 */

/**
 * Solution Explanation by IK
 * This is a simple BFS problem.
 *
 *
 *
 *  Have a look at the solution provided by us, it contains necessary comments to understand the solution.
 *
 *
 *
 *  Time Complexity:
 *
 *  O(rows * cols).
 *
 *
 *
 *  Auxiliary Space Used:
 *
 *  O(rows * cols).
 *
 *
 *
 *  Space Complexity:
 *
 *  O(rows * cols).
 *
 *  Input is O(1) and auxiliary space used is O(rows * cols). So, O(1) + O(rows * cols) -> O(rows * cols).
 *
 */

//Working solution. Do not use Set<QueueNode> for visited, as it will significantly slow down the program.
// Major Performance hit and timeout issue!
import java.util.*;

public class KnightTour {

//  static class QueueNode{
//    int x;
//    int y;
//    int dist;
//
//    public QueueNode(int x, int y) {
//      this.x = x;
//      this.y = y;
//    }
//
//    QueueNode(int x, int y, int dist) {
//      this.x = x;
//      this.y = y;
//      this.dist = dist;
//    }
//
//    int getX() {
//      return x;
//    }
//
//    void setX(int x) {
//      this.x = x;
//    }
//
//     int getY() {
//      return y;
//    }
//
//    void setY(int y) {
//      this.y = y;
//    }
//
//    int getDist() {
//      return dist;
//    }
//
//    void setDist(int dist) {
//      this.dist = dist;
//    }
//  }
//
//  private static int find_minimum_number_of_moves(int rows, int cols, int start_row, int start_col, int end_row, int end_col) {
//    int row[] = {2, 2, -2, -2, 1, 1, -1, -1};
//    int col[] = {-1, 1, 1, -1, 2, -2, 2, -2};
//
//    Queue<QueueNode> queue = new LinkedList<>();
//    boolean[][] visited = new boolean[rows][cols];
//
//    queue.add(new QueueNode(start_row, start_col, 0));
//
//    while (!queue.isEmpty()) {
//      QueueNode qNode = queue.poll();
//      int x = qNode.getX();
//      int y = qNode.getY();
//
//      //if the node in the queue has the target co-ordinates return the dist value from the node which is the max distance
//      if (x == end_row && y == end_col)
//        return qNode.getDist();
//
//      if (!visited[x][y]) {
//        visited[x][y] = true;
//        for (int i = 0; i < 8; i++) {
//
//          List<QueueNode> neighbors = getNeighbors(x, y, rows, cols, row,
//              col);
//          for (QueueNode node : neighbors) {
//            int qX = node.getX();
//            int qY = node.getY();
//            boolean validNeighbor = isValidNeighbor(qX, qY, rows, cols);
//            if (validNeighbor)
//              queue.add(new QueueNode(qX, qY, qNode.getDist() + 1));
//          }
//        }
//      }
//    }
//    return -1;
//  }
//
//  private static List<QueueNode> getNeighbors(int x, int y, int rows, int cols, int[] row, int[] col) {
//    List<QueueNode> list = new ArrayList<>();
//    for(int i=0; i < row.length; i++){
//      int neighborX = x + row[i];
//      int neighborY = y + col[i];
//      list.add(new QueueNode(neighborX,neighborY));
//    }
//    return list;
//  }
//
//  private static boolean isValidNeighbor(int nX, int nY, int rows, int cols){
//    if(nX >= 0 && nX < rows && nY >= 0 && nY < cols)
//      return true;
//    else
//      return false;
//  }

  static class QueueNode{
    int x;
    int y;
    int dist;

    public QueueNode(int x, int y) {
      this.x = x;
      this.y = y;
    }

    QueueNode(int x, int y, int dist) {
      this.x = x;
      this.y = y;
      this.dist = dist;
    }

    int getX() {
      return x;
    }

    void setX(int x) {
      this.x = x;
    }

    int getY() {
      return y;
    }

    void setY(int y) {
      this.y = y;
    }

    int getDist() {
      return dist;
    }

    void setDist(int dist) {
      this.dist = dist;
    }
  }

  private static int find_minimum_number_of_moves(int rows, int cols, int start_row, int start_col, int end_row, int end_col) {
    int row[] = {2, 2, -2, -2, 1, 1, -1, -1};
    int col[] = {-1, 1, 1, -1, 2, -2, 2, -2};

    Queue<QueueNode> queue = new LinkedList<>();
    boolean[][] visited = new boolean[rows][cols];

    queue.add(new QueueNode(start_row, start_col, 0));

    while (!queue.isEmpty()) {
      QueueNode qNode = queue.poll();
      int x = qNode.getX();
      int y = qNode.getY();

      //if the node in the queue has the target co-ordinates return the dist value from the node which is the max distance
      if (x == end_row && y == end_col)
        return qNode.getDist();

      for(QueueNode neighbor : getNeighbors(x, y, rows, cols, row, col)) {
        int qX = neighbor.getX();
        int qY = neighbor.getY();
        boolean validNeighbor = isValidNeighbor(qX, qY, rows, cols);
        if(validNeighbor && !visited[qX][qY]){
          visited[qX][qY] = true;
          queue.add(new QueueNode(qX, qY, qNode.getDist() + 1));
        }
      }
    }
    return -1;
  }

  private static List<QueueNode> getNeighbors(int x, int y, int rows, int cols, int[] row, int[] col) {
    List<QueueNode> list = new ArrayList<>();
    for(int i=0; i < row.length; i++){
      int neighborX = x + row[i];
      int neighborY = y + col[i];
      list.add(new QueueNode(neighborX,neighborY));
    }
    return list;
  }

  private static boolean isValidNeighbor(int nX, int nY, int rows, int cols){
    if(nX >= 0 && nX < rows && nY >= 0 && nY < cols)
      return true;
    else
      return false;
  }


  public static void main(String[] args)
  {
    int rows = 5, cols = 5, start_row = 0, start_col = 0, end_row = 4, end_col = 1;
    System.out.println("Minimum number of steps required is " +
        find_minimum_number_of_moves(5,5,0,0,4,1));
  }
}
