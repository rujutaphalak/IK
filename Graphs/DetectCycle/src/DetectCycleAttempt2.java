import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;
import java.util.stream.*;

public class DetectCycleAttempt2 {

  public static boolean hasCycle(int N, int M, List<List<Integer>> edges) {

    Set<Integer> visited = new HashSet<>(N);
    Set<Integer> stack = new HashSet<>();
    Map<Integer, List<Integer>> graph = buildGraph(edges);

    for (int vertex : graph.keySet()) {
      if(!visited.contains(vertex))
        if (hasCycleUtil(vertex, graph, stack, visited))
          return true;
    }
    return false;
  }

  private static boolean hasCycleUtil(int vertex, Map<Integer, List<Integer>> graph,
      Set<Integer> stack, Set<Integer> visited) {

    if (stack.contains(vertex))
      return true;

    if (visited.contains(vertex))
      return false;

    /*This condition takes care of one directional edges with no neighbors. For example 1->2,2->3.
    3 is a vertex but it is not a key in the graph. It will try to look for 3 in graph ot get its neighbors.
    It shouldn't because 3 has not outgoing edges. It shold just return false */
    if(!graph.containsKey(vertex))
      return false;

    stack.add(vertex);

    for (int neighbor : graph.get(vertex)) {
      /*Including this condition as regular BFS causes the cycle to not be explored. If a node is already visited
      and is stopped from visiting if it is still in the stack, that wrongs so many test cases. For ex 1->2,2->3,3->4,4->2
      Here the 2 is visited by 1. And in th dfs of 4, 2 is the neighbor. If we add the below commented condition, it will actually
      prevent us from exploring the loop*/

      // if(!visited.contains(vertex)) {
      if (hasCycleUtil(neighbor, graph, stack, visited))
        return true;
      //}//end if
    }
    //This is to make the nodes visited after one cycle is over
    visited.add(vertex);

    /*Vertexes should be removed form the stack. If not, the next immediate vertex that is in the stack
     but does not cause a loop will fail as the first condition will pass. i.e. if (stack.contains(vertex)) return true;*/
    stack.remove(vertex);

    return false;
  }

  private static Map<Integer, List<Integer>> buildGraph(List<List<Integer>> edges) {
    Map<Integer, List<Integer>> graph = new HashMap<>();
    List<Integer> list;
    for (List<Integer> edge : edges) {
      if (!graph.containsKey(edge.get(0)))
        list = new ArrayList<>();
      else
        list = graph.get(edge.get(0));

      list.add(edge.get(1));
      graph.put(edge.get(0), list);
    }
    return graph;
  }
}

class Solution {
  public static void main(String args[]) {
        /*
        This function is used to increase the size of recurison stack. It makes the size of stack
        2^26 ~= 10^8
        */
    new Thread(null, new Runnable() {
      public void run() {
        try{
          solve();
        }
        catch(Exception e){
          e.printStackTrace();
        }
      }
    }, "1", 1 << 26).start();
  }
  public static void solve() throws IOException{
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(bufferedReader.readLine().trim());
    int M = Integer.parseInt(bufferedReader.readLine().trim());

    List<List<Integer>> edges = new ArrayList<>();

    IntStream.range(0, M).forEach(i -> {
      try {
        edges.add(
            Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList())
        );
      } catch (IOException ex) {
        throw new RuntimeException(ex);
      }
    });

    bufferedReader.close();

    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

    boolean result = DetectCycleAttempt2.hasCycle(N, M, edges);

    bufferedWriter.write(String.valueOf(result ? "1" : "0"));
    bufferedWriter.newLine();

    bufferedWriter.close();
  }
}