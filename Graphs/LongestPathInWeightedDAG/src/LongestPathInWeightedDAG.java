/**
 * Longest Path In Weighted DAG
 *
 *
 *
 * Problem Statement:
 *
 *
 *
 * Given a weighted DAG (directed acyclic graph), where weight of an edge denotes the length of that edge, a node from_node and a node to_node, you have to find longest path from from_node to to_node.
 *
 *
 *
 * Nodes in the graph are numbered from 1 to dag_nodes, where dag_nodes denotes the total number of nodes in the graph.
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
 * There are six arguments.
 *
 *
 *
 * An integer dag_nodes
 * An integer array dag_from
 * An integer array dag_to
 * An integer array dag_weight
 * An integer from_node
 * An integer to_node
 *
 *
 * The first four arguments cumulatively describes the weighted DAG. dag_nodes describes the total number of nodes in the given graph and there is an edge from dag_from[i] node to dag_to[i] node with length dag_weight[i].
 *
 *
 *
 * Output Format:
 *
 *
 *
 * Return an array pathArr, describing longest path from from_node to to_node.
 *
 *
 *
 * There can be multiple longest paths, so you are free to return any of them.
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
 * The first line of input should contain two space separated integers dag_nodes and dag_edges, denoting no. of nodes and no. of edges in input DAG respectively. In next dag_edges lines, ith line should contain three space separated integers dag_from[i], dag_to[i], dag_weight[i], denoting values from node, to node and weight(length) for ith edge.
 *
 * In next two lines, first line should contain an integer from_node and second line should contain to_node.
 *
 *
 *
 * If dag_nodes = 4, dag_edges = 4, dag_from = [1, 1, 1, 3], dag_to = [2, 3, 4, 4], dag_weight =  [2, 2, 4, 3], from_node = 1 and to_node = 4, then input should be:
 *
 *
 *
 * 4 4
 *
 * 1 2 2
 *
 * 1 3 2
 *
 * 1 4 4
 *
 * 3 4 3
 *
 * 1
 *
 * 4
 *
 *
 *
 * Output Format:
 *
 *
 *
 * Let’s denote m as length of pathArr, where pathArr is the array returned by solution function.
 *
 *
 *
 * The first line of output contains a string (without quotes)   “<len> is the length of longest path in weighted DAG.”, where “<len>”would have been replaced with length of longest path described by pathArr.
 *
 * In next line, there will be a string (without quotes) “Actual path is:”.
 *
 * In next m lines, ith line contains an integer pathArr[i], denoting value at index i of pathArr.
 *
 *
 *
 * For input dag_nodes = 4, dag_edges = 4, dag_from = [1, 1, 1, 3], dag_to = [2, 3, 4, 4], dag_weight =  [2, 2, 4, 3], from_node = 1 and to_node = 4, output will be:
 *
 *
 *
 * 5 is the length of longest path in weighted DAG.
 *
 * Actual path is:
 *
 * 1
 *
 * 3
 *
 * 4
 *
 *
 *
 * Constraints:
 *
 * Given graph does not contain multi edges (there will not be more than one edge connecting same pair of vertices).
 * to_node is reachable from from_node.
 * 1 <= dag_nodes <= 450
 * 1 <= dag_from[i], dag_to[i], from_node, to_node <= dag_nodes
 * 1 <= dag_weight[i] <= 2 * 10^9
 * Total number of edges in graph (dag_edges) <=
 * (dag_nodes * (dag_nodes - 1)) / 2
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
 * dag_nodes = 4
 *
 * dag_from = [1 1 1 3]
 *
 * dag_to = [2 3 4 4]
 *
 * dag_weight =  [2 2 4 3]
 *
 * from_node = 1
 *
 * to_node = 4
 *
 *
 *
 * Sample Output:
 *
 *
 *
 * [1 3 4]
 *
 *
 *
 * Explanation:
 *
 *
 *
 * Total there are two paths from node 1 to node 4.
 *
 * 1) 1 -> 4 with length 4.
 *
 * 2) 1 -> 3 -> 4 with length 2 + 3 = 5.
 *
 * So, Longest path from node 1 to node 4 is [1 3 4] with length 5.
 *
 *
 *
 * Notes:
 *
 * Maximum time allowed in interview: 20 Minutes.
 *
 *
 *
 * When from_node = to_node, path contains only one node, so output should be [from_node] containing only one node.
 *
 *
 *
 * It can be helpful to first store edges node wise and then use it.
 *
 * Something like this:
 *
 *
 *
 * vector<vector<pair<int, int>>> node_wise_edges(dag_nodes + 1, vector<pair<int, int>>(0));
 *
 * for (int i = 0; i < dag_edges; i++)
 *
 * {
 *
 *    node_wise_edges[dag_from[i]].push_back({dag_to[i], dag_weight[i]});
 *
 * }
 *
 *
 *
 * Now we have all the outgoing edges from node i in vector node_wise_edges[i]. And it will be easier to use.
 */

/**
 * Editorial by IK
 *
 * If you are getting wrong answer then first thing to check is that you are using appropriate data type to store the values. int will not work, need to use long long int.
 *
 *
 *
 * Given graph is dag. In dag we can divide our nodes in different levels, with "each edge" going from upper level to lower level.
 *
 *
 *
 * So we can start updating maximum length level wise, starting from upper level and then moving to level below it!
 *
 *
 *
 * To divide nodes level wise with each edge going from upper level to lower level, we can use topological sort!
 *
 *
 *
 * For more clear idea have a look at the solution provided by us.
 *
 *
 *
 * Time complexity of the solution is O(number of nodes in dag + number of edges in dag) and that can be re-written as O(number of edges in dag) from given constraints.
 *
 *
 *
 * Auxiliary space used by the solution is O(number of nodes in dag + number of edges in dag) and that can be re-written as O(number of edges in dag) from given constraints.
 *
 *
 *
 * Space complexity of the solution is also O(number of nodes in dag + number of edges in dag) and that can be re-written as O(number of edges in dag) from given constraints.
 *
 *
 *
 * Note that we should not write any of them as O(numberber of nodes in dag) because number of edges in dag can be way larger than number of nodes!
 */
public class LongestPathInWeightedDAG {

}
