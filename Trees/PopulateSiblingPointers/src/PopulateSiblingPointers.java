/**
 * Populate Sibling Pointers
 *
 *
 *
 *
 *
 * Problem Statement:
 *
 *
 *
 * Given a binary tree, populate nextRight pointers in each node and return the root of the tree.
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
 * Return the root of the tree after populating nextRight pointers
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
 * ../../../../../Desktop/Screen%20Shot%202019-02-14%20at%204.5
 *
 *
 *
 * Sample Output:
 *
 *
 *
 * ../../../../../Desktop/Screen%20Shot%202019-02-14%20at%204.5
 *
 *
 *
 * Explanation:
 *
 *
 *
 * ﻿﻿﻿There are three levels in the input tree. If we write the node values level wise then we get:
 *
 * Level 1: 1
 *
 * Level 2: 2, 3
 *
 * Leve 3: 4, 5, 6, 7
 *
 *
 *
 * In first level there is only one node. So, next right of node having value 1 is null.
 *
 * In second level, there are 2 nodes. Left most node’s next right pointer is right most node.
 *
 * In third level, there are 4 nodes. Second node is next right of first node, third node is next right to second node and fourth node is next right of third node.
 */

/**
 * Editorial by IK
 *
 Problem Statement
 Previous Submissions
 Editorial
 Top Submissions

 We have provided two solutions for this problem. Both are optimal considering time complexity and memory complexity.



 1.optimal_solution.cpp:



 In this solution we have followed BFS or level wise traversal approach to populate the next right pointer. We have pushed the nodes level wise and processed level by level. Let’s say in a level there are K nodes. In that case, i’th nodes nextRight node is (i+1)th node where i < K-1.



 Time complexity:

 O(N)



 Auxiliary space:

 O(N) because of using queue



 Space complexity:

 Including input, O(N)



 2.other_solution.cpp:



 In this solution we have followed DFS traversal approach to populate the next right pointer. Left child’s nextRight pointer is right child. Right child’s nextRight pointer is parent’s nextRight node’s left pointer.



 Time complexity:

 O(N)



 Auxiliary space:

 O(N) because of using stack



 Space complexity:

 Including input, O(N)




 */
import java.util.*;
public class PopulateSiblingPointers {

  private static class TreeNode{
    public int val;
    public TreeNode left_ptr;
    public TreeNode right_ptr;
    public TreeNode nextRight;

    public TreeNode(){
      this.left_ptr = null;
      this.right_ptr = null;
      this.nextRight = null;
    }

    public TreeNode(int val){
      this.val = val;
      this.left_ptr = null;
      this.right_ptr = null;
      this.nextRight = null;
    }
  }

  /*
    Complete the function below
*/
  static TreeNode populateSiblingPointers(TreeNode root){
    return helper(root);
  }

  static TreeNode helper(TreeNode root){
    if(root==null)
      return null;

    Queue<TreeNode> q = new LinkedList<TreeNode>();
    q.add(root);
    while(!q.isEmpty()){
      TreeNode previous = null;
      int size= q.size();

      for(int i=0;i<size;i++){
        TreeNode currentNode = q.poll();

        if(previous!=null)
          previous.nextRight = currentNode;

        if(currentNode.left_ptr!=null)
          q.add(currentNode.left_ptr);

        if(currentNode.right_ptr!=null)
          q.add(currentNode.right_ptr);

        previous=currentNode;
      }
    }

    return root;
  }


}
