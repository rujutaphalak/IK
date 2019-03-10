/**
 * Height Of K-Ary Tree
 *
 *
 *
 * Problem Statement:
 *
 *
 *
 * Given a k-ary tree T, containing N nodes. You have to find height of the tree. (Length of the longest path from root to any node.)
 *
 *
 *
 * (We are looking for number of edges on longest path from root to any node, not number of nodes on longest path from root to any node.)
 *
 *
 *
 * Definition from Wikipedia: A k-ary tree is a rooted tree in which each node has no more than k children. A binary tree is the special case where k=2.
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
 * There is only one argument denoting the root of the k-ary tree.
 *
 *
 *
 * From any node, you can access all its children using node's property named children, which is an array of nodes.
 *
 *
 *
 * For 3-ary tree:
 *
 * 1 is the root of the tree.
 *
 * 2's parent is 1.
 *
 * 3's parent is 1.
 *
 * 5's parent is 1.
 *
 * 4's parent is 5.
 *
 *
 *
 * children of node 1 = [node 2, node 3, node 5].
 *
 * children of node 2 = [].
 *
 * children of node 3 = [].
 *
 * children of node 4 = [].
 *
 * children of node 5 = [node 4].
 *
 *
 *
 * Look at the comment in the code editor, to know implementation details of the node, in your preferred language.
 *
 *
 *
 * Output Format:
 *
 *
 *
 * Return an integer hmax, denoting height of the k-ary tree.
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
 * The first line of input should contain an integer k, denoting that input tree is an k-ary tree T.
 *
 * In next line, there should be an integer (N-1), denoting no of edges in T. In next (N-1) lines, ith line should contain an integer from[i], denoting value at one endpoint of an edge.
 *
 * In next line, there should be an integer (N-1), denoting no of edges in T. In next (N-1) lines, ith line should contain an integer to[i], denoting value at other endpoint of an edge.
 *
 *
 *
 * If k = 3, N = 5, from = [1, 1, 1, 5] and to = [3, 2, 5, 4], then input should be:
 *
 *
 *
 * 3
 *
 * 4
 *
 * 1
 *
 * 1
 *
 * 1
 *
 * 5
 *
 * 4
 *
 * 3
 *
 * 2
 *
 * 5
 *
 * 4
 *
 *
 *
 * Output Format:
 *
 *
 *
 * There will be one line of output, containing an integer hmax, denoting the result returned by solution function.
 *
 *
 *
 * For input k = 3, N = 5, from = [1, 1, 1, 5] and to = [3, 2, 5, 4], output will be:
 *
 *
 *
 * 2
 *
 *
 *
 * Constraints:
 *
 * 1 <= N <= 10^5
 * 0 <= k <= N - 1
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
 * 3-ary tree:
 *
 * 1 is the root of the tree.
 *
 * 2's parent is 1.
 *
 * 3's parent is 1.
 *
 * 5's parent is 1.
 *
 * 4's parent is 5.
 *
 *
 *
 * Sample Output:
 *
 *
 *
 * 2
 *
 *
 *
 * Explanation:
 *
 *
 *
 * Given a 3-ary tree with 5 nodes. Node 1 has 3 children 2, 3 and 5, and node 5 has one child 4.
 *
 * Longest path from root is 1 -> 5 -> 4 and it's length is 2.
 */

/**
 * Editorial by IK
 *
 * When we are dealing with binary tree, our node structure looks like:
 *
 *
 *
 * struct node
 *
 * {
 *
 * int val;
 *
 * node *left_child;
 *
 * node *right_child;
 *
 * };
 *
 *
 *
 * But when we are given k-ary tree then it is not a good idea to manage each pointer separately. (when k = 500 should we define 500 pointers?)
 *
 *
 *
 * When we are dealing with k-ary tree, our node structure should look like:
 *
 * struct node
 *
 * {
 *
 * int val;
 *
 * vector<node*> children;
 *
 * };
 *
 *
 *
 * Here we only need to find the height hence what value each node is storing does not matter, only thing that matters is how nodes are connected to each other. So in input also we are just given how nodes are connected to each other.
 *
 *
 *
 * Height of the tree = Number of edges in longest path from root to any node = Number of nodes in longest path from root to any node - 1.
 *
 *
 *
 * We can find height of tree using height of its subtrees.
 *
 *
 *
 * More specifically,
 *
 *
 *
 * height(parent) = max(height(children)) + 1 : when parent is not a leaf node.
 *
 * 0 : when parent is a leaf node.
 *
 *
 *
 * We can use algorithm similar to dfs to do all these calculations.
 *
 *
 *
 * Now have a look at the code provided by us.
 *
 *
 *
 * Time complexity of the solution is O(N) because our solution is similar to dfs. (Here we have assumed that addition and lookup on random data in unordered_map is O(1))
 *
 *
 *
 * Auxiliary space used and space complexity of our programme is O(N) because we have used unordered_map to store N addresses and created the k-ary tree of size N.
 *
 *
 *
 * As mentioned in the problem statement, some languages like javascript and python might not pass one testcase. The reason is given tree in that testcase is degenerate tree and we are using algorithm similar to dfs. Hence there will be ~10^5 recursive calls to reach the base case and some languages don't allow that many recursive calls.
 */


import java.io.*;
import java.util.*;
public class HeightOfKAryTree {

  static int find_height(TreeNode root)
  {
    return helper(root,0);

  }
  static int helper(TreeNode root,int height){
    if(root==null)
      return 0;
    int result=height;
    for(TreeNode child:root.children)
      result = Math.max(helper(child,height+1),result);
    return result;

  }

  static class TreeNode
  {
    //int val;														// To find height of tree, value stored in nodes does not matter. So in input also we are not given this field.
    Vector<TreeNode> children = new Vector<TreeNode>(0);
    TreeNode()
    {
      children.clear();
    }
  }
//
//  static HashMap <Integer, TreeNode> address = new HashMap<Integer, TreeNode>();
//
//  static TreeNode build_tree(int[] from, int[] to) {
//    int N = from.length + 1;
//    address.clear();												// Clear the variable.
//    for (int i = 1; i <= N; i++)
//    {
//      address.put(i, new TreeNode());								// Create N nodes.
//    }
//    for (int i = 0; i < N - 1; i++)
//    {
//      address.get(from[i]).children.add(address.get(to[i]));		// Link the nodes. (Build the k-ary tree.)
//    }
//    return address.get(1);
//  }
//
//  Solution() throws IOException {
//    Scanner in = new Scanner(System.in);
//    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//
//    int res;
//    int k;
//    k = Integer.parseInt(in.nextLine().trim());
//
//    int from_size = 0;
//    from_size = Integer.parseInt(in.nextLine().trim());
//
//    int[] from = new int[from_size];
//    for(int i = 0; i < from_size; i++) {
//      int from_item;
//      from_item = Integer.parseInt(in.nextLine().trim());
//      from[i] = from_item;
//    }
//
//    int to_size = 0;
//    to_size = Integer.parseInt(in.nextLine().trim());
//
//    int[] to = new int[to_size];
//    for(int i = 0; i < to_size; i++) {
//      int to_item;
//      to_item = Integer.parseInt(in.nextLine().trim());
//      to[i] = to_item;
//    }
//
//    TreeNode root = build_tree(from, to);
//
//    res = find_height(root);
//    bw.write(String.valueOf(res));
//    bw.newLine();
//
//    bw.close();
//  }
//
//  public static void main(String[] args) throws IOException {
//
//    new Thread(null, new Runnable() {
//      public void run() {
//        try {
//          new Solution();
//        } catch (Exception e) {
//          e.printStackTrace();
//        }
//      }
//    }, "1", 1 << 26).start();
//  }
}
