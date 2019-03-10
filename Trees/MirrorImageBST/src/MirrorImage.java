/**
 * Mirror Image Of Binary Tree
 *
 *
 *
 *
 *
 * Problem Statement:
 *
 *
 *
 * You are given root node of Binary Tree T. You need to modify binary tree represented by given root node such that it will represent mirror image tree of given Binary Tree T.
 *
 *
 *
 * Input Format:
 *
 *
 *
 * Only argument for function, Node named root which is root node of a binary tree T.
 *
 *
 *
 * Output Format:
 *
 *
 *
 * Need to modify binary tree represented by given root node such that it will represent mirror image tree of that binary tree. Code written by us will have output:
 *
 * If modified root node is representing mirror image of given binary tree T then binary tree represented by modified root  node will be printed.
 * If modified root node is not representing mirror image of given binary tree T then “Not a mirror image” along with binary tree represented by modified root node will be printed.
 * Here, printing binary tree represented by tree node means printing lines equal to number of vertices. Each line will have “v l r” means for vertex v, left child is vertex l and right child is vertex r.
 *
 * If l or r is -1 means that child is null.
 *
 *
 *
 * Constraints:
 *
 *
 *
 * 1 <= n <= 100000 where n is number of nodes in binary tree.
 *
 * Indexing of vertices starting from 0.
 *
 * For each node of tree, node of tree is a vertex of binary tree and value data of that can be 0 <= data <= n-1 and data will be unique for each node.
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
 * 0
 *
 *    / \
 *
 * 1    2
 *
 * / \    / \
 *
 * 3  4 5 6
 *
 *
 *
 * Sample Output:
 *
 *
 *
 * 0
 *
 *      / \
 *
 *    2	   1
 *
 *   / \    / \
 *
 * 6   5 4 3
 *
 *
 *
 * Explanation:
 *
 *
 *
 * As we can easily visualise that input binary tree and output binary tree are mirror images of each other. So, If A and B are two binary tree which are mirror images of each other then taking mirror image of A would generate B and vice versa.
 */

/**
 * Editorial by IK
 *
 * We have provided solutions which contain necessary comments to understand the approach used:
 *
 *
 *
 * 1) optimal_solution1.java
 *
 *
 *
 * Time Complexity:
 *
 *
 *
 * O(n) where n is number of nodes of tree.
 *
 *
 *
 * The approach of solution can be categorized as recursive one. The main task is to swap left and child for every node of the tree. So. We are calling function recursively and making sure that leaf nodes are handled first then their parent and then it goes upto root node.
 *
 *
 *
 * In solution, mirror_image_util is our recursive function. We are calling recursive function to find solution for left child of current node and right child of current node. We are storing returned node by solution for left child as current node's right child and similarly, returned node by solution for right child as current node's left child.
 *
 *
 *
 * Auxiliary Space Used:
 *
 *
 *
 * O(n) where n is number of nodes of tree.
 *
 * As here we are considering size of stack for function calls.
 *
 *
 *
 * Space Complexity:
 *
 *
 *
 * O(n).
 *
 * Input is O(n) because we are storing n nodes relationships and each relationship occupies O(1) space and auxiliary space used is O(n). So, O(n) + O(n) -> O(n).
 *
 *
 *
 *
 *
 * 2) optimal_solution2.java
 *
 *
 *
 * Time Complexity:
 *
 *
 *
 * O(n) where n is number of nodes.
 *
 *
 *
 * The approach of solution is iterative one. We are traversing the binary tree and while traversing the tree, we are swapping left and right child of every node.
 *
 *
 *
 * In solution, we are BFS traversal (iterative BFS using queue). We are pushing root node in queue. Getting current node from pop operation on queue. Swapping left and right child of current node and then pushing left child and right child of current node in queue. Doing this till queue is not empty.
 *
 *
 *
 *
 *
 * Auxiliary Space Used:
 *
 *
 *
 * O(n) where n is number of nodes of tree.
 *
 * As here we are using queue for storing nodes to do BFS traversal over tree. In worst case scenario, size of queue can be n i.e. equal to number of nodes of tree.
 *
 *
 *
 * Space Complexity:
 *
 *
 *
 * O(n) where n is number of nodes of tree.
 *
 * Input is O(n) because we are storing n nodes relationships and each relationship occupies O(1) space and auxiliary space used is O(n). So, O(n) + O(n) -> O(n).
 */
public class MirrorImage {

}
