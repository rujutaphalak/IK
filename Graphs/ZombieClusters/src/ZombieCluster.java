/**
 * There are zombies in Seattle. Liv and Ravi are trying to track them down to find out who is creating new zombies in an effort to prevent an apocalypse. Other than the patient-zero zombies (who became so by mixing MaxRager and tainted Utopium), new people only become zombies after being scratched by an existing zombie. Zombiism is transitive. This means that if zombie 0 knows zombie 1 and zombie 1 knows zombie 2, then zombie 0 is connected to zombie 2 by way of knowing zombie 1. A zombie cluster is a group of zombies who are directly or indirectly linked through the other zombies they know, such as the one who scratched them or supplies who them with brains.
 *
 *
 *
 * The diagram showing connectedness will be made up of a number of binary strings, characters 0 or 1. Each of the characters in the string represents whether the zombie associated with a row element is connected to the zombie at that character's index. For instance, a zombie 0 with a connectedness string '110' is connected to zombies 0 (itself) and zombie 1, but not to zombie 2. The complete matrix of zombie connectedness is:
 *
 *
 *
 * 	110
 * 	110
 * 	001
 *
 *
 * Zombies 0 and 1 are connected. Zombie 2 is not.
 *
 *
 *
 * Your task is to determine the number of connected groups of zombies, or clusters, in a given matrix.
 *
 *
 *
 * Note: Method signatures may vary depending on the requirements of your chosen language.
 *
 *
 *
 * Function Description
 *
 * Complete the function zombieCluster in the editor below. The function must return an integer representing the number of zombie clusters counted.
 *
 *
 *
 * zombieCluster has the following parameter(s):
 *
 *     zombies[z0,...zn-1]:  an array of strings of binary digits zi representing connectedness of zombies
 *
 *
 *
 * Constraints
 *
 * 1 ≤ n ≤ 300
 * 0 ≤ i < n
 * |zombies| = n
 * Each zi contains a binary string of n zeroes and ones. It is a square matrix.
 *
 *
 *
 *
 * Input Format for Custom Testing
 *
 *
 *
 * Input from stdin will be processed as follows and passed to the function.
 *
 *
 *
 * The first line contains an integer n, the size of the square zombie association matrix, zombies.
 *
 * The next n lines each contain a binary string of length n describing a row in the matrix, zi where 0 ≤ i < n.
 *
 *
 *
 *
 *
 * Sample Case 0
 *
 *
 *
 * Sample Input 0
 *
 * 4
 * 1100
 * 1110
 * 0110
 * 0001
 *
 *
 * Sample Output 0
 *
 * 2
 * In the diagram below, the squares highlighting a known connection between two different zombies are highlighted in green. Because each zombie is already aware that they are personally a zombie, those are highlighted in grey.
 *
 *
 *
 * Explanation 0
 *
 *
 *
 * zombie-sample-0
 *
 *
 *
 * We have n = 4 zombies numbered z0 through z3. There are 2 pairs of zombies who directly know each another: (z0, z1) and (z1, z2). Because of zombiism's transitive property, the set of zombies {z0, z1, z2} is considered to be a single zombie cluster. The remaining zombie, z3, doesn't know any other zombies and is considered to be his own, separate zombie cluster ({z3}). This gives us a total of 2 zombie clusters.
 *
 *
 *
 * Sample Case 1
 *
 *
 *
 * Sample Input 1
 *
 * 5
 * 10000
 * 01000
 * 00100
 * 00010
 * 00001
 *
 *
 * Sample Output 1
 *
 * 5
 *
 *
 * Explanation
 *
 *
 *
 * In the diagram below, the squares highlighting a known connection between two different zombies are highlighted in green. Because each zombie is already aware that they are personally a zombie, those are highlighted in grey.
 *
 *
 *
 * Explanation 1:
 *
 * zombie-sample-1
 *
 * No zombie knows who any other zombie is, so they each form their own zombie cluster: {z0}, {z1}, {z2}, {z3}, and {z4}. This means we have 5 zombie clusters, so we print 5 on a new line.
 *
 *
 */


/**
 * solution not yet provided by IK. Working on IDE for two cases for which it is failing on IK platform.
 */

public class ZombieCluster {

  public static void main(String[] args) {
      String[] str = {"1100","1110","0110","0001"};
//    String[] str = {"10000","01000","00100","00010","00001"};
      int clusterCount = zombieCluster(str);
      System.out.println(clusterCount);
  }

  //------------------Second way of doing it----------------------//
  public static int zombieCluster(String[] zombies) {

    //Simple DFS. Great solution over second one.
    int rows = zombies.length;
    int count =0;
    int[] visited = new int[zombies.length];
    for(int zombie=0;zombie<rows;zombie++){
      if(visited[zombie] != 1) {
        explore(zombies, zombie, visited);
        count += 1;
      }
      }
    return count;
  }

  //Go through neighbors and recursively call it
  private static void explore(String[] zombies, int index, int[] visited) {
    visited[index] = 1;
    for(int neighbor=0;neighbor<zombies.length;neighbor++){
      if(index != neighbor && zombies[index].charAt(neighbor) == '1' && visited[neighbor] != 1){
        explore(zombies,neighbor,visited);
      }
    }
  }

  //-------------------------One way of doing it--------------//
//  public static int zombieCluster(String[] zombies) {
//    //Build a 2D grid for easier looping
//    int[][] zombieGrid = buildGrid(zombies);
//
//    //Go through each zombie using DFS, not explore yet.
//    int rows = zombieGrid.length;
//    int count =0;
//    for(int i=0;i<rows;i++){
//      if(zombieGrid[i][i] == 0) continue;
//      else{
//        explore(zombieGrid, i);
//        count+=1;
//      }
//    }
//    return count;
//  }
//
//  private static int[][] buildGrid(String[] zombies){
//    int rows = zombies.length;
//    int cols = zombies[0].length();
//    int[][] zombieGrid = new int[rows][cols];
//    for(int i =0;i<rows;i++) {
//      for(int j=0;j<cols;j++){
//        zombieGrid[i][j] = zombies[i].charAt(j)-'0';
//      }
//    }
//    return zombieGrid;
//  }
//
//  private static void explore(int[][] zombieGrid, int zombie){
//    zombieGrid[zombie][zombie]=0;
//    for(int neighbor=0;neighbor<zombieGrid.length;neighbor++){
//      if(zombieGrid[neighbor][neighbor] == 0)
//        zombieGrid[zombie][neighbor] = 0;
//      else if(zombieGrid[zombie][neighbor] == 1){
//        explore(zombieGrid, neighbor);
//      }
//    }
//  }
  //-------------------------One way of doing it--------------//
}
