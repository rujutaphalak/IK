//NOT WORKING
import java.util.*;

public class DetectCycle {

  public static void main(String[] args) {
    int N = 5, M = 7;
    List<List<Integer>> edges = new ArrayList<>();

//    edges.add([0,1]);
  }

  public enum Color {
    WHITE,
    GRAY,
    BLACK
  }

  public static boolean hasCycle(int N, int M, List<List<Integer>> edges) {
    Color[] colors = new Color[N];

    for (int c = 0; c < N; c++) {
      colors[c] = Color.WHITE;
    }

    Map<Integer, List<Integer>> graph = buildGraph(edges);

    for (int v = 0; v < N; v++) {
      if (colors[v] == Color.WHITE) {
        if (hasCycleUtil(v, colors, graph))
          return true;
        return false;
      }
    }
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

  private static boolean hasCycleUtil(int v, Color[] colors, Map<Integer, List<Integer>> graph) {

    if (colors[v] == Color.GRAY)
      return true;

    if (colors[v] == Color.WHITE) {
      List<Integer> neighbors = graph.get(v);
      for (int neighbor : neighbors) {
        hasCycleUtil(neighbor, colors, graph);
      }
    }

    if (colors[v] == Color.BLACK) {
      return false;
    }
    return false;
  }
}
