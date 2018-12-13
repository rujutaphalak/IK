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

//Not working
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Queue;

public class ShortestPathIn2DGrid {

  static int rows, cols;
  static Cell originCell;
  static Cell destinationCell;
  static int[] rowDirection = {-1, 0, 1, 0};
  static int[] colDirection = {0, -1, 0, 1};

  static class Cell{
    int x;
    int y;
    int dist;

    public Cell(int x, int y) {
      this.x = x;
      this.y = y;
    }

    Cell(int x, int y, int dist) {
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

  static int find_shortest_path(String[] grid) {
    char originChar = '@';
    char destChar = '+';
    Set<Character> keys = new HashSet<>();
    char[][] charGrid = createCharGrid(grid, originChar, destChar, keys);
    return bfsGridExplore(charGrid, originCell, destinationCell, keys);
  }

  private static char[][] createCharGrid(String[]grid, char originChar, char destChar, Set<Character> keys){
      rows = grid.length;
      cols = grid[0].toCharArray().length;
      char[][] charGrid = new char[rows][cols];

      for(int i=0; i<rows; i++){
        char[] row = grid[i].toCharArray();
        for(int j=0; j<cols; j++){
          charGrid[i][j] = row[j];
          if(charGrid[i][j] == originChar) {
            originCell = new Cell(i,j);
          }
          else if(charGrid[i][j] == destChar) {
            destinationCell = new Cell(i,j);
          }
          else if(charGrid[i][j] > 'a' && charGrid[i][j] < 'z')
            keys.add(charGrid[i][j]);
        }
      }
      return charGrid;
  }

  static int bfsGridExplore(char[][] charGrid, Cell originCell, Cell destinationCell, Set<Character> keys) {
    boolean[][] visited = new boolean[charGrid.length][charGrid[0].length];
    Queue<Cell> queue = new LinkedList<>();
    queue.add(originCell);

    while(!queue.isEmpty()){
      Cell poppedCell = queue.poll();
      int x = poppedCell.getX();
      int y = poppedCell.getY();

      if(x==destinationCell.getX() && y==destinationCell.getY())
        return destinationCell.getDist();

      if(!visited[x][y]){
        visited[x][y] = true;
        List<Cell> list = getValidNeighbors(charGrid, x,y, rows, cols, keys);
        for(Cell neighbor: list){
          neighbor.setDist(poppedCell.getDist()+1);
          queue.add(neighbor);
        }
      }
    }
    return -1;
  }

  private static List<Cell> getValidNeighbors(char[][] charGrid, int x, int y, int rows, int cols, Set<Character> keys) {
    List<Cell> list = new ArrayList<>();

    for (int i = 0; i < rowDirection.length; i++) {
      int neighborX = x + rowDirection[i];
      int neighborY = y + colDirection[i];
      if(neighborX < 0 || neighborX >= rows || neighborY < 0 || neighborY >= cols)
        continue;
      char neighborChar = charGrid[neighborX][neighborY];

      if (neighborChar != '#') {
//        if(neighborChar >='A' && neighborChar <= 'Z') {
//          char key = Character.toUpperCase(neighborChar);
//          if (!keys.contains(key))
//            continue;
//        }
      if(neighborChar >='a' && neighborChar <= 'j')
        keys.add(neighborChar);

        Cell neighborCell = new Cell(neighborX, neighborY);
        list.add(neighborCell);
        }
      }
    return list;
  }

  public static void main(String[] args){
    String[] str = {"...B",
                    ".b#.",
                    "@#+."
    };

    int shortestSteps = find_shortest_path(str);
    System.out.println(shortestSteps);
  }
}
