/*
Write a function to traverse a Binary tree PostOrder, without using recursion. As you traverse, please print contents of the nodes.

(Bonus: Spend 1 minute more and also do it with recursion)


Note: If your output and expected output looks similar, but still you are getting wrong answer, then check trailing spaces. In order to pass, your output must match expected output exactly.


Solution: https://www.youtube.com/watch?v=hv-mJUs5mvU
 */

import java.util.Stack;
import java.util.ArrayList;
import java.util.List;

public class IterativePostOrderBinaryTree {

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

    private static void iterativePostOrderTraversal(Node root) {
        if (root==null)
            return;
        Stack<Node> st = new Stack<>();
        Stack<Node> out = new Stack<>();
        List<Integer> data = new ArrayList<>();
        st.push(root);

        while(!st.empty()){
            Node curr = st.pop();
            out.push(curr);
            if(curr.left != null)
                st.push(curr.left);
            if(curr.right !=null)
                st.push(curr.right);
        }
        while(!out.empty()){
            Node poppedNode = out.pop();
            data.add(poppedNode.val);
        }

        for(int i = 0; i<data.size(); i++){
            if (i==data.size()-1)
                System.out.print(data.get(i));
            else
                System.out.print(data.get(i) + " ");
        }
    }

    //Using one stack times out
//    static void postorderTraversal(TreeNode root){
//        if(root==null)
//            return;
//        Stack<TreeNode> s = new Stack<>();
//        s.push(root);
//        List<Integer> data = new ArrayList<>();
//
//        while(!s.isEmpty()){
//            TreeNode top = s.peek();
//            if(top.left_ptr == null && top.right_ptr == null){
//                TreeNode current = s.pop();
//                data.add(current.val);
//            }
//            else{
//                if(top.right_ptr != null){
//                    s.push(top.right_ptr);
//                }
//                if(top.left_ptr != null){
//                    s.push(top.left_ptr);
//                }
//            }
//
//        }
//
//        int size = data.size();
//        for(int i = 0; i<size; i++){
//            if (i==size-1)
//                System.out.print(data.get(i));
//            else
//                System.out.print(data.get(i) + " ");
//        }
//    }

    private static Node createBinaryTree() {
        IterativePostOrderBinaryTree bt = new IterativePostOrderBinaryTree();

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
        printInorder(root);
        System.out.println("\n ------------------------------");
        iterativePostOrderTraversal(root);
    }
}



