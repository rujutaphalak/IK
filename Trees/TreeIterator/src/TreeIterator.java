/**
 * Tree Iterator
 *
 *
 *
 * Problem Statement:
 *
 *
 *
 * Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.
 *
 *
 *
 * 1. Calling next() will return the next smallest number in the BST.
 *
 * 2. Calling hasNext() should return whether the next element exists.
 *
 *
 *
 * Both functions should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
 *
 *
 *
 * [Iterator is a concept in higher level languages like C++ or Java. You probably can tell what it is. If you want to know more, please feel free to Google for the concept.]
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
 * There is nothing to return as a whole. What the given method will do is described below:
 *
 * Constructor/initializer: Initialize the iterator.
 *
 * next(): Returns an integer denoting the next node value.
 *
 * hasNext(): Returns a boolean denoting the next nodes presence.
 *
 *
 *
 *
 *
 * Constraints:
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
 * ../../../../../Desktop/Screen%20Shot%202019-02-25%20at%203.3
 *
 *
 *
 * Sample Output:
 *
 *
 *
 * 1 2 3
 */

/**
 *  We have provided only the optimal solution for this problem.
 *
 *
 *
 *  The problem asks to implement an iterator over a binary search tree so that hasNext() method of the iterator returns a true of false flag denoting the next nodes presence. And another method next() which return next node’s value. Iterator must iterate from the left most node to right most node so that nodes are in ascending order. The idea is that, the iterator should traverse the tree in in-order traversal approach. So, while initializing, we pushed root, root’s left child, root’s left child’s left child untile reach a null node into the stack. After initialization, left most node is at the top of stack. When next() method is invoked, top element from the stack is popped. As all left nodes are pushed from current top node, we push all left nodes starting from top node’s right child. This process continues until all nodes are traversed and popped from the stack.
 *
 *
 *
 *  Time complexity:
 *
 *  O(N)
 *
 *
 *
 *  Auxiliary space:
 *
 *  O(N) because of using stack
 *
 *
 *
 *  Space complexity:
 *
 *  Including input, O(N)
 */

import java.util.Stack;
public class TreeIterator {

  public static class BSTIterator{

    Stack<TreeNode> s = new Stack<>();

    public BSTIterator(TreeNode root){
      insertNodeUptoLeaf(root);
    }

    private void insertNodeUptoLeaf(TreeNode root){
      while(root!=null){
        s.push(root);
        root = root.left_ptr;
      }
    }

    public boolean hasNext(){
      return (!s.empty());
    }

    public int next(){
      TreeNode current = s.pop();
      insertNodeUptoLeaf(current.right_ptr);
      return current.val;
    }
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
