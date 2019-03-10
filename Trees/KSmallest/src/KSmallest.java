/**
 *
 * Kth Smallest Element Of BST
 *
 *
 *
 * Problem Statement:
 *
 *
 *
 * Given a BST (binary search tree), of size N, containing integer elements, and an integer k, you have to find kth smallest element of given BST.
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
 * There are two arguments in the input. First one is the root of the BST and second one is an integer k.
 *
 *
 *
 * Output Format:
 *
 *
 *
 * Return an integer kmin, denoting kth smallest element of BST.
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
 * The first line of input should contain an integer N, denoting size of input array arr. In next N lines, ith line should contain an integer arr[i], denoting a value at index i of arr.
 *
 * Input BST will be constructed by inserting elements of array arr to an empty BST in order arr[0], arr[1], …, arr[N-1].
 *
 *
 *
 * If n = 3, k = 3 and arr = [1, 2, 3], then input should be:
 *
 *
 *
 * 3
 *
 * 2
 *
 * 3
 *
 * 1
 *
 * 3
 *
 *
 *
 * Output Format:
 *
 *
 *
 * There will be one line of output, containing an integer kmin, denoting the result returned by solution function.
 *
 *
 *
 * For input n = 3, k = 3 and arr = [1, 2, 3], output will be:
 *
 *
 *
 * 3
 *
 *
 *
 * Constraints:
 *
 * 1 <= N <= 6000
 * 1 <= k <= N
 * -2 * 10^9 <= value stored in any node <= 2 * 10^9
 * BST need not to be balanced.
 * You are not allowed to alter the structure or data inside the given BST.
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
 * BST =
 *
 * 2 is the root node.
 *
 * 1 is 2's left child.
 *
 * 3 is 2's right child.
 *
 *
 *
 * k = 3
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
 * 3rd smallest element is 3.
 *
 *
 *
 * Notes:
 *
 * Maximum time allowed in interview: 20 Minutes.
 */

/**
 * Editorial section by IK
 * We want to find kth smallest element of given BST.
 *
 *
 *
 *
 *
 *
 *
 * If we can get all the elements of BST in sorted order then our answer will be the kth element. We know that inroder traversal visites elements in sorted order! But time complexity of the problem is O(N) and auxiliary space used is also O(N).
 *
 *
 *
 * Note that we need not to store all the elements, we can just keep the count on number of nodes visited till now and when counter becomes k it is the node we wanted!
 *
 *
 *
 * Your code should look like:
 *
 *
 *
 * void modified_inorder(root, k)
 *
 * {
 *
 * handle base case;
 *
 * modified_inorder(root->l);
 *
 * if (answer is not found in left subtree)
 *
 * {
 *
 * counter++;	// make sure that you are incrementing after left subtree is visited.
 *
 * consider current node;
 *
 * modified_inorder(root->r);
 *
 * }
 *
 * }
 *
 *
 *
 *
 *
 *
 *
 * Now have a look at the code provided by us.
 *
 *
 *
 * Time complexity:
 *
 * In terms of N we can write it as O(N).
 *
 *
 *
 * Using other variables we can write tighter bound for the same solution. In terms of height of the tree and k, we can write tighter bound as O(height of tree + k).
 *
 * The code first traverses down to the leftmost node which takes O(h) time, then traverses k elements in O(k) time. Therefore overall time complexity is O(h + k).
 *
 *
 *
 * Note that even if k=1 the algorithm has to go all the way down the tree to find the smallest element, visiting all the nodes on the way, and visiting one node takes constant time. So far we have used O(h) time where h is the height of the tree (worst case is when the left-most leaf of the tree is the longest one).
 *
 *
 *
 * Having gone all the way down to the smallest element, the algorithm then visits exactly k nodes from there (still constant time per node); complexity so far is O(h) + O(k).
 *
 *
 *
 * Having found and saved the k-th element value, the algorithm still needs to pop out from the recursion depth so that it can return the answer in the end. For that it will use constant time per level of recursion, per depth of the tree (worst case again is when we have found the k-th element at the leaf of the longest branch of the tree). That takes another O(h) time. Therefore the overall time complexity: O(h) + O(k) + O(h) = O(2h + k) = O(h + k).
 *
 *
 *
 *
 *
 *
 *
 * Auxiliary space used:
 *
 * O(height of the tree) due to recursive calls. (Assuming that you are already given BST you are not creating it.)
 *
 *
 *
 *
 *
 *
 *
 * Space complexity:
 *
 * O(N) due to input array and BST.
 */

import java.io.*;
import java.util.*;

public class KSmallest {

  static class TreeNode
  {
    int val;
    TreeNode left_ptr;
    TreeNode right_ptr;

    TreeNode(int _val)
    {
      val = _val;
      left_ptr = null;
      right_ptr = null;
    }
  };

  static TreeNode bst_insert(TreeNode root, int val)
  {
    if (root == null)												// destination.
    {
      return new TreeNode(val);
    }
    if (val <= root.val)											// element is <= hence insert it in left subtree.
    {
      root.left_ptr = bst_insert(root.left_ptr, val);			      // if root->left_ptr is null then new TreeNode will be created and root->left_ptr is assigned its address else it will be assigned to the same value as previouly stored.
    }
    else  															// element is > hence insert it in right subtree.
    {
      root.right_ptr = bst_insert(root.right_ptr, val);			// if root->right_ptr is null then new TreeNode will be created and root->right_ptr is assigned its address else it will be assigned to the same value as previouly stored.
    }
    return root;
  }

  //Working Solution
  //Why I cannot use primitive int as a counter. When you assign it a new value, a new variable is created on stack, so when you recurse back, the old value of the couter variable is no available anymore, hence we need to create a reference too it so that when we recurse back, the correct coutner value is picked up. https://stackoverflow.com/questions/18037082/are-java-primitives-immutable
  // static int kth_element;
  // static int kth_smallest_element(TreeNode root, int k) {
  //     int[] count = new int[1];
  //     helper(root,k,count);
  //     return kth_element;
  // }
  // private static void helper(TreeNode root, int k, int[] count){
  //     if (root==null)
  //         return;
  //     helper(root.left_ptr, k, count);
  //     count[0]++;
  //     if(k == count[0]){
  //         kth_element = root.val;
  //         return;
  //     }
  //     helper(root.right_ptr, k, count);
  // }


  static int kth_smallest_element(TreeNode root, int k) {
    int[] count = new int[1];
    TreeNode node = helper(root,k,count);
    return node.val;
  }
  private static TreeNode helper(TreeNode root, int k, int[] count){
    if (root==null)
      return null;

    TreeNode leftNode = helper(root.left_ptr, k, count);
    count[0]++;
    if(k == count[0]){
      return root;
    }
    TreeNode rightNode = helper(root.right_ptr, k, count);

    return (leftNode!=null)?leftNode:rightNode;
    // return null;

  }

  public static void main(String[] args) throws IOException {
    Scanner in = new Scanner(System.in);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(in.nextLine().trim());

    TreeNode root = null;

    for (int i = 0; i < N; i++)
    {
      int data = Integer.parseInt(in.nextLine().trim());
      root = bst_insert(root, data);
    }

    int k= Integer.parseInt(in.nextLine().trim());

    int ans = kth_smallest_element(root, k);

    bw.write(String.valueOf(ans));
    bw.newLine();

    bw.close();
  }
}
