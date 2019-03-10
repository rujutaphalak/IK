/**
 * Clone a Binary Tree
 *
 *
 *
 * Problem Statement:
 *
 *
 *
 * Given a binary tree (represented by its root node, like usual), clone it. Return the root node of the cloned tree.
 *
 *
 *
 * Remember: Cloning or copying a tree is best done recursively. Notice how clean and succinct the code is. Some of you may be tempted to do it breadth-first. But that's more complicated to handle in implementation.
 *
 *
 *
 * Input format:
 *
 *
 *
 * There is only one argument named root denoting the root of the input tree.
 *
 *
 *
 * Output format:
 *
 *
 *
 * Return the root of cloned tree
 *
 *
 *
 * Constraints:
 *
 *
 *
 * 0 <= number of nodes <= 100000
 * 1 <= values stored in the nodes <= 10^9
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
 * ../../../../../Desktop/Screen%20Shot%202019-02-11%20at%2010.4
 *
 *
 *
 * Sample Output:
 *
 *
 *
 * ../../../../../Desktop/Screen%20Shot%202019-02-11%20at%2010.4
 */

/**
 * Editorial by IK
 *
 * We have provided one solution for this problem. This is the optimal solution.
 *
 *
 *
 * The problem asks to clone a binary tree. We do it recursively. First we create a new node using the current root node value. We clone the current node’s left child and assign as left child of new node. We do the same for right child.
 *
 *
 *
 * Time complexity:
 *
 * O(N)
 *
 *
 *
 * Auxiliary space:
 *
 * O(N) because of using stack
 *
 *
 *
 * Space complexity:
 *
 * Including input, O(N)
 */
public class CloneBinaryTree {

  private static class TreeNode{
    public int val;
    public TreeNode left_ptr;
    public TreeNode right_ptr;

    public TreeNode(){
      this.left_ptr = null;
      this.right_ptr = null;
    }

    public TreeNode(int val){
      this.val = val;
      this.left_ptr = null;
      this.right_ptr = null;
    }
  }

  static TreeNode cloneTree(TreeNode root){

    if(root == null)
      return root;

    TreeNode cRoot = new TreeNode(root.val);

    TreeNode lRoot = cloneTree(root.left_ptr);
    cRoot.left_ptr = lRoot;

    TreeNode rRoot = cloneTree(root.right_ptr);
    cRoot.right_ptr = rRoot;

    return cRoot;
  }


  //try doing the same with extra random pointers.
//  private static class TreeNode{
//    public int val;
//    public TreeNode left_ptr;
//    public TreeNode right_ptr;
//    public random_ptr;
//
//    public TreeNode(){
//      this.left_ptr = null;
//      this.right_ptr = null;
//      this.random_ptr=null;
//    }
//
//    public TreeNode(int val){
//      this.val = val;
//      this.left_ptr = null;
//      this.right_ptr = null;
//    }
//  }

}
