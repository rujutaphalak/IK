/**
 * Construct_Binary_Tree
 *
 *
 *
 *
 *
 * Problem Statement:
 *
 *
 *
 * Inorder traversal - Process all nodes of a binary tree by recursively processing the left subtree, then processing the root, and finally the right subtree.
 *
 * Preorder traversal - Process all nodes of a binary tree by recursively processing the root, then processing the left subtree, and finally the right subtree.
 *
 *
 *
 * Given the inorder and preorder traversal of a valid binary tree, you have to construct the binary tree.
 *
 *
 *
 * [Interesting article to read: http://www.geeksforgeeks.org/if-you-are-given-two-traversal-sequences-can-you-construct-the-binary-tree/]
 *
 *
 *
 *
 *
 * Input Format:
 *
 *
 *
 * You are given two integer array named inorder and preorder of size n, containing positive values <= 10^5
 *
 *
 *
 * Output Format:
 *
 *
 *
 * Return root pointer of the constructed binary tree.
 *
 *
 *
 * Constraints:
 *
 *
 *
 * 0 <= n <= 10^5
 * 1 <= inorder[i], preorder[i] <= 10^5
 * Values stored in the binary tree are unique.
 *
 *
 * Sample Test Cases:
 *
 *
 *
 * Sample Test Case 1:
 *
 *
 *
 * Sample Input 1:
 *
 *
 *
 * inorder = [2, 1, 3] and preorder = [1, 2, 3]
 *
 *
 *
 * Sample Output 1:
 *
 *
 *
 *   1
 *
 * / \
 *
 * 2 3
 *
 *
 *
 * Explanation 1:
 *
 *
 *
 * In this case, Binary tree will be look like as given above.
 *
 *
 *
 * Return the pointer of root node of constructed binary tree. In this case root treenode has value '1'.
 *
 *
 *
 * Sample Test Case 2:
 *
 *
 *
 * Sample Input 2:
 *
 *
 *
 * inorder = [3, 2, 1, 5, 4, 6] and preorder = [1, 2, 3, 4, 5, 6]
 *
 *
 *
 * Sample Output 2:
 *
 *
 *
 *     1
 *
 *    / \
 *
 *  2 4
 *
 *  / / \
 *
 * 3 5    6
 */

/**
 * Edirial by IK
 * We will learn recursive approach by taking an example:
 *
 *
 *
 * Let's take example from sample input:
 *
 *
 *
 * inorder[] = [3, 2, 1, 5, 4, 6]
 *
 * preorder[] = [1, 2, 3, 4, 5, 6]
 *
 *
 *
 * Here, as per preorder traversal definition it traverse the tree recursively by travesing the root first, then left subtree and then right subtree.
 *
 *
 *
 *
 *
 * So, we can say that first value of preorder[] is root node value of binary tree, here its 1.
 *
 *
 * Now, search the index of that value in inorder[]. Say you find it at position i, once you find it, make note of elements which are left to i (This will construct the left subtree) and elements which are right to i (This will construct the right subtree).
 *
 *
 * See the above steps and recursively build left subtree and link it root.left and recursively build right subtree and link it root.right.
 *
 *
 *
 * Let's have a look how recursion will happen in our case,
 *
 *
 *
 * Root:
 *
 *
 *
 * (1's position confirmed)
 *
 *
 *
 *            1
 *
 *           / \
 *
 *    [3,2]    [5,4,6]
 *
 *
 *
 *
 *
 * In the left subtree of the root:
 *
 *
 *
 * (2's position confirmed)
 *
 *
 *
 *            1
 *
 *           / \
 *
 *         2 [5,4,6]
 *
 *         |
 *
 *        [3]
 *
 *
 *
 *
 *
 * (3's position confirmed)
 *
 *
 *
 *            1
 *
 *           / \
 *
 *         2 [5,4,6]
 *
 *        /
 *
 *      3
 *
 *
 *
 *
 *
 * In the right subtree of the root:
 *
 *
 *
 * (4's position confirmed)
 *
 *
 *
 *            1
 *
 *           / \
 *
 *         2 4
 *
 *        / |
 *
 *      3 [5,6]
 *
 *
 *
 *
 *
 * (5's position confirmed)
 *
 *
 *
 *            1
 *
 *           / \
 *
 *         2 4
 *
 *        / / |
 *
 *      3 5 [6]
 *
 *
 *
 *
 *
 * (6's position confirmed)
 *
 *
 *
 *            1
 *
 *           / \
 *
 *         2 4
 *
 *        / / \
 *
 *      3 5    6
 *
 *
 *
 *
 *
 * So, the above tree will be our binary tree for given test case. Return the root treenode which is 1 in this case.
 *
 *
 *
 *
 *
 * 1) brute_solution.java
 *
 *
 *
 * Time Complexity:
 *
 *
 *
 * O(n^2), here n is length of given inorder[] or preorder[] array, in other words count of total treenodes of binary tree.
 *
 *
 *
 * Suppose you are given tree in which all nodes have only left child, there is no right child of any treenode, then for every preorder[] value it will take O(n) to search in inorder[].
 *
 *
 *
 * So, In worst case time complexity will be O(n^2).
 *
 *
 *
 * Auxiliary Space Used:
 *
 *
 *
 * O(n).
 *
 *
 *
 * As we are constructing the binary tree and storing values in treenodes. Every node will take constant space to store value and addresses for left and right treenode. So, it will be O(n).
 *
 *
 *
 * Space Complexity:
 *
 *
 *
 * O(n).
 *
 *
 *
 * As input is O(n) and auxiliary space used is also O(n).
 *
 *
 *
 * So, O(n) + O(n) -> O(n).
 *
 *
 *
 *
 *
 * 2) optimal_solution.java
 *
 *
 *
 * Time Complexity:
 *
 *
 *
 * O(n).
 *
 *
 *
 * We are using hashmap to search index of value in inorder[], and hashmap takes O(1) time (search in hash map can be upto O(n) in worst case, when values are in wide range and carefullly chosen) to search value. So, in every case time complexity will be O(n).
 *
 *
 *
 * Auxiliary Space Used:
 *
 *
 *
 * O(n).
 *
 *
 *
 * As we are constructing binary tree and storing value in treenode, so every node will take constant space to store value and addresses for left and right treenode. Here, we are using hashmap to store inorder[] values with index and it will take O(n) space to store <value,index> pair. So, Auxiliary space will be O(n) + O(n) -> O(n).
 *
 *
 *
 * Space Compelxity:
 *
 *
 *
 * O(n).
 *
 *
 *
 * As input is O(n) and auxiliary space used is also O(n).
 *
 *
 *
 * So, O(n) + O(n) -> O(n).
 */

import java.util.*;
public class ConstructBinaryTree {

  static int current_index;

  public static TreeNode constructBinaryTree(List<Integer> inorder, List<Integer> preorder) {
    int sz = inorder.size();
    Map<Integer,Integer> map = new HashMap<>();
    for(int i=0; i<sz;i++){
      map.put(inorder.get(i), i);
    }
    current_index=0;
    return constructBinaryTree(inorder, preorder, 0, sz-1, map);
  }

  private static TreeNode constructBinaryTree(List<Integer> inorder, List<Integer> preorder, int start, int end, Map<Integer,Integer> map) {
    if(start>end)
      return null;
    TreeNode root = new TreeNode(preorder.get(current_index));
    current_index++;
    if(start == end)
      return root;

    int root_index = map.get(root.value);
    root.left = constructBinaryTree(inorder,preorder,start, root_index-1, map);
    root.right = constructBinaryTree(inorder,preorder,root_index+1,end, map);

    return root;
  }

 static class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
      value = x;
      left=null;
      right=null;
    }
  }



}
