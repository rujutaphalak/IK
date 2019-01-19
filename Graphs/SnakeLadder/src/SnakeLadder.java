/**
 * Snakes and Ladders Matrix
 *
 *
 *
 *
 *
 * Problem Statement:
 *
 *
 *
 * Given a snake and ladder rectangular MxN board-game, find the minimum number of dice throws required to reach the final cell from the 1st cell.
 *
 *
 *
 * Rules are as usual: If after a dice-throw, the player reaches a cell where the ladder starts, the player has to climb up that ladder and if the player reaches a cell that has the mouth of the snake, s/he has to go down to the tail of snake.
 *
 *
 *
 * For example, in the board given below, it will take minimum 4 throws to reach from 1 to 36. That can be done with the following sequence of throws: (1,6,4,1). There may be more such sequences of the same length viz. (4,2,6,3) etc.
 *
 *
 *
 *
 *
 * ​
 *
 *
 *
 * Input Format:
 *
 *
 *
 * You will be given an integer n denoting the size of the board and an array of integer moves of length n, denoting if there is a ladder or a snake as follows:
 *
 * moves[i] = -1, No ladder and no snake
 * moves[i] < i, Snake from i to moves[i]
 * moves[i] > i, Ladder from i to moves[i]
 * moves array has one-based indexing.
 *
 *
 *
 * Output Format:
 *
 *
 *
 * Return an integer denoting the minimum number of dice rolls required to reach the last cell.
 *
 *
 *
 * Constraints:
 *
 *
 *
 * 1 <= n <= 10^5
 *
 * 1 <= moves[i] <= n
 *
 *
 *
 * Note:
 *
 * You start at cell 1.
 * There is no snake at the last cell and no ladder at the first cell.
 * No snake starts at the top of a ladder or bottom of a snake. No ladder starts at the bottom of the snake or top of a ladder.
 * Return -1 if there is no possible way.
 *
 *
 * Sample Test Case:
 *
 *
 *
 * Sample Input-1:
 *
 *
 *
 * n = 20
 *
 * moves = [-1, 19, -1, -1, -1, -1, -1, -1, 3, -1, -1, 16, -1, -1, -1, -1, -1, -1, -1, -1]
 *
 *
 *
 * Sample Output-1:
 *
 *
 *
 * 2
 *
 *
 *
 * Explanation-1:
 *
 *
 *
 * You start at cell 1. You roll 1 to go to cell 2 to take the stairs to cell 19. You roll 1 again to reach the last cell, 20.
 *
 *
 *
 * 1 --> (2~19) --> 20
 */

/**
 *Solution by IK
 *
 *
 * Optimal solution
 *
 *
 * Consider the entire board as a graph. All cells are nodes and there is an edge of length 1 from where you stand to next 6 cells on board, as there are 6 numbers on a dice. Whenever there is a snake or a ladder, then we go to their respective ends with no cost. For instance, when we are 24 and we roll 3 to reach 27, we would check if there is a ladder or a snake at 27. If there is, we go to the end of that snake or ladder. Otherwise, we stay at 27.
 *
 *
 * Hence, the entire problem is now reduced to graphs with given nodes and edges. We need to find the minimum distance to the the end node from the start node. We can run simple breadth first search(BFS) as the edges are of same weights.
 *
 *
 * Space Complexity: O(n)
 *
 * Time Complexity: O(n)
 */

import java.util.*;

public class SnakeLadder {

  static class QueueNode {


    int index;
    int dist;

    public QueueNode(){}

    public QueueNode(int index, int dist) {
      this.index = index;
      this.dist = dist;
    }

    public int getIndex() {
      return index;
    }

    public void setIndex(int index) {
      this.index = index;
    }

    public int getDist() {
      return dist;
    }

    public void setDist(int dist) {
      this.dist = dist;
    }
  }

  static int minNumberOfRolls(int n, List<Integer> moves) {
    int[] move = new int[n];
    for(int i=0; i< n; i++){
      //Why is this not move[i] = moves.get(i+1); since moves is 1 based indexing?
      move[i] = moves.get(i);

      //This step is very important, as making the array 0 based index,
      // all the ladder and snake pointers will be one index behind.
      if(move[i] != -1)
        move[i]--;
    }
    return minNumberOfRollsInternal(n, move);
  }

  private static int minNumberOfRollsInternal(int n, int[] moves) {
    boolean[] visited = new boolean[n+1];

    QueueNode startNode = new QueueNode(0,0);
    Queue<QueueNode> queue = new LinkedList<>();
    queue.add(startNode);

    while (!queue.isEmpty()) {
      QueueNode poppedNode = queue.poll();

      int index = poppedNode.getIndex();
      int dist = poppedNode.getDist();

      if (!visited[index]) {
        visited[index] = true;

        if (index == n-1)
          return dist;

        //For the neighbors if the rollCount
        for (int i = 1; i <= 6; i++) {
          if (index + i < n) {
            QueueNode neighborNode = new QueueNode();
            int nextIndex = index + i;
            if (moves[nextIndex] == -1)
              neighborNode.setIndex(nextIndex);
            else
              neighborNode.setIndex(moves[nextIndex]);
            neighborNode.setDist(dist+1);
            queue.add(neighborNode);
          }
        }
      }
    }
    return -1;
  }

  public static void main(String[] args){
    int n = 20;
    List<Integer> moves = Arrays.asList(1, 19, -1, -1, -1, -1, -1, -1, 3, -1, -1, 16, -1, -1, -1, -1, -1, -1, -1, -1);
    int minRolls =  minNumberOfRolls(n, moves);
    System.out.println(minRolls);
  }
}

