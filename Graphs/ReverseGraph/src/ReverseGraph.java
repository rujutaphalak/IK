/**
 * Given A Graph, Build A New One With Reversed Edges
 *
 *
 *
 * Problem Statement:
 *
 *
 *
 * Given a strongly connected directed graph containing n nodes, you have to build a new graph containing n nodes where edges are reversed than the original graph.
 *
 *
 *
 * This is also called Transposing the graph.
 *
 *
 *
 * Input Format:
 *
 *
 *
 * There is only one argument pointing to a random node of the graph.
 *
 *
 *
 * Output Format:
 *
 *
 *
 * Return any node in the new graph.
 *
 *
 *
 * As input is a strongly connected graph, you will be able to visit all the nodes, given any random node.
 *
 *
 *
 * Also when we reverse all the edges of strongly connected graph it will remain strongly connected graph, hence returning any one node is sufficient.
 *
 *
 *
 * Constraints:
 *
 *
 *
 * 1 <= n <= 315
 * Given graph is strongly connected.
 * Given graph does not contain multi edges (there will not be more than one edge connecting same pair of vertices in the same direction) and self loops.
 * Each node contains distinct values.
 * 1 <= value stored in node <= n
 * You are not allowed to modify the given graph. Return completely new graph.
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
 * Any node of the graph where:
 *
 * For n = 3
 *
 * nodes = [1 2 3]
 *
 * edges = [(1 -> 2), (2 -> 3), (3 -> 1)]
 *
 *
 *
 * you could be given any node (1, 2 or 3) as input.
 *
 *
 *
 * Sample Output:
 *
 *
 *
 * Any node of the new graph where:
 *
 * For n = 3
 *
 * nodes = [1 2 3]
 *
 * edges = [(2 -> 1), (3 -> 2), (1 -> 3)]
 *
 *
 *
 * you could return any node as output.
 */

/**
 * Solution Explanation by IK
 * To solve this problem simple DFS will work!
 *
 *
 *
 * Code provided by will be enough to understand the idea.
 *
 *
 *
 * Time Complexity:
 *
 *
 *
 * As we are doing normal DFS time complexity of our solution will be O(V + E). We are given n nodes and also given that it does not contain multiple edges and self loops hence maximum number of edges possible is n * (n - 1). So time complexity will be O(n + n^2) that is O(n^2).
 *
 *
 *
 * Space complexity:
 *
 *
 *
 * Given input contains O(n^2) edges and we are also creating new graph with O(n^2) edges hence space complexity will be O(n^2).
 */

import java.util.*;

public class ReverseGraph {

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

  /**
   * Working solution
   * @param node
   * @return
   */
  static Node buildOtherGraph(Node node)
  {
    Map<Integer, Node> cloneMap = new HashMap<>();
    return reverseGraph(node, cloneMap);
  }

  private static Node reverseGraph(Node node, Map<Integer, Node> cloneMap){

    //since this check is not done anywhere else, it needs to be done here
    if(cloneMap.containsKey(node.val)) {
      return cloneMap.get(node.val);
    }

    //Visit the node
    Node cNode = new Node(node.val);
    cloneMap.put(cNode.val,cNode);

    //Loop through neighbors to create new nodes in the map
    for (Node neighbor : node.neighbours) {
      //with the below containsKeyCheck, the reverse edge mapping is skipped, hence it does not work
      //if(!cloneMap.containsKey(neighbor.val)) {
      Node neighborNode = reverseGraph(neighbor,cloneMap);

      //Reverse the edges by using the returned neighbor node instead of this function returning void and then doing the below statement.
      // Node neighborNode = cloneMap.get(neighbor.val);
      neighborNode.neighbours.add(cNode);
      //}//end if
    }

    return cNode;
  }

  /**
   * Other way of doing it with void as return instead of node
   * @param args
   */
  // 	static Node build_other_graph(Node node) {

// 	    Map<Integer, Node> cloneMap = new HashMap<>();
// 	    buildGraph(node, nodeMap);
// 	    Map.Entry<Integer, Node> entry = cloneMap.entrySet().iterator().next();
// 	    return entry.getValue();
// 	}

// 	static void buildGraph(Node node, Map<Integer, Node> cloneMap) {

// 	    if(cloneMap.containsKey(node.val)) {
// 	        return;
// 	    }

// 	    Node newNode = new Node(node.val);
// 	    cloneMap.put(newNode.val, newNode);
// 	    for(Node neighbor: node.neighbours) {
// 	        buildGraph(neighbor, nodeMap);

// 	        Node neighborNode = cloneMap.get(neighbor.val);
// 	        neighborNode.neighbours.add(newNode);
// 	    }
// 	}

  public static void main(String[] args){
    Node node1 = new Node(1);
    Node node2 = new Node(2);
    Node node3 = new Node(3);

    node1.neighbours.add(node2);
    node2.neighbours.add(node3);
    node3.neighbours.add(node1);


    Node node = buildOtherGraph(node1);
    System.out.println("One node in the new reversed graph is " + node.val);
  }
}
