/**
 * Calculate the diameter of a tree (not necessarily a binary tree). Diameter is the longest path between two leaves of a tree. A path is the sum total of all distances (weights) attached to all edges between two nodes.
 *
 *
 *
 * In the examples below, a tree is represented in a specific notation.
 *
 *
 *
 * e.g. "{0,1,{5,0}}" means:
 *
 * * it starts with root (0), which has one (1) child, which will follow in braces.
 *
 * * Inside the braces, it says that the distance (weight) of reaching that first child is 5 and
 *
 * * that there are no more children after that (0)
 *
 *
 *
 * You can represent the tree however you like. This is just one convenient way. Other example test-cases:
 *
 *
 *
 *
 *
 * // One node - no diameter
 *
 * new TestCase("{0,0}", 0),
 *
 * // One leaf
 *
 * new TestCase("{0,1,{5,0}}", 5),
 *
 * // Still one leaf
 *
 * new TestCase("{0,1,{5,1,{4,1,{7,0}}}}", 16),
 *
 * // The diameter of the first son is the diameter of the tree
 *
 * new TestCase("{0,1,{5,2,{8,0},{7,0}}}", 15),
 *
 * // The diameter of the last son is the diameter of the tree
 *
 * new TestCase("{0,3,{1,2,{5,0},{7,0}},{1,2,{6,0},{5,0}},{1,2,{10,0},{9,0}}}", 19),
 *
 * // Now the diameter is between a leaf in the first son and a leaf in the third son
 *
 * new TestCase("{0,3,{5,2,{8,0},{7,0}},{5,2,{9,0},{8,0}},{5,2,{10,0},{9,0}}}", 29)
 *
 *
 *
 * In custom input, for test case ("{0,0}", 0), you need to provide them on separate lines like:
 *
 *
 *
 * {0,0}
 *
 * 0
 *
 *
 *
 * And in the diameter_of_a_tree function, you will receive string named tree = "{0,0}" and integer named ans = 0. Then, you will need to write some code to build the tree from the input string named tree.
 *
 *
 *
 * Note:
 *
 *
 *
 * This problem is under development according to IK standards. If you'd like to contribute, then please feel free to email soham@interviewkickstart.com
 *
 *
 *
 * Till we finish developing this problem, you can look at:
 *
 * https://leetcode.com/problems/diameter-of-binary-tree/description/
 *
 * http://techieme.in/tree-diameter/
 *
 * http://www.geeksforgeeks.org/diameter-of-a-binary-tree/
 */

//Not working , also this written code is for Binary Tree not a Tree as per the IK question.
public class DiameterOfTree {

  public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

  public int diameterOfBinaryTree(TreeNode root) {
    return diameterOfBinaryTreeRecursion(root);
  }

  public int diameterOfBinaryTreeRecursion(TreeNode root) {
    if(root == null){
      return 0;
    }

    int heightLeft = height(root.left);
    int heightRight = height(root.right);

    return Math.max(Math.max(heightLeft, heightRight), heightLeft + heightRight);
  }

  private int height(TreeNode node){
    if(node == null)
      return 0;
    return 1 + Math.max(height(node.left), height(node.right));
  }
}
