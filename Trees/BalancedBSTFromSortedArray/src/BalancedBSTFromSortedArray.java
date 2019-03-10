/**
 * Balanced BST From A Sorted Array
 *
 *
 *
 * Problem Statement:
 *
 *
 *
 * Given a sorted array a of size N containing distinct integers, you have to build a balanced binary search tree of a.
 *
 *
 *
 * A binary search tree is balanced if, for each node, a condition holds that the number of nodes in the left subtree and the number of nodes in the right subtree differ by at most 1.
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
 * There is only one argument denoting array a.
 *
 *
 *
 * Output Format:
 *
 *
 *
 * You have to return the root root of the balanced BST that you created.
 *
 *
 *
 * There can be multiple balanced BST for given input. So, you are free to return any of the valid one.
 *
 *
 *
 * Only thing you have to consider is that it is a valid balanced BST of a.
 *
 *
 *
 * Consider a = [1, 2] then:
 *
 * 1) 1 is the root of the tree and 2 is 1's right child.
 *
 * 2) 2 is the root of the tree and 1 is 2's left child.
 *
 *
 *
 * Both of them will be considered as correct answer.
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
 * The first line of input should contain an integer N, denoting size of input array a. In next N lines, ith line should contain an integer a[i], denoting a value at index i of a.
 *
 *
 *
 * If N = 7 and a = [8, 10, 12, 15, 16, 20, 25], then input should be:
 *
 *
 *
 * 7
 *
 * 8
 *
 * 10
 *
 * 12
 *
 * 15
 *
 * 16
 *
 * 20
 *
 * 25
 *
 *
 *
 * Output Format:
 *
 *
 *
 * There will be one line of output, containing a string “Valid Balanced BST” or “Invalid Balanced BST”.
 *
 * If the root returned by solution function corresponds to a valid balanced BST, then “Valid Balanced BST”, else “Invalid Balanced BST” will be there in output.
 *
 *
 *
 * For input N = 7 and a = [8, 10, 12, 15, 16, 20, 25], output will be:
 *
 *
 *
 * Valid Balanced BST
 *
 *
 *
 * Constraints:
 *
 * a is sorted.
 * a contains distinct integers.
 * -2 * 10^9 <= a[i] <= 2 * 20^9
 * 1 <= N <= 10^5
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
 * a = [8 10 12 15 16 20 25]
 *
 *
 *
 * Sample Output:
 *
 *
 *
 * Root of the Balanced BST where:
 *
 * 15 is the root node.
 *
 * 10 is 15's left child.
 *
 * 20 is 15's right child.
 *
 * 8 is 10's left child.
 *
 * 12 is 10's right child.
 *
 * 16 is 20's left child.
 *
 * 25 is 20's right child.
 *
 *
 *
 * Explanation:
 *
 *
 *
 * For each node, number of nodes in left subtree and number of nodes in right subtree are same (differ by 0) and also it is a BST. Hence it is a balanced BST.
 *
 *
 *
 * Notes:
 *
 * Maximum time allowed in interview: 20 Minutes.
 */

/**
 * Editorial by IK
 * Balanced tree has two definitions:
 *
 * 1) weight-balanced: here we focus on difference in number of nodes in left and right subtree. (Perfect tree)
 *
 * 2) height-balanced: here we focus on difference in height of left and right subtree. (AVL tree, Red-Black tree)
 *
 *
 *
 * In this problem we need to consider weight-balanced tree.
 *
 *
 *
 * Only thing we need to know in order to solve the problem is what should be the root of the tree.
 *
 * We need to choose middle element as the root and this is enough to solve the problem.
 *
 *
 *
 * Now lets see why middle element?
 *
 *
 *
 * Suppose in our balanced BST, left subtree of the root contains l nodes and right subtree of the root contains r nodes.
 *
 * Then we can write it as:
 *
 *
 *
 * number of nodes in left subtree + 1 (root) + number of nodes in right subtree = total number of nodes in tree.
 *
 *
 *
 * l + 1 + r = N.
 *
 * with |l - r| <= 1.
 *
 *
 *
 * so we can write it as:
 *
 *
 *
 * l + r = N - 1,
 *
 * and |l - r| <= 1 has 3 possibilities,
 *
 * 1) l = r
 *
 * or
 *
 * 2) l = r + 1
 *
 * or
 *
 * 3) l = r - 1
 *
 *
 *
 * Now let's think what should be l and r when:
 *
 * 1) N is odd:
 *
 *
 *
 * try first option l = r,
 *
 *
 *
 * r + r = N - 1
 *
 * 2 * r = N - 1
 *
 * r = (N - 1) / 2 is possible because N is odd hence N - 1 is even!
 *
 *
 *
 * try second option l = r + 1,
 *
 *
 *
 * r + 1 + r = N - 1
 *
 * r + r = N - 2
 *
 * 2 * r = N - 2
 *
 * r = (N - 2) / 2 is not possible because N is odd hence N - 2 is also odd hence r will not be an integer!
 *
 *
 *
 * try third option l = r - 1,
 *
 *
 *
 * r - 1 + r = N - 1
 *
 * 2 * r = N
 *
 * r = N / 2 is not possible because N is odd hence r will not be an integer!
 *
 *
 *
 * 2) when N is even:
 *
 *
 *
 * try first option l = r,
 *
 *
 *
 * r + r = N - 1
 *
 * 2 * r = N - 1
 *
 * r = (N - 1) / 2 is not possible because N is even hence N - 1 is odd hence r will not be an integer!
 *
 *
 *
 * try second option l = r + 1,
 *
 *
 *
 * r + 1 + r = N - 1
 *
 * r + r = N - 2
 *
 * 2 * r = N - 2
 *
 * r = (N - 2) / 2 is possible because N is even hence N - 2 is also even!
 *
 *
 *
 * try third option l = r - 1,
 *
 *
 *
 * r - 1 + r = N - 1
 *
 * 2 * r = N
 *
 * r = N / 2 is possible because N is even hence N - 2 is also even!
 *
 *
 *
 * When N is odd we need to select (N - 1) / 2 th element (the middle element, 0-indexed) as the root of the tree. Both left and right subtree will receive same number of nodes.
 *
 *
 *
 * When N is even then we need to select
 *
 * 1) (N - 1) / 2 th element (left middle element, 0-indexed) as the root of the tree. In this case right subtree will receive one more node than left subtree.
 *
 * or
 *
 * 2) N / 2 th element (right middle element, 0-indexed) as the root of the tree. In this case left subtree will receive one more node than right subtree.
 *
 *
 *
 * Problem we are solving is, given N elements build a balanced BST. Now once we have fixed our root we need to solve the same problem again with smaller constrains hence we can use the same function by recursive calls!
 *
 *
 *
 * Now check out solution provided by us for implementation details.
 *
 *
 *
 * Time complexity:
 *
 * T(N) = 2 * T(N / 2) + O(1) which will be O(N).
 *
 *
 *
 * More intuitive explanation is: function is just creating new node and assigning value to that node, that is O(1) computation. And in our tree we will create exactly N nodes!
 *
 *
 *
 * Auxiliary space and Space complexity:
 *
 * O(N) because we are creating a tree containing N nodes.
 */

import java.io.*;
import java.util.*;

public class BalancedBSTFromSortedArray {

  static TreeNode build_balanced_bst(int[] a)
  {
    return build_balanced_bst_rec(a,0,a.length-1);

  }

  private static TreeNode build_balanced_bst_rec(int[] a, int left, int right){

    if(left > right)
      return null;

    int mid = (left+right)/2;

    TreeNode root = new TreeNode(a[mid]);

    root.left_ptr = build_balanced_bst_rec(a,left,mid-1);
    root.right_ptr = build_balanced_bst_rec(a,mid+1,right);

    return root;
  }

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
  }


  static boolean check_balanced_bst(TreeNode root, int l, int r, int[] a)
  {
    if (l > r && root == null)                              // If no value in [l, r] and tree is also empty.
    {
      return true;
    }
    else if (l > r && root != null)                         // If no value in [l, r] but tree contains something.
    {
      return false;
    }
    if (root == null)                                       // If some values in [l, r] but tree is empty.
    {
      return false;
    }

    int mid1 = l + (r - l) / 2;
    int mid2 = l + (r - l + 1) / 2;

    boolean valid1 = (root.val == a[mid1] && check_balanced_bst(root.left_ptr, l, mid1 - 1, a) && check_balanced_bst(root.right_ptr, mid1 + 1, r, a));
    if (valid1)                                             // actually we are doing valid1 || valid2 but when valid1 is true then no need to find valid2
    {
      return true;
    }
    if (mid1 == mid2)                                       // when odd no of elements in [l, r] then mid1 = mid2 so valid1 = valid2 and no need to find valid2.
    {
      return false;
    }
    return (root.val == a[mid2] && check_balanced_bst(root.left_ptr, l, mid2 - 1, a) && check_balanced_bst(root.right_ptr, mid2 + 1, r, a));
  }


  public static void main(String[] args) throws IOException {
    Scanner in = new Scanner(System.in);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int a_size = 0;
    a_size = Integer.parseInt(in.nextLine().trim());

    int[] a = new int[a_size];
    for(int i = 0; i < a_size; i++) {
      int a_item;
      a_item = Integer.parseInt(in.nextLine().trim());
      a[i] = a_item;
    }

    TreeNode root = build_balanced_bst(a);

    if (check_balanced_bst(root, 0, a_size - 1, a))
    {
      bw.write("Valid Balanced BST");
    }
    else
    {
      bw.write("Invalid Balanced BST");
    }
    bw.newLine();

    bw.close();
  }
}
