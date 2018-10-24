import java.util.ArrayList;
import java.util.List;

public class RootToLeafPath {


    static void printAllPaths(Node root) {
        int[] path = new int[1000];
        printAllPathsRec(root,path,0);
    }

    private static void printAllPathsRec(Node root, int[] path, int pathLen) {

        if(root==null)
            return;

        path[pathLen] = root.val;
        pathLen++;

        if (root.left == null && root.right == null) {
            for(int i=0;i<pathLen;i++){
                if(i==pathLen-1)
                    System.out.print(path[i]+ "\n");
                else
                    System.out.print(path[i] + " ");
            }
        }
        else{
            printAllPathsRec(root.left,path,pathLen);
            printAllPathsRec(root.right,path,pathLen);
        }
    }

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
        RootToLeafPath bt = new RootToLeafPath();

        Node root = bt.addNodeToTree(6);
        bt.insertNode(root,4);
        bt.insertNode(root,8);
        bt.insertNode(root,3);
        bt.insertNode(root,5);
        bt.insertNode(root,7);
        bt.insertNode(root,9);

        return root;
    }

    public static void main(String[] args) {
        Node root = createBinaryTree();
        printAllPaths(root);
    }
}
