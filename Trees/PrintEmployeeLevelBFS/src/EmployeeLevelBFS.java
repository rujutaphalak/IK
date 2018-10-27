/*
Given an employee database, print the employee names at a certain level. Here the level is 2.
 */

import java.util.LinkedList;
import java.util.Queue;

public class EmployeeLevelBFS {

    class Node {
        int val;
        Node left;
        Node right;

        public Node(int data) {
            this.val = data;
            this.left = null;
            this.right = null;
        }
    }

    private Node addNodeToTree(int data) {
        return insertNode(null, data);
    }

    private Node insertNode(Node root, int data) {
        if (root == null)
            return new Node(data);

        if (data < root.val)
            root.left = insertNode(root.left, data);
        else if (data > root.val)
            root.right = insertNode(root.right, data);
        else
            return root;

        return root;
    }

    private static void printInorder(Node root) {
        if (root == null) return;
        printInorder(root.left);
        System.out.print(root.val + " ");
        printInorder(root.right);
    }

    private static Node createBinaryTree() {
        EmployeeLevelBFS bt = new EmployeeLevelBFS();

        Node root = bt.addNodeToTree(6);
        bt.insertNode(root, 4);
        bt.insertNode(root, 8);
        bt.insertNode(root, 3);
        bt.insertNode(root, 5);
        bt.insertNode(root, 7);
        bt.insertNode(root, 9);

        return root;
    }

    public static void main(String[] args) {
        Node root = createBinaryTree();
        printInorder(root);
        System.out.println("\n----------------------------");
        employerLevelBFS(root,2);

        employerLevelDFS(root,2);

    }

    //Time complexity is O(level) here, but still worst case is O(n)
    //Space complexity is O(2^level) which essentially means is O(N). Worst case is O(N/2) approximated to O(N) in case of complete tree.
    private static void employerLevelBFS(Node root, int level) {
        if (root == null)
            return;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);

        while (!queue.isEmpty()) {
            if (level == 0)
                break;

            Node employee = queue.remove();
            if (employee == null) {
                level--;
                queue.add(null);
            } else {
                if (employee.left != null)
                    queue.add(employee.left);
                if (employee.right != null)
                    queue.add(employee.right);
            }
        }

        System.out.println("Employee ids at level using BFS are ");
        for (Node n : queue) {
            if (n != null)
                System.out.print(n.val + " ");
        }
    }

    //Time complexity O(N), same as BFS as you still visit all the nodes required to go to the level.
    //Space complexity O(level) as you only store the height of the tree up to the level.
    // But worst case it is still O(N) for skewed tree. Average case is log(N) for a decently balanced tree.
    // In BFS it is O(2^level)
    //NOTE: Call stack has the height

    //NOT WORKING!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    private static void employerLevelDFS(Node root, int level) {
        employerLevelDFSRec(root,level);
    }

    private static void employerLevelDFSRec(Node root, int level) {
        if (root==null)
            return;

        if(level == 0){
            System.out.println(root.val + " ");
            return;
        }

        employerLevelDFSRec(root.left,level--);
        employerLevelDFSRec(root.right,level--);
    }
}
