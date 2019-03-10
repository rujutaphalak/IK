/**
 * Least Common Ancestor (LCA)
 *
 *
 *
 *
 *
 * Problem Statement
 *
 *
 *
 * You are given a binary tree of n nodes, rooted at T. The lowest common ancestor between two nodes n1 and n2 is defined as the lowest node in T that has both n1 and n2 as descendants. (For this problem, we allow a node to be an ancestor/descendant of itself.) You are also given reference of two nodes a & b, You need to find the LCA of both the nodes.
 *
 *
 *
 * From wikipedia the definition of LCA is as follows:
 *
 *
 *
 * The LCA of n1 and n2 in T is the shared ancestor of n1 and n2 that is located farthest from the root. Computation of lowest common ancestors may be useful, for instance, as part of a procedure for determining the distance between pairs of nodes in a tree: the distance from n1 to n2 can be computed as the distance from the root to n1, plus the distance from the root to n2, minus twice the distance from the root to their lowest common ancestor.
 *
 *
 *
 * Input Format:
 *
 *
 *
 * There are three arguments in input, denoting the pointer to the root of the tree T and reference of two nodes a & b for which you need to return the LCA.
 *
 * Structure of tree node is as :
 *
 *
 *
 * class Node {
 *
 *    public:
 *
 *        int data;
 *
 *        Node *left;
 *
 *        Node *right;
 *
 * };
 *
 *
 *
 * Output Format:
 *
 *
 *
 * Return an integer denoting the LCA for the given nodes a and b.
 *
 *
 *
 * Constraints:
 *
 *
 *
 * 1 <= N <= 100000
 *
 * 1 <= Value at a <= n
 *
 * 1 <= Value at b <= n
 *
 * Given the value stored at any node will be between 1 to n and unique.
 *
 *
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
 * Let us assume this is the tree, you are given the pointer to 1(Root), and two nodes 8,9
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 * Sample Output:
 *
 *
 *
 * 5
 *
 *
 *
 * Explanation:
 *
 *
 *
 * Parent of 8 = 5
 *
 * Parent of 9 = 5
 *
 *
 * Clearly we can see that the LCA(8,9) = 5
 *
 *
 *
 * More examples,
 *
 * LCA(2,5) = 2
 *
 * LCA(2,3) = 1
 */

/**
 * Editorial by IK uses Range Minimum Query approach - Segment Tree.
 * Problem: Lowest common ancestor(LCA)
 *
 *
 *
 * Problem Difficulty: Medium
 *
 *
 *
 * Problem Description: Given a binary tree of N nodes we need to find the LCA, the lowest common ancestor of both the nodes.
 *
 *
 *
 * Let’s have short example of LCA:
 *
 * The LCA of u and v is the ancestor of u and v such that it is located farthest from the root
 *
 *
 *
 *
 *
 *
 *
 *
 *
 * Brute Force Approach:
 *
 *
 *
 * Let’s say we need to find the LCA(u,v)
 *
 * In the brute force approach we will exactly follow according to the definition of the LCA.
 *
 * For every node we will check if this node is a common ancestor of both the nodes u and v.
 *
 * If so we will try to find the node which has maximum level. That's it!!
 *
 *
 *
 * Implementation Details for Brute force(brute_force_solution.cpp):
 *
 *
 *
 * First DFS (depth first search) which will precompute some data for us. In this dfs we will store level as well as parent for all the nodes.
 *
 *
 *
 * How to check if node A is an ancestor of node B, provided we do have the parent and level of each node.
 *
 * Simple right !!
 *
 * We will just start with node B, try to go up until we get A, if till end of the loop we get A then return true else return false.
 *
 *
 *
 * Now a final dfs calculating answer,
 *
 * Here in the second Dfs we will check for each node, if this node is an ancestor of both the nodes u and v. If so is the condition then we will try to find node with a maximum level( according to the definition of LCA ).
 *
 *
 *
 * Code snippet
 *
 *
 *
 * void traverse_and_update(
 *
 *    Node * head , int a, int b , int * level, int * par,int &answer_node, int &level_of_answer
 *
 * ){
 *
 * if( head == NULL )
 *
 * return ;
 *
 *    int current_node = head->data ;
 *
 *    if( isAncestor( current_node , a , par ) && isAncestor(current_node , b, par) )
 *
 * {
 *
 * if( level[ current_node ] > level_of_answer )
 *
 * {
 *
 * answer_node = current_node ;
 *
 * level_of_answer = level[ current_node ] ;
 *
 * }
 *
 * }
 *
 * // recursively traverse and update the current global answer !!
 *
 * traverse_and_update(head->left,a,b,level,par,answer_node,level_of_answer) ;
 *
 *      traverse_and_update(head->right,a,b,level,par,answer_node,level_of_answer);
 *
 * }
 *
 * int lca( Node * head , Node * a, Node  * b )
 *
 * {
 *
 *    int par[100020],level[100020]={0},i;
 *
 *    dfs(head , 0 , level, par ) ;
 *
 *    // store parents & level .. preprocessing part!!
 *
 *    // according to the definition of LCA, it should be a ancestor with       maximum level
 *
 *    // we will check both the conditions for every node, and update the answer accordingly!!
 *
 *    // calculate answer again a new dfs
 *
 *    int aa = a -> data ;
 *
 *    int bb = b -> data ;
 *
 *    int answer_node, level_of_answer=0;
 *
 *    traverse_and_update( head ,aa ,bb, level,par,answer_node,level_of_answer);
 *
 *    return answer_node;
 *
 * }
 *
 *
 *
 *
 *
 * Let’s discuss the time and the memory complexity,
 *
 *
 *
 * Time Complexity: O(N*N) Worst case
 *
 * For each node in the DFS we are using isAncestor function which itself is of O(N)
 *
 *
 *
 * Space Complexity: O(N)
 *
 * Just taken the Memory and the parent array.
 *
 *
 *
 * Aux Space Complexity: 0(N)
 *
 * Level and the parent array
 *
 *
 *
 * But in our problem N <= 100000, so we need to optimize our solution.
 *
 *
 *
 * We just need to tweak this code a bit, can’t we preprocess the paths from root to u and again from root to v
 *
 *
 *
 * We can clearly observe that if we write down paths from root to both of the nodes and start matching above, we can get that till the lca both the paths will be same, so we need to find the last matching  node in the paths from root.
 *
 * How can we extract path from root to a node X ?? (optimal_solution.cpp)
 *
 * Just use this parent array, go above till we reach the root node.
 *
 *
 *
 *
 *
 *
 *
 * vector< int >get_path( int *par ,int node )
 *
 * {
 *
 *    vector< int >path ;
 *
 *    while( par[node]!=-1 )
 *
 *    {
 *
 *        path.push_back( node ) ;
 *
 *        node = par[node];
 *
 *    }
 *
 *    path.push_back(node) ;
 *
 *    return path ;
 *
 * }
 *
 *
 *
 *
 *
 * Now after getting the Path, we just have to match the two path vectors and just return the last match!! And we are done!!
 *
 *
 *
 * Time Complexity: O(N)	just to calculate the path vectors
 *
 * Memory Complexity: O(N)  taken a parent array of size N
 *
 * Aux Space Complexity: 0(N)  the parent array
 *
 *
 *
 * So we can see that this solution is efficient enough to pass in the given limits.
 *
 *
 *
 *
 *
 * Approach 2 ( in one dfs )
 *
 *
 *
 * Reduction of LCA to Range minimum query
 *
 *
 *
 * The idea is to traverse the tree starting from root by an Euler tour (traversal without lifting pencil), which is a DFS-type traversal with preorder traversal characteristics.
 *
 *
 *
 * Euler tour is defined as a way of traversing tree such that each vertex is added to the tour when we visit it (either moving down from parent vertex or returning from child vertex). We start from root and reach back to root after visiting all vertices.
 *
 * It requires exactly 2*N-1 vertices to store Euler tour .
 *
 * For each  node we maintained the in and the out timing.
 *
 *
 *
 * Point to notice ::
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 * So we can observe that all the nodes, which comes inside the subtree of node X, in the euler tour it comes within the starting and the ending time.
 *
 *
 *
 * Starting time: Index of when it came for first time
 *
 * Ending time: Index when it came for the second time
 *
 *
 *
 * Observation: The LCA of nodes 4 and 9 is node 2, which happens to be the node closest to the root amongst all those encountered between the visits of 4 and 9 during a DFS of T. This observation is the key to the reduction. Let’s rephrase: Our node is the node at the smallest level and the only node at that level amongst all the nodes that occur between consecutive occurrences (any) of u and v in the Euler tour of T.
 *
 * We require three arrays for implementation:
 *
 * Nodes visited in order of Euler tour of T
 * Level of each node visited in Euler tour of T
 * Index of the first occurrence of a node in Euler tour of T (since any occurrence would be good, let’s track the first one)
 *
 *
 * lca2
 *
 *
 *
 * Do a Euler tour on the tree, and fill the euler, level and first occurrence arrays.
 * Using the first occurrence array, get the indices corresponding to the two nodes which will be the corners of the range in the level array that is fed to the RMQ algorithm for the minimum value.
 * Once the algorithm return the index of the minimum level in the range, we use it to determine the LCA using Euler tour array.
 *
 * Implementation
 *
 *
 *
 * // DFS function for precomputation
 *
 *
 *
 * void dfs(Node * head, int current_level, int * lev, int * first_occurence, int * euler, int & counter)
 *
 * {
 *
 *    if( head == NULL )
 *
 *        return ;
 *
 *    int current_node = head->data ;
 *
 *    euler[counter] = current_node ;     // making up the euler-tour array !!
 *
 *    lev[ current_node ] = current_level ; // storing level as well
 *
 *    if( first_occurence[ current_node ] == -1 )
 *
 *        first_occurence[ current_node ] = counter ;
 *
 *    counter++;
 *
 *    dfs( head->left, current_level+1, lev, first_occurence, euler, counter);
 *
 *    if( head->left != NULL )
 *
 *        euler[ counter++ ] = current_node ;
 *
 *    dfs( head->right, current_level+1, lev, first_occurence, euler, counter) ;
 *
 *    if( head->right != NULL )
 *
 *        euler[ counter++ ] = current_node ;
 *
 *
 *
 * }
 *
 *
 *
 * Using this function we have calculated the level, the euler tour and the first occurence of all the nodes. Once we are done with this pre-computation, this problem has been converted to RMQ.
 *
 *
 *
 * So we just need to iterate in order to find the node which has the minimum level. That node
 *
 * will be the LCA.
 *
 *
 *
 * The best part about the solution with this approach is
 *
 *    1. Only 1 dfs is required here
 *
 *    2. If there will be multiple queries for LCA then after pre-computation we just have to find the
 *
 *       Range minimum query. For which lots of data structures are already there.
 *
 *       We can find the RMQ in log(N) using a very known data-structure called segment tree.
 *
 *
 *
 * Let’s discuss the time and the memory complexity,
 *
 *
 * Time Complexity: O(N)  DFS + Range minimum
 *
 * Space Complexity: O(N)
 *
 * Aux Space Complexity: 0(N)
 *
 * Euler, Level and the First occurrence array
 *
 *
 * Code for Eulers methid in cpp
 *
 * #define inf 10002020
 * void dfs(Node * head, int current_level, int * lev, int * first_occurence, int * euler, int & counter)
 * {
 *     if( head == NULL )
 *         return ;
 *     int current_node = head->data ;
 *     euler[counter] = current_node ;     // making up the euler-tour array !!
 *     lev[ current_node ] = current_level ; // storing level as well
 *     if( first_occurence[ current_node ] == -1 )    // storing first occurence too !!
 *         first_occurence[ current_node ] = counter ;
 *     counter++;
 *     dfs( head->left, current_level+1, lev, first_occurence, euler, counter) ;
 *     if( head->left != NULL )
 *         euler[ counter++ ] = current_node ;
 *     dfs( head->right, current_level+1, lev, first_occurence, euler, counter) ;
 *     if( head->right != NULL )
 *         euler[ counter++ ] = current_node ;
 *
 * }
 *
 * int lca( Node * head , Node * a, Node * b )
 * {
 *     int euler[200020] ,lev[100020] , first_occurence[100020];
 *     // size of euler array will be twice in size !!
 *     memset( first_occurence,-1,sizeof first_occurence );    // initialize all the first occurence with -1
 *     int counter = 1 ;  // counter for creating euler tour array
 *     dfs( head , 1 ,lev, first_occurence, euler,counter);  // PRECOMPUTES euler tour, level, and the first occurences
 *     int aa = a->data ;
 *     int bb = b->data ;
 *     int first_occurence_aa = first_occurence[aa] ;
 *     int first_occurence_bb = first_occurence[bb] ;
 *     int mini = min(first_occurence_aa,first_occurence_bb),
 *                                              maxi = max(first_occurence_bb,first_occurence_aa) ;
 *     int var = inf,answer;
 *     for( int i = mini ; i<= maxi ;i++ )   // just a range minimum query
 *     {
 *         if( var > lev[ euler[i] ] )
 *         {
 *             answer = euler[i] ;
 *             var = lev[ euler[i] ] ;
 *         }
 *     }
 *     return answer;
 *     // we can also use some data-structure to calculate the range minimum more efficiently !!
 * }
 */

import java.util.*;
import java.io.*;

public class LeastCommonAncestor {

  static class Node
  {
    Node left;
    Node right;
    int data;

    Node(int data)
    {
      this.data = data;
      left = null;
      right = null;
    }
  }

  public static void preorder(Node root) {
    if (root == null) { return; }
    System.out.print(root.data + " ");
    preorder(root.left);
    preorder(root.right);
  }

  public static void parse_input(int siz , int from[] , int to[], Node[] arr_stub )
  {
    for(int i=1;i<siz;i++)
    {
      int x = from[i];
      int y = to[i] ;
      if( (arr_stub[x].left) == null )
        arr_stub[x].left = arr_stub[y] ;
      else
        arr_stub[x].right = arr_stub[y] ;
    }
  }
  public static void main(String[] args) throws IOException{
    Scanner scan = new Scanner(System.in);
    Node[] arr_stub = new Node[100020];
    int t = 1;
    Node root = null;
    for(int i = 1 ; i <= 100000;i++)
      arr_stub[i] = new Node(i) ;
    int[] from = new int[100020] ;
    int[] to = new int[100020] ;
    while(t-- > 0)
    {
      int n = scan.nextInt();
      int a = scan.nextInt();
      int b = scan.nextInt();
      for(int i=1;i<n;i++)
      {
        from[i] = scan.nextInt();
        to[i] = scan.nextInt() ;
      }
      parse_input( n ,from , to , arr_stub);
      LeastCommonAncestor temporary = new LeastCommonAncestor();
      int answer = temporary.lca( arr_stub[1] , arr_stub[a] , arr_stub[b] ) ;
      //preorder(arr_stub[1]);
      // we passed the head pointer basically which is arr_stub[1]
      System.out.println(answer) ;
    }
    scan.close();
  }

  //This is using simple recursion - recursion is beautiful!!
  int lca(Node head, Node a, Node b)
  {
    if(head == null)
      return -1;
    if(head.data == a.data || head.data == b.data)
      return head.data;
    int leftVal = lca(head.left, a, b);
    int rightVal = lca(head.right, a, b);

    if(leftVal != -1 && rightVal != -1)
      return head.data;

    return leftVal ==-1?rightVal:leftVal;
  }
}
