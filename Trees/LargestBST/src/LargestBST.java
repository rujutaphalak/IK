/**
 * Largest BST
 *
 *
 *
 * Problem Statement:
 *
 *
 *
 * Given a binary tree, find the largest Binary Search Tree (BST), where largest means BST with largest number of nodes in it. The largest BST must include all of its descendants.
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
 * Return an integer denoting the size of the largest BST
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
 * ../../../../../Desktop/Screen%20Shot%202019-02-17%20at%2011.3
 *
 *
 *
 * Sample Output:
 *
 *
 *
 * 3
 *
 *
 *
 * Explanation:
 *
 *
 *
 * In the input tree, left subtree of node 1 is a BST. It has 3 nodes and this is the largest BST. So, result is 3.
 */

/**
 * We have provided two solution for this problem. other_solution.cpp is the brute force solution and optimal_solution.cpp is the optimal solution.
 *
 *
 *
 * 1.other_solution.cpp:
 *
 *
 *
 * The problem asked to find out the largest BST from the given tree. As we know, in a tree having N nodes there are N subtrees, so there can be N BST. We have to find out the size of the largest one. In this solution we check if a subtree is a BST or not. If it is a BST, counted the number of nodes in the subtree. Let’s say there are K subtree which are BST also. We know size of the K BST. Maximum of those size is our desired result.
 *
 *
 *
 * Time complexity:
 *
 * O(N^2)
 *
 *
 *
 * Auxiliary space:
 *
 * O(N^2) because of using two recursion.
 *
 *
 *
 * Space complexity:
 *
 * Including input, O(N^2)
 *
 *
 *
 *
 *
 * 2.optimal_solution.cpp:
 *
 *
 *
 * In this solution we first checked if the left subtree and right subtrees are BST or not. There are few cases. Cases are described below:
 *
 * Leaf node: Leaf node is a valid BST
 * Both subtrees are valid BST:
 * If root’s value is between left child value and right child value, then subtree rooted at current tree is a valid, otherwise not.
 *
 *
 *
 * One of the subtree is not a valid BST:
 * Subtree rooted at current tree is not a valid BST.
 *
 *
 *
 * In each case, we few parameters of current subtree. To make this process easier, we used a class which held 5 values. These are:
 *
 * mn: Minimum node value of current subtree
 * mx: Maximum node value of current subtree
 * isBST: true or false to denote whether current subtree is a valid BST or not
 * size: Number of nodes in current subtree
 * mxSize: Size of the largest BST in current subtree
 * Please note that, when isBST is false, variables mn, mx and size are insignificant. The mxSize variables stores the result we are expecting.
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
 * O(N) because of using two recursion.
 *
 *
 *
 * Space complexity:
 *
 * Including input, O(N)
 */
public class LargestBST {

  //This is logically wrong.
//     static int nodeCount = 0;
//     static int findLargestBST(TreeNode root){
//         return findLargestBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
//     }

//     static int findLargestBST(TreeNode root, int min, int max){
//         if(root==null)
//             return 0;

//         int nodeCount = 0;
//         if(isBST(root, min, max, nodeCount)){
//             return nodeCount;
//         }

//         int leftNodeCount = findLargestBST(root.left_ptr, min, root.val);
//         int rightNodeCount = findLargestBST(root.right_ptr, root.val, max);

//         return Math.max(leftNodeCount,rightNodeCount);
// }

// private static boolean isBST(TreeNode root, int min, int max, int nodeCount){
//     if(root==null)
//         return true;
//     if(root.val < min || root.val > max)
//         return false;
//     nodeCount++;

//     boolean isLeftBST = isBST(root.left_ptr, min, root.val, nodeCount);
//     boolean isRightBST = isBST(root.right_ptr, root.val, max, nodeCount);

//     return (isLeftBST && isRightBST);

// }


//This logic is okay, one test case fails, 2 time out, the rest pass. This is not the optimum solution
//     static int nodeCount =0;
//     static int findLargestBST(TreeNode root){
//     	return helper(root,Integer.MIN_VALUE, Integer.MAX_VALUE);
//     }

//     static int helper(TreeNode root, int min , int max){

//     	if(isBST(root, min, max))
//     		return nodeCount;

//         nodeCount=0;
//     	int leftCount = helper(root.left_ptr, min, max);
//     	int rightCount = helper(root.right_ptr, min, max);

//     	return Math.max(leftCount, rightCount);

//     }

// 	static boolean isBST(TreeNode root, int min, int max){
// 		if (root==null)
// 			return true;

// 		if(root.val < min || root.val > max)
// 		    return false;

// 		nodeCount++;
// 		boolean leftFlag = isBST(root.left_ptr, min, root.val);
// 		boolean rightFlag = isBST(root.right_ptr, root.val, max);
// 		return (leftFlag && rightFlag);
// }


  static class BstInfo{
    int min;
    int max;
    int nodeCount;
    boolean isBst;

    public BstInfo(){
      this.min = Integer.MAX_VALUE;
      this.max = Integer.MIN_VALUE;
      nodeCount=0;
      isBst = false;
    }
  }

  static int findLargestBST(TreeNode root){

    return helper(root).nodeCount;
  }

  static BstInfo helper(TreeNode root){
    BstInfo currentInfo = new BstInfo();

    if(root==null){
      currentInfo.isBst = true;
      return currentInfo;
    }

    BstInfo leftInfo = helper(root.left_ptr);
    BstInfo rightInfo = helper(root.right_ptr);

    currentInfo.min = Math.min(leftInfo.min, root.val);
    currentInfo.max = Math.max(rightInfo.max, root.val);

    if(leftInfo.isBst && rightInfo.isBst && leftInfo.max<=root.val && rightInfo.min>=root.val){
      currentInfo.isBst = true;
      currentInfo.nodeCount = leftInfo.nodeCount + rightInfo.nodeCount + 1;
    }
    else{
      currentInfo.isBst = false;
      currentInfo.nodeCount = Math.max(leftInfo.nodeCount, rightInfo.nodeCount);
    }

    return currentInfo;

  }

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


}
