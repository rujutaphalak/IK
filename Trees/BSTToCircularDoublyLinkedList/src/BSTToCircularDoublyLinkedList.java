import javax.swing.tree.TreeNode;

/**
 * Convert a BST into a Circular Doubly Linked List
 *
 *
 *
 * Problem Statement:
 *
 *
 *
 * Write a recursive function BSTtoLL(TreeNode root) that takes a BST and rearranges the internal pointers to make a circular doubly linked list out of the tree nodes. The "previous" pointers should be stored in the "left_ptr" field and the "next" pointers should be stored in the "right_ptr" field. The list should be arranged so that the nodes are in increasing order. Print (space separated) the resulting linked list starting from its head node. (see	test-case output to understand the formatting). The operation can be done in O(n) time
 *
 *
 *
 * e.g. for a tree that's
 *
 * ﻿﻿﻿
 *
 * ../../../../../Desktop/Screen%20Shot%202019-02-11%20at%2010.5
 *
 *
 *
 * Print:
 *
 * 1 2 3 4 5 6 7
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
 * Print the node values in post-order traversal of the tree
 *
 *
 *
 * Constraints:
 *
 *
 *
 * 0 <= number of nodes <= 100000
 * 1 <= values stored in the nodes <= 10^9
 * Input tree will be a BST
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
 * 1 2 3 4 5
 *
 *
 *
 * Explanation:
 *
 *
 *
 * As the output must be must be in increasing order, so left most node will be the head of the resultant circular doubly linked list. The circular list will look like the following:
 *
 *
 *
 * ../../../../../Desktop/Screen%20Shot%202019-02-11%20at%2011.0
 */

/**
 * Editorial by IK
 * We have provided two solutions for this problem. Both solutions are optimal. Difference between these solution is the traversal approach of a tree. optimal_solution.cpp uses post-order traversal where other_solution.cpp uses in-order traversal.
 *
 *
 *
 * 1.other_solution.cpp:
 *
 * This solution uses in-order traversal approach of a tree and create a doubly linked list. It also stores head and tail pointer of the doubly linked list so that they can be connected to form a circular doubly linked list. Process are:
 *
 * Traverse left subtree and create a doubly linked list. Let’s address it as leftDLL. Left most node is marked as head node.
 * Place root node after the tail of leftDLL and root node becomes the new tail.
 * Traverse right subtree and create a doubly linked list. Let’s address is as rightDLL. Place head of rightDLL after tail and tail of right DLL becomes new tail node.
 * Connect head and tail node to form a circular DLL.
 *
 *
 * Tricky part of this approach is to update the tail node. The tail node is the last visited node of the tree.
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
 *
 *
 *
 * 2.optimal_solution.cpp:
 *
 * This solution uses post-order traversal approach of a tree and creates a circular doubly linked list. Process are:
 *
 * Traverse left subtree and create a circular doubly linked list. Let’s address it as leftCDLL
 * Traverse right subtree and create a doubly linked list. Let’s address is as rightCDLL.
 * Created a circular doubly linked list using the root node only. Let’s call it rootCDLL.
 * Connect leftCDLL and rootCDLL. Let’s address it as leftRootCDLL. Head will be head of leftCDLL.
 * Connect leftRootCDLL and rightCDLL and let’s call it resultCDLL. Head will be the head of leftRootCDLL.
 *
 *
 * Tricky part of this approach is to connect two CDLL. Approach to connect two CDLL is described below. For convenience, we will use leftCDLL as first CDLL and rightCDLL as second CDLL to connect.
 *
 * If one of them is null return other one.
 * Find out tail of leftCDLL. Let’s denote it as leftTail.
 * Find out tail of rightCDLL. Let’s denote it as rightTail.
 * Connect leftTail and head of rightCDLL.
 * Connect rightTail and head of leftCDLL.
 * Mark head of leftCDLL as the head of resultant CDLL.
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

import java.util.*;

public class BSTToCircularDoublyLinkedList {

  static class TreeNode{
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

    private static class BinaryTree{
      public class Edge{
        public int parentNodeIndex;
        public int childNodeIndex;
        public String leftRightFlag;

        public Edge(){}

        public Edge(int parentNodeIndex, int childNodeIndex, String leftRightFlag){
          this.parentNodeIndex = parentNodeIndex;
          this.childNodeIndex = childNodeIndex;
          this.leftRightFlag = leftRightFlag;
        }
      }

      public int noOfNodes;
      public ArrayList<Integer> nodeValues;
      public int rootIndex;
      public int noOfEdges;
      public ArrayList<Edge> edges;
      public TreeNode root;

      public BinaryTree(){
        noOfNodes = 0;
        rootIndex = -1;
        noOfEdges =0;
        nodeValues = new ArrayList();
        edges = new ArrayList();
        root  = null;
      }

      public void readRawValues(){
        Scanner scan = new Scanner(System.in);

        noOfNodes = scan.nextInt();
        for(int i=0;i<noOfNodes;i++){
          int nodeVal = scan.nextInt();
          nodeValues.add(nodeVal);
        }

        rootIndex = scan.nextInt();

        noOfEdges = scan.nextInt();
        for(int i=0;i<noOfEdges;i++){
          int parentNodeIndex = scan.nextInt();
          int childNodeIndex = scan.nextInt();
          String leftRightFlag = scan.next();
          edges.add(new Edge(parentNodeIndex, childNodeIndex, leftRightFlag));
        }
      }

      public void buildFromRawValues(){
        if(noOfNodes == 0){
          root =  null;
          return;
        }

        ArrayList<TreeNode> nodes = new ArrayList<TreeNode>();
        for(int i=0;i<noOfNodes;i++){
          nodes.add(new TreeNode(nodeValues.get(i)));
        }

        for(int i=0;i<noOfEdges;i++){
          if(edges.get(i).leftRightFlag.equals("L")){
            nodes.get(edges.get(i).parentNodeIndex).left_ptr
                = nodes.get(edges.get(i).childNodeIndex);
          }else{
            nodes.get(edges.get(i).parentNodeIndex).right_ptr = nodes.get(edges.get(i).childNodeIndex);
          }
        }

        root = nodes.get(rootIndex);
        return;
      }
    }

    public static TreeNode readBinaryTree(){
      BinaryTree inputBinaryTree = new BinaryTree();
      inputBinaryTree.readRawValues();
      inputBinaryTree.buildFromRawValues();
      return inputBinaryTree.root;
    }

    public static void printCircularList(TreeNode circularListHead){
      if(circularListHead == null){
        System.out.println();
        return;
      }
      TreeNode tmpHead = circularListHead;
      while(tmpHead.right_ptr != circularListHead){
        System.out.print(tmpHead.val+" ");
        tmpHead = tmpHead.right_ptr;
      }
      System.out.println(tmpHead.val);
    }



  public static void main(String[] args){
    try{
      /*Sample test case print this  below
      5
      1 2 3 4 5
      0
      4
      0 1 L
      0 2 R
      1 3 L
      1 4 R
      */
      TreeNode root = readBinaryTree();
      TreeNode result = BSTtoLL(root);
      printCircularList(result);
    }catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  //The reason this doesn't work is because I am not returning the TreeNode head and tail.
//  static TreeNode BSTtoLL(TreeNode root){
//    if (root==null)
//      return root;
//    TreeNode head = new TreeNode();
//    TreeNode tail = new TreeNode();
//    BSTtoLLHelper(root, head, tail);
//    tail.right_ptr = head;
//    head.left_ptr = tail;
//    return head;
//  }
//
//  private static void BSTtoLLHelper(TreeNode root, TreeNode head, TreeNode tail) {
//      if(root== null){
//        return;
//      }
//      BSTtoLLHelper(root.left_ptr, head, tail);
//      if(head==null){
//        head = root;
//      }
//      //this one is the trick here to keep track of the tail
//      if(tail != null){
//        tail.right_ptr =root;
//        root.left_ptr = tail;
//      }
//      tail=root;
//      BSTtoLLHelper(root.right_ptr, head, tail);
//  }

  //Why does thw above program not work? Why is the output null?????????????????????????????????????????
  static TreeNode BSTtoLL(TreeNode root){
    if (root==null)
      return root;
    TreeNode[] arr= new TreeNode[2];
    BSTtoLLHelper(root, arr);
    arr[1].right_ptr = arr[0];
    arr[0].left_ptr = arr[1];
    return arr[0];
  }

  private static void BSTtoLLHelper(TreeNode root, TreeNode[] arr) {
    if(root== null){
      return;
    }
    BSTtoLLHelper(root.left_ptr, arr);
    if(arr[0]==null){
      arr[0] = root;
    }
    //this one is the trick here to keep track of the tail
    if(arr[1] != null){
      arr[1].right_ptr =root;
      root.left_ptr = arr[1];
    }
    arr[1]=root;
    BSTtoLLHelper(root.right_ptr, arr);
  }
}
