/*
Given a binary tree, we need to count the number of unival subtrees (all nodes that have the same value).


e.g. Given the following tree, it has 6 unival subtrees.

Solution: https://crazycoderzz.wordpress.com/count-the-number-of-unival-subtrees-in-a-binary-tree/
 */

public class UnivalTree {

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
            if(root == null) return;
            printInorder(root.left);
            System.out.print(root.val+" ");
            printInorder(root.right);
        }

        private static Node createBinaryTree() {
            UnivalTree bt = new UnivalTree();

            Node root = bt.addNodeToTree(6);
            bt.insertNode(root,4);
            bt.insertNode(root,8);
            bt.insertNode(root,3);
            bt.insertNode(root,5);
            bt.insertNode(root,7);
            bt.insertNode(root,9);

            return root;
        }


    //This is similar to postorder behavior. Time complexity is O(n) by this approach.
    //because we end up visitng each node to check if each node is a single sub tree.
    public static int findSingleValueTrees(Node n) {
        int[] count = {0};
        findSingleValueTrees(n,count);
        return count[0];

    }

    private static boolean findSingleValueTrees(Node node, int[] count) {
        //base case
        if (node==null)
            return true;

        boolean isLeftSubTreeUnival = findSingleValueTrees(node.left,count);
        boolean isRightSubTreeUnival = findSingleValueTrees(node.right,count);

        if (!isLeftSubTreeUnival || !isRightSubTreeUnival)
            return false;

        if(node.left != null && node.val != node.left.val)
            return false;

        if(node.right != null && node.val != node.right.val)
            return false;

        count[0]++;
        return true;
    }

        public static void main(String[] args) {
            Node root = createBinaryTree();
            int numberOfUnivalTrees = findSingleValueTrees(root);
            System.out.println("There are " + numberOfUnivalTrees + " unival trees in the input tree");

        }
}

