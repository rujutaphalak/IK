/**
 * Shortest Path In 2D Grid With Keys And Doors
 *
 *
 *
 * Problem Statement:
 *
 *
 *
 * Given a 2D grid, that represents a maze-like area. Each cell in the grid can be either land or water or door or key to some doors.
 *
 *
 *
 * Each type of key will only open one type of door. There can be multiple identical keys of the same type. There can also be multiple doors of the same type.
 *
 *
 *
 * There is also a start cell and a goal cell on the land.
 *
 *
 *
 * You have to find the shortest path from start to the goal.
 *
 *
 *
 * Input Format:
 *
 *
 *
 * There is only one argument denoting the grid.
 *
 *
 *
 * Cells in the grid can be described as:
 *
 * '#' = Water.
 * '.' = Land.
 * 'a' = Key of type 'a'. All lowercase letters are keys.
 * 'A' = Door that opens with key 'a'. All uppercase letters are doors.
 * '@' = Starting cell.
 * '+' = Ending cell (goal).
 *
 *
 * Output Format:
 *
 *
 *
 * Return a 2D array containing the path from start to goal.
 *
 *
 *
 * Suppose your path contains N cells, then output array should be of size N * 2, where (array[i][0], array[i][1]) describes a cell position.
 *
 *
 *
 * Positioning of cells:
 *
 * 0-indexed.
 *
 * Columns: Increasing from left to right.
 *
 * Rows: Increasing from top to bottom.
 *
 *
 *
 * There can be multiple shortest paths, so you are free to return any of them.
 *
 *
 *
 * Constraints:
 *
 *
 *
 * You can only travel on land cells, key cells and door cells, and not on water cells.
 * You can travel in any of the four directions (including backwards), but not diagonally.
 * It is okay to revisit a cell, if you need to (you can go backwards).
 * You cannot travel thru a door, unless you have picked up the key to that door before arriving there.
 * If you have picked up a certain type of key, then it can be re-used on multiple doors of same kind.
 * 1 <= number of rows, number of columns <= 100
 * There will be exactly one starting point and one goal.
 * It is guaranteed that there exists a path from start to goal.
 * 'a' <= key <= 'j'
 * 'A' <= door <= 'J'
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
 * ...B
 * .b#.
 * @#+.
 *
 *
 *
 *
 * Sample Output:
 *
 *
 *
 * [
 *
 *   [2 0],
 *
 *   [1 0],
 *
 *   [1 1],
 *
 *   [0 1],
 *
 *   [0 2],
 *
 *   [0 3],
 *
 *   [1 3],
 *
 *   [2 3],
 *
 *   [2 2]
 *
 * ]
 *
 *
 *
 * Explanation:
 *
 *
 *
 * In order to pass through door 'B', we first need to collect key to open that door and that is 'b'.
 *
 *
 *
 * '@' -> '.' -> 'b' -> '.' -> '.' -> 'B' -> '.' -> '.' -> '+'
 *
 *
 *
 * Here position [2 0] is '@' in the grid above, which is the starting position.
 */

/**
 * Solution Explanation by IK
 *
 If there are no keys and doors then solution would be a simple BFS.



 Now lets think about the original problem.



 To solve the original problem also, we can use BFS, but with some modifications!



 There can be only 10 different keys ('a' to 'j'). So we can use bitmasking to store the keys. Specifically we can use int to store the keys that we already have (call that int as ring_of_keys). If we have only key of type 'a' then ring_ok_keys would be 000..000001 in binary representation, if we have two keys 'a' and 'd' then ring_of_keys would be 000..001001 in binary representation. Here we will use 10 least significant bits to store the keys.



 Now lets think about BFS when neighbour cell is:

 1) Water: Simply return because we can not use water cell.

 2) Land (not key and not door): Continue BFS. Visit(update/add/consider) its neighbours.

 3) Start: Consider it as land cell.

 4) Stop: Return and update ans.

 5) Door: Check if corresponding key is present in the ring_of_keys or not, if yes then treat it as land cell else treat it as water cell. We can check it using

 if ((ring_of_keys >> (grid[r][c] - 'A')) & 1)

 treat as land

 else

 treat as water

 6) Key: This is the part where we need to pay attention. If we already have collected the same type of key then consider it as a land cell because it does not change anything, else we need to do something more. If we have found a new key then it might be possible that in past during BFS, somewhere we were not able to go thru door but now we can because that can be opended by this key. So we need to reconsider the visited cells "and" continue visiting unvisited cells also.

 if ((ring_of_keys >> (grid[r][c] - 'a')) & 1)

 treat as land

 else

 revisit visited cells and continue BFS



 Now first have a look at the "exponential solution" provided by us (brute_force.java). That uses DFS but idea is almost same. This will help you understand the basic idea.



 This solution will only work for smaller constraints. Problem with this solution is that it does lots of re computation.



 Now let's think about optimized solution.



 Let's take dp[r][c][ring_of_keys] as shortest path from starting point to current point denoted by (r, c), where we have already collected keys present in ring_of_keys.



 Base case is dp[start_r][start_c][0] = 0. Set others as INFINITY, now do BFS!



 During BFS when neighbour cell is:

 1) Water: Simply return because we can not use water cell.

 2) Land: Add that cell and update it. We can go to that neighbour cell by taking one more step! And we will also have all the keys. So that can be done as,

 dp[neighbout_r][neighbour_c][ring_of_keys] = dp[cur_r][cur_c][ring_of_keys] + 1.

 3) Start: Consider it as land cell.

 4) Stop: Return and update ans.

 5) Door: Check if corresponding key is present in the ring_of_keys or not, if yes then treat it as land cell else treat it as water cell.

 6) Key: If we already have collected the same type of key then consider it as a land cell because it does not change anything, else update differently. Add the key to our ring_of_keys (let's say new_ring_of_keys). So that can be done as,

 dp[neighbour_r][neighbour_c][new_ring_of_keys] = dp[cur_r][cur_c][ring_of_keys] + 1.



 In normal BFS we do not visit previously visited cell again, here we will not visit previously visited "state" again, which means we will not visit dp[r][c][ring_of_keys] if it is already visited (but here it is possible that same node is visited again!).



 Lets take very small example.

 Grid = "a@A+" now initially we have,

 dp[0][1][0] = 0, (we are at the starting position and we don't have any key)

 now from '@' 'a' will be updated hence,

 dp[0][0][1] = 1, (we are at 'a' and we have collected one key)

 now this will update '@',

 dp[0][1][1] = 2, (again we are at the starting position and we have collected one key)

 so '@' is visited again.



 Now have a look at the optimal_solution.cpp. It will give more clear idea about the solution.



 Time complexity, auxiliary space used and space complexity of the solution is O(number of rows * number of cols * 2^(number of different keys possible that is 10 in our case)).
 */
//IK solution sample ink http://oj.interviewkickstart.com/view_top_submission/513/119/21769/

//Not working
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Collections;

public class ShortestPathIn2DGrid {

  static char[][]  charGrid;
  static int[] rowDirection = {-1, 0, 1, 0};
  static int[] colDirection = {0, -1, 0, 1};
  static List<int[]> paths = new ArrayList<int[]>();

  static class Cell{
    int x;
    int y;
    int dist;
    int keyRing;
    Cell parent;

    public Cell(int x, int y, int dist, int keyRing) {
      this.x = x;
      this.y = y;
      this.dist = dist;
      this.keyRing = keyRing;
    }

    public Cell(int x, int y, int dist, int keyRing, Cell parent) {
      this.x = x;
      this.y = y;
      this.dist = dist;
      this.keyRing = keyRing;
      this.parent = parent;
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

    public int getKeyRing() {
      return keyRing;
    }

    public void setKeyRing(int keyRing) {
      this.keyRing = keyRing;
    }

    public Cell getParent() {
      return parent;
    }

    public void setParent(Cell parent) {
      this.parent = parent;
    }
  }

  private static int[][] find_shortest_path(String[] grid){
    //Created a 2D character grid an also found the coordinates of start cell and stored them in a static variable
    Cell startCell = createCharGrid(grid);
    bfsGridExplore(startCell);
    if (paths.size() == 0) {
      return new int[0][0];
    }

    Collections.reverse(paths);
    return paths.toArray(new int[paths.size()-1][]);
  }

  private static Cell createCharGrid(String[] grid){
      int rows = grid.length;
      int cols = grid[0].toCharArray().length;
      Cell startCell = null;
      charGrid = new char[rows][cols];

      for(int i=0; i<rows; i++){
        for(int j=0; j<cols; j++){
          charGrid[i][j] = grid[i].charAt(j);
          if(charGrid[i][j] == '@')
            startCell = new Cell(i,j,0,0);
        }
      }
      return startCell;
  }

//  static void bfsGridExplore(Cell startCell) {
//    // this is 0000000000 (10bits to represent a key). Every other 1 bit shift represents the letter a-j
//    boolean visited[][][] = new boolean[charGrid.length][charGrid[0].length][1024];
//
//    Queue<Cell> queue = new LinkedList<>();
//    startCell.setDist(0);
//    startCell.setKeyRing(0);
//    queue.add(startCell);
//    visited[startCell.getX()][startCell.getY()][0] = true;
//
//    while(!queue.isEmpty()){
//      Cell popped = queue.poll();
//      char poppedChar = charGrid[popped.getX()][popped.getY()];
//
//      //This is Optimization that prevents all distant points from being tried.
//      if(paths.size() != 0 && paths.size() <= popped.getDist()) continue;
//      if( poppedChar == '+'){
//        //do things to check if steep if current path is shorter than the one
//        //return that path.
//        if(paths.size() == 0 || paths.size() > popped.getDist())
//          paths.clear();
//          while (popped != null) {
//          paths.add(new int[]{popped.getX(), popped.getY()});
//          popped = popped.parent;
//        }
//        continue;
//      }
//
//      for(Cell neighbor: getValidNeighbors(popped, charGrid.length, charGrid[0].length, visited)){
//        int neighborRow = neighbor.getX();
//        int neighborCol = neighbor.getY();
//
//        if(!visited[neighbor.getX()][neighbor.getY()][neighbor.getKeyRing()]){
//          visited[neighborRow][neighborCol][neighbor.getKeyRing()] = true;
//          queue.add(neighbor);
//        }
//      }
//    }
//  }

/*
Have eliminated some steps from the above nethod int he below method. Commented to support the step elimination.
 */
  static void bfsGridExplore(Cell startCell) {
    // this is 00000 00000 (10bits to represent keys). Every other 1 bit shift represents the letter a-j
    boolean visited[][][] = new boolean[charGrid.length][charGrid[0].length][1024];

    Queue<Cell> queue = new LinkedList<>();
    startCell.setDist(0);
    startCell.setKeyRing(0);
    queue.add(startCell);
    visited[startCell.getX()][startCell.getY()][0] = true;

    while(!queue.isEmpty()){
      Cell popped = queue.poll();
      char poppedChar = charGrid[popped.getX()][popped.getY()];

      /*This is Optimization that prevents all distant points from being tried.Even if you don't do this, it is okay*/
      if(paths.size() != 0 && paths.size() <= popped.getDist()) continue;

      /*Commented green part is not needed, bfs by default always explores the shortest path so if you find target that is going to be the shortest path as long as the valid neighbors checks are done right.
          you don't need to check if paths.size() > popped.getDist()*/
      if( poppedChar == '+'){
        /*do things to check if step if current path is shorter than the one in path, if continue it will keep exploring even after shortest path has been found*/
        // if(paths.size() == 0 || paths.size() > popped.getDist())
        //   paths.clear();
        while (popped != null) {
          paths.add(new int[]{popped.getX(), popped.getY()});
          popped = popped.parent;
        }
        return;
        // continue;
      }

      for(Cell neighbor: getValidNeighbors(popped, charGrid.length, charGrid[0].length, visited)){
        int neighborRow = neighbor.getX();
        int neighborCol = neighbor.getY();

        if(!visited[neighbor.getX()][neighbor.getY()][neighbor.getKeyRing()]){
          visited[neighborRow][neighborCol][neighbor.getKeyRing()] = true;
          queue.add(neighbor);
        }
      }
    }
  }

  private static List<Cell> getValidNeighbors(Cell popped, int rows, int cols, boolean[][][] visited) {
    List<Cell> list = new ArrayList<>();

    for (int i = 0; i < rowDirection.length; i++) {
      int neighborX = popped.getX() + rowDirection[i];
      int neighborY = popped.getY() + colDirection[i];
      if(neighborX < 0 || neighborX >= rows || neighborY < 0 || neighborY >= cols)
        continue;
      char neighborChar = charGrid[neighborX][neighborY];
      if (neighborChar == '#') continue;
      if ('A' <= neighborChar && neighborChar <= 'J'){
        if((popped.getKeyRing() & (1 << neighborChar - 'A')) == 0)
          continue;
      }
      Cell neighborCell = new Cell(neighborX, neighborY, popped.getDist()+1, popped.getKeyRing(), popped);

      if ('a' <= neighborChar && neighborChar <= 'j')
        neighborCell.setKeyRing(popped.getKeyRing() | (1 << neighborChar - 'a'));
      list.add(neighborCell);
    }
    return list;
  }

  public static void main(String[] args){
    String[] str = {"...B",
        ".b#.",
        "@#+."
    };

    int[][] shortestSteps = find_shortest_path(str);
    System.out.println(shortestSteps);
  }
}
