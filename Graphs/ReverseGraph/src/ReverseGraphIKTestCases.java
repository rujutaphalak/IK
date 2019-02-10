
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class ReverseGraphIKTestCases {

  static Node build_other_graph(Node node) {
    Map<Integer, Node> cloneMap = new HashMap<>();
    return reverseGraph(node, cloneMap);
  }

  private static Node reverseGraph(Node node, Map<Integer, Node> cloneMap) {

    //since this check is not done anywhere else, it needs to be done here
    if (cloneMap.containsKey(node.val)) {
      return cloneMap.get(node.val);
    }

    //Visit the node
    Node cNode = new Node(node.val);
    cloneMap.put(cNode.val, cNode);

    //Loop through neighbors to create new nodes in the map
    for (Node neighbor : node.neighbours) {
      //with the below containsKeyCheck, the reverse edge mapping is skipped, hence it does not work
      //if(!cloneMap.containsKey(neighbor.val)) {
      Node neighborNode = reverseGraph(neighbor, cloneMap);

      //Reverse the edges by using the returned neighbor node instead of this function returning void and then doing the below statement.
      // Node neighborNode = cloneMap.get(neighbor.val);
      neighborNode.neighbours.add(cNode);
      //}//end if
    }

    return cNode;
  }

  //------------------------------IK code-------------------------------//

  static class Node
  {
    Integer val;
    Vector<Node> neighbours = new Vector<Node>(0);
    Node(Integer _val)
    {
      val = _val;
      neighbours.clear();
    }
  }

  static HashMap<Integer, Node> reversed = new HashMap<Integer, Node>();

  static void helper_dfs(Node reversed_node)
  {
    reversed.put(reversed_node.val, reversed_node);
    int n = reversed_node.neighbours.size();
    for (int i = 0; i < n; i++)
    {
      if (reversed.containsKey(reversed_node.neighbours.get(i).val) == false)
      {
        helper_dfs(reversed_node.neighbours.get(i));
      }
    }
  }

  static HashMap<Integer, Node> helper_get_all_addresses_in_reversed_graph(Node reversed_node)
  {
    helper_dfs(reversed_node);
    return reversed;
  }

  static String helper(int graph_nodes, int[] graph_from, int[] graph_to) {

    int MAX_NODES = 315;

    HashMap<Integer, Node> original = new HashMap<Integer, Node>();
    for (int i = 1; i <= graph_nodes; i++)
    {
      original.put(i, new Node(i));
    }
    HashMap<Integer, Boolean> edges = new HashMap<Integer, Boolean>();
    int graph_edges = graph_from.length;
    for (int i = 0; i < graph_edges; i++)
    {
      original.get(graph_from[i]).neighbours.add(original.get(graph_to[i]));

      edges.put(MAX_NODES * (graph_from[i] - 1) + graph_to[i] - 1, true);
    }

    HashMap<Integer, Node> reversed = helper_get_all_addresses_in_reversed_graph(build_other_graph(original.get(1)));

    System.err.print("In returned graph: \n");
    for (Integer val : reversed.keySet())
    {
      System.err.print("Neighbours of node " + String.valueOf(val) + " = [");
      Node node = reversed.get(val);
      int n = node.neighbours.size();
      for (int i = 0; i < n; i++)
      {
        int _val = node.neighbours.get(i).val;
        System.err.print(String.valueOf(_val));
        if (i != n - 1){
          System.err.print(", ");
        }
      }
      System.err.print("]\n");
    }

    if (reversed.size() != graph_nodes)
    {
      System.err.print("Wrong answer because no of nodes in returned graph != no of nodes in original graph.\n");
      return "Wrong Answer!";
    }

    for (Integer val : reversed.keySet())
    {
      Node node = reversed.get(val);
      if (1 > val || val > graph_nodes)
      {
        System.err.print("Wrong answer because value of node is out of range.\n");
        return "Wrong Answer!";
      }
      if (original.get(val) == reversed.get(val))
      {
        System.err.print("Wrong answer because instead of creating new node, you have used node from original graph.\n");
        return "Wrong Answer!";
      }
      int n = node.neighbours.size();
      for (int i = 0; i < n; i++)
      {
        int _val = node.neighbours.get(i).val;
        int temp = MAX_NODES * (_val - 1) + val - 1;
        if (edges.containsKey(temp) == false)
        {
          System.err.print("Wrong answer because returned graph contains edge that is not present in original graph.\n");
          return "Wrong Answer!";
        }
        edges.remove(temp);
      }
    }
    if (edges.size() > 0)
    {
      System.err.print("Wrong answer because returned graph contains extra edge that is not present in original graph\n");
      return "Wrong Answer!";
    }
    return "Correct Answer!";
  }

  public static void main(String[] args) throws IOException {
    Scanner in = new Scanner(System.in);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String res;
    String[] graph_nodesm = in.nextLine().split(" ");
    int graph_nodes = Integer.parseInt(graph_nodesm[0]);
    int graph_edges = Integer.parseInt(graph_nodesm[1]);

    int[] graph_from = new int[graph_edges];
    int[] graph_to = new int[graph_edges];

    for (int graph_i = 0; graph_i < graph_edges; graph_i++) {
      String[] graph_fromv = in.nextLine().split(" ");
      graph_from[graph_i] = Integer.parseInt(graph_fromv[0]);
      graph_to[graph_i] = Integer.parseInt(graph_fromv[1]);
    }

    res = helper(graph_nodes, graph_from, graph_to);
    bw.write(res);
    bw.newLine();

    bw.close();
  }
}