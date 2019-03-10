/**
 * Upside Down
 *
 *
 *
 * Problem Statement:
 *
 *
 *
 * Given a binary tree where all the right nodes are leaf nodes, flip it upside down and turn it into a binary tree with left leaf nodes.
 *
 *
 *
 * Keep in mind: ALL RIGHT NODES IN ORIGINAL TREE ARE LEAF NODE.
 *
 *
 *
 * For example, turn these:
 *
 *
 *
 *      1
 *
 *     / \
 *
 *    2 3
 *
 *   / \
 *
 *  4 5
 *
 * / \
 *
 * 6  7
 *
 *
 *
 *  1
 *
 * / \
 *
 * 2  3
 *
 *
 *
 * into these:
 *
 *
 *
 *      1
 *
 *     /
 *
 *    2---3
 *
 *   /
 *
 *  4---5
 *
 *  /
 *
 * 6---7
 *
 *
 *
 *
 *
 *  1
 *
 * /
 *
 * 2---3
 *
 *
 *
 * where 6 is the new root node for the first tree, and 2 for the second tree.
 *
 *
 *
 * oriented correctly:
 *
 *
 *
 *  6
 *
 * / \
 *
 * 7   4
 *
 *    / \
 *
 *   5 2
 *
 *        / \
 *
 *       3 1
 *
 *
 *
 *
 *
 *   2
 *
 *  / \
 *
 * 3   1
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
 * You have to return the root of the flipped upside down tree.
 *
 *
 *
 * Constraints:
 *
 * 0 <= number of nodes <= 100000
 * 1 <= values stored in the nodes <= 100000
 * Every node either has 0 or 2 children.
 * Solution should use only constant extra space.
 *
 *
 * Sample Test Case:
 *
 * ﻿﻿﻿﻿﻿﻿﻿﻿﻿﻿
 *
 * Sample Input:
 *
 *
 *
 *   1
 *
 *  / \
 *
 * 2  3
 *
 *
 *
 * Sample Output:
 *
 *
 *
 *   2
 *
 *  / \
 *
 * 3  1
 */

import javax.swing.tree.TreeNode;

/**
 * Editorial section by IK
 * We have provided two solutions for this problem. Both are optimal in considering time complexity. But considering memory complexity optimal_solution.cpp is optimal as it uses O(1) extra memory. other_solution.cpp uses O(N) stack memory as this solution is recursive.
 *
 *
 *
 * For better understanding we are describing the recursive solution here. Please note that, both solutions follow the same logic. optimal_solution.cpp is an iterative solution while other_solution is a recursive solution.
 *
 *
 *
 * Number of nodes in this problem can be either 0 or an odd number. When number of node is 0 or 1, we need not to do anything, just return. The smallest tree which can be flipped has 3 nodes. Let’s consider the following tree as our input tree:
 *
 *
 *
 *
 *
 *
 *
 * After flipping the tree upside-down it will be:
 *
 *
 *
 * Here we can see that:
 *
 * Left child of the input tree becomes root of the output.
 * Right child of the input tree becomes left child of the output tree.
 * Root of the input tree becomes the right right child of the output tree.
 *
 *
 * So, programmatically we can do the following:
 *
 *
 *
 * (Here, root is the node containing value 1.)
 *
 * root.left_ptr.left_ptr = root.right_ptr
 *
 * root.left_ptr.right_ptr = root
 *
 *
 *
 * After this operation the tree looks like following (tree is oriented still root is the node containing value 1):
 *
 *
 *
 *
 * So, we have to unlink left and right child from current root. We can do this defining left and right child as null for current root. So programmatically:
 *
 *
 *
 * root.left_ptr = null
 *
 * root.right_ptr  = null
 *
 *
 *
 * Now, let’s take a look with a bigger tree. A tree with 5 nodes will look like:
 *
 *
 *
 * As we are describing the recursive solution, recursively it will flip leftmost subtree first which is rooted at 2. So, after flipping subtree rooted at 2, the input tree will have the following intermediate state:
 *
 *
 *
 * Now, following recursive properties, current root will be at node 1. So, if we flip the current root (1), it’s left child (2) and right child (3), it will looks like:
 *
 *
 *
 * As node 2 is right child of node 4, the tree will look like:
 *
 *
 *
 * And that’s the expected tree after flipping it upside down.
 *
 *
 *
 * Time complexity:
 *
 * O(N) in both cases, as we are traversing all the nodes once.
 *
 *
 *
 * Auxiliary space:
 *
 * In optimal solution: O(1)
 *
 * In other solution: O(N) because of the stack memory used by recursion.
 *
 *
 *
 * Space complexity:
 *
 * Including input, O(N) in both cases.
 */

import java.io.*;
import java.util.*;

public class UpsideDown {

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

   static class BinaryTree{
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

    public class Counter{
      int counter;
    }

    public class CycleIndicator{
      boolean edgeCreateCycle;
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
          nodes.get(edges.get(i).parentNodeIndex).right_ptr = nodes.get(
              edges.get(i).childNodeIndex
          );
        }
      }

      root = nodes.get(rootIndex);
      return;
    }

    private void considerEdge(String lOrR, TreeNode parent, TreeNode child,
        HashMap<TreeNode, Integer> nodeToId, Counter id, CycleIndicator cycleIndicator
    ){
      if(child != null){
        if(!nodeToId.containsKey(child)){
          nodeToId.put(child, id.counter++);
          nodeValues.add(child.val);
        }else{
          cycleIndicator.edgeCreateCycle = true;
          System.err.println("Cycle detected in the tree. Cycle contains the edge: "
              +nodeToId.get(parent) + " " + nodeToId.get(child) +  " " + lOrR);
        }
        edges.add(new Edge(nodeToId.get(parent), nodeToId.get(child), lOrR));
      }
    }
    private void getNodeValuesAndEdges(TreeNode root, HashMap<TreeNode, Integer> nodeToId, Counter id){
      if(root == null){
        return;
      }

      CycleIndicator leftEdgeCreateCycle = new CycleIndicator();
      CycleIndicator rightEdgeCreateCycle = new CycleIndicator();
      considerEdge("L", root, root.left_ptr, nodeToId, id, leftEdgeCreateCycle);
      considerEdge("R", root, root.right_ptr, nodeToId, id, rightEdgeCreateCycle);

      if(leftEdgeCreateCycle.edgeCreateCycle == false){
        getNodeValuesAndEdges(root.left_ptr, nodeToId, id);
      }
      if(rightEdgeCreateCycle.edgeCreateCycle == false){
        getNodeValuesAndEdges(root.right_ptr, nodeToId, id);
      }
    }

    public void populateRawValuesFromTree(){
      noOfNodes = 0;
      nodeValues.clear();
      rootIndex = -1;
      noOfEdges = 0;
      edges.clear();

      if(root != null){
        Counter id  = new Counter();
        HashMap<TreeNode, Integer> nodeToId = new HashMap();
        rootIndex = 0;
        nodeValues.add(root.val);
        nodeToId.put(root, id.counter++);
        getNodeValuesAndEdges(root, nodeToId, id);
        noOfNodes = nodeValues.size();
        noOfEdges = edges.size();
      }
    }

    public void writeRawValues(){
      System.out.println(noOfNodes);
      for(int i=0;i<noOfNodes;i++){
        if(i>0){
          System.out.print(" ");
        }
        System.out.print(nodeValues.get(i));
      }
      if(noOfNodes > 0){
        System.out.println();
      }

      System.out.println(rootIndex);

      System.out.println(noOfEdges);
      for(int i=0;i<noOfEdges;i++){
        System.out.println(edges.get(i).parentNodeIndex+" " + edges.get(i).childNodeIndex
            +" "+edges.get(i).leftRightFlag);
      }
    }
  }

  public static void printBinaryTree(TreeNode root){
    BinaryTree outputBinaryTree = new BinaryTree();
    outputBinaryTree.root = root;
    outputBinaryTree.populateRawValuesFromTree();
    outputBinaryTree.writeRawValues();
  }

  public static TreeNode readBinaryTree(){
    BinaryTree inputBinaryTree = new BinaryTree();
    inputBinaryTree.readRawValues();
    inputBinaryTree.buildFromRawValues();
    return inputBinaryTree.root;
  }

  public static void main(String[] args){
    try{
      TreeNode root = readBinaryTree();
      TreeNode result = flipUpsideDown(root);
      printBinaryTree(result);
    }catch (Exception e) {
      System.out.println(e.getMessage());
    }
   }

  static TreeNode flipUpsideDown(TreeNode root){
    if(root==null)
      return null;

    if(root.right_ptr == null && root.left_ptr==null)
      return root;

    TreeNode newRoot = flipUpsideDown(root.left_ptr);

    root.left_ptr.left_ptr = root.right_ptr;
    root.left_ptr.right_ptr = root;

    root.left_ptr = null;
    root.right_ptr = null;

    return newRoot;
    }
  }
