/**
 * Merge Two BSTs
 *
 *
 *
 *
 *
 * Problem Statement:
 *
 *
 *
 * Given two BSTs (Binary Search Trees), one with N1 number of nodes and other one with N2 number of nodes.
 *
 *
 *
 * Your task is to merge them such that:
 *
 *    - Resultant tree is height balanced.
 *
 *    - Resultant tree is a BST.
 *
 *    - Resultant tree contains all values from given BST-1.
 *
 *    - Resultant tree contains all values from given BST-2.
 *
 *    - Size of the resultant tree is N1 + N2.
 *
 *    - For any value, no of occurrences in resultant tree = no of occurrences in BST-1 + no of occurrences in BST-2. (If BST-1 contains 3 nodes with value 50 and BST-2 contains 4 nodes with value 50, then resultant tree should contain exactly 7 nodes with value 50.)
 *
 *
 *
 * Any resultant tree, satisfying all the above conditions will be considered as valid answer.
 *
 *
 *
 * Input Format:
 *
 *
 *
 * There are two arguments, first one is the root of the first BST with N1 number of nodes and second one is the root of the second BST with N2 number of nodes.
 *
 *
 *
 * Output Format:
 *
 *
 *
 * Return root of the resultant BST.
 *
 *
 *
 * Constraints:
 *
 *
 *
 * 1 <= N1, N2 <= 100000
 *
 * Node value of the BSTs: 1 <= key1, key2 <= 1000000000
 *
 * You are not allowed to modify the structure of the given BSTs.
 *
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
 * Tree-1:
 *
 *
 *
 *   1
 *
 *    \
 *
 *     2
 *
 *      \
 *
 *       3
 *
 *
 *
 * Tree-2:
 *
 *
 *
 *    7
 *
 *   /  \
 *
 *  6   8
 *
 *
 *
 * Sample Output:
 *
 *
 *
 *
 *
 * (one possible resultant tree)
 *
 *     6
 *
 *    /  \
 *
 *   2   7
 *
 *  /  \   \
 *
 * 1   3   8
 */


/**
 * Editorial section by IK
 * Other_Solution.java:
 *
 *
 *
 *    1) Create one empty self-height balancing BST.
 *
 *    2) Insert values of BST-1 into that self-height balancing BST, using in-order, pre-order or post-order traversal.
 *
 *    3) Insert values of BST-2 into that self-height balancing BST, using in-order, pre-order or post-order traversal.
 *
 *
 *
 *    Time Complexity: O(N * log(N)), where N = N1 + N2.
 *
 * Insertion in self height balanced BST takes O(height) time, there are total N nodes so overall time complexity of the solution is O(N * log(N))
 *
 *
 *
 *    Auxiliary Space Used: O(N1 + N2).
 *
 * Need extra space to build the new balanced BST, which is also O(N1 + N2).
 *
 *
 *
 *    Space Complexity: O(N1 + N2).
 *
 * Input is O(N1 + N2) and auxiliary space used is also O(N1 + N2). Hence, O(N1 + N2) + O(N1 + N2) -> O(N1 + N2).
 *
 *
 *
 * Optimal_Solution.java:
 *
 *
 *
 *    1) Store values of BST-1 in an array, using in-order traversal.
 *
 *    2) Store values of BST-2 in an array, using in-order traversal.
 *
 *    3) Merge both the arrays (as we do in merge sort).
 *
 *    4) Build height balanced BST recursively like this:
 *
 *        i) root = merged_arr[mid]
 *
 *        ii) root.left = build_height_balanced_BST(l, mid - 1)
 *
 *        iii) root.right = build_height_balanced_BST(mid + 1, r)
 *
 *
 *
 *    Time Complexity: O(N1 + N2)
 *
 * Time complexity for the first operation is O(N1).
 *
 * Time complexity for the second operation is O(N2).
 *
 * Time complexity for the third operation is O(N1 + N2), same as merge function in merge sort.
 *
 * Time complexity for the fourth operation is O(N1 + N2), as we are visiting every node ones.
 *
 *
 *
 *    Auxiliary Space Used: O(N1 + N2)
 *
 * Need extra space to store in-order traversal of the both the BSTS, which is O(N1 + N2). Need extra space to build new balanced BST, which is also O(N1 + N2).
 *
 *
 *
 *    Space Complexity: O(N1 + N2)
 *
 * Input is O(N1 + N2) and auxiliary space used is also O(N1 + N2). Hence, O(N1 + N2) + O(N1 + N2) -> O(N1 + N2).
 */


import java.io.*;
import java.util.*;

class Node{

  Node left;
  Node right;
  int key;

  Node(int key) {
    this.left = null;
    this.right = null;
    this.key = key;
  }

}

class Solution {

  static void solve() throws Exception {

    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

    int N1 = Integer.parseInt(bufferedReader.readLine().trim());
    int[] parent1 = new int[N1];
    int[] child1 = new int[N1];
    int[] key1 = new int[N1];

    for(int i = 0; i < N1; i++) {
      parent1[i] = Integer.parseInt(bufferedReader.readLine().trim());
    }
    for(int i = 0; i < N1; i++) {
      child1[i] = Integer.parseInt(bufferedReader.readLine().trim());
    }
    for(int i = 0; i < N1; i++) {
      key1[i] = Integer.parseInt(bufferedReader.readLine().trim());
    }

    int N2 = Integer.parseInt(bufferedReader.readLine().trim());
    int[] parent2 = new int[N2];
    int[] child2 = new int[N2];
    int[] key2 = new int[N2];

    for(int i = 0; i < N2; i++) {
      parent2[i] = Integer.parseInt(bufferedReader.readLine().trim());
    }
    for(int i = 0; i < N2; i++) {
      child2[i] = Integer.parseInt(bufferedReader.readLine().trim());
    }
    for(int i = 0; i < N2; i++) {
      key2[i] = Integer.parseInt(bufferedReader.readLine().trim());
    }


    int[][] tree1 = new int[N1][2];
    int[][] tree2 = new int[N2][2];

    for(int i = 0; i < N1; i++)
      tree1[i][0] = tree1[i][1] = -1;

    for(int i = 0; i < N2; i++)
      tree2[i][0] = tree2[i][1] = -1;

    int r1 = -1;
    for(int i = 0; i < N1; i++) {
      if(parent1[i] == -1)
        r1 = i;
      else{
        if(child1[i] == 0) {
          tree1[parent1[i]][0] = i;
        }
        else if(child1[i] == 1) {
          tree1[parent1[i]][1] = i;
        }
      }
    }

    int r2 = -1;
    for(int i = 0; i < N2; i++) {
      if(parent2[i] == -1)
        r2 = i;
      else{
        if(child2[i] == 0) {
          tree2[parent2[i]][0] = i;
        }
        else if(child2[i] == 1) {
          tree2[parent2[i]][1] = i;
        }
      }
    }

    Node root1 = buildTree(r1, key1, tree1);
    Node root2 = buildTree(r2, key2, tree2);

    Node root = MergeTwoBSTs.mergeTwoBSTs(root1, root2);

    if(isBalanced(root, new Height())) {
      ArrayList<Integer> list = new ArrayList<>();
      inOrderTraversal(root, list);
      for(int ele: list) {
        bufferedWriter.write(String.valueOf(ele));
        bufferedWriter.write("\n");
      }
    }
    else {
      bufferedWriter.write("Returned tree is not height balanced\n");
    }

    bufferedWriter.close();
  }

  public static void main(String[] args) {


    new Thread(null ,new Runnable(){
      public void run()
      {
        try{
          solve();
        } catch(Exception e){
          e.printStackTrace();
        }
      }
    },"1",1<<26).start();


  }

  static class Height {
    int height;
  }

  static boolean isBalanced(Node temp, Height height) {
    if(temp == null)
      return true;

    Height lh = new Height();
    Height rh = new Height();

    boolean l = isBalanced(temp.left, lh);
    boolean r = isBalanced(temp.right, rh);

    height.height = Math.max(lh.height, rh.height) + 1;

    if(Math.abs(lh.height - rh.height) <= 1 && l && r)
      return true;
    return false;
  }

  static void inOrderTraversal(Node temp, ArrayList<Integer> list) {
    if(temp == null)
      return;
    inOrderTraversal(temp.left, list);
    list.add(temp.key);
    inOrderTraversal(temp.right, list);
  }

  static Node buildTree(int idx, int[] key, int[][] tree) {
    Node root = new Node(key[idx]);
    if(tree[idx][0] != -1) {
      root.left = buildTree(tree[idx][0], key, tree);
    }
    if(tree[idx][1] != -1) {
      root.right = buildTree(tree[idx][1], key, tree);
    }
    return root;
  }

}


public class MergeTwoBSTs {

  public static Node mergeTwoBSTs(Node root1, Node root2) {
    // Write your code here
    return null;
  }


}
