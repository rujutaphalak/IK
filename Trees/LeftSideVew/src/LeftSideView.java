public class LeftSideView {

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
        LeftSideView bt = new LeftSideView();

        Node root = bt.addNodeToTree(10);
        bt.insertNode(root, 6);
        bt.insertNode(root, 12);
        bt.insertNode(root, 5);
        bt.insertNode(root, 7);
        bt.insertNode(root, 8);
        bt.insertNode(root, 11);
        bt.insertNode(root, 15);
        bt.insertNode(root, 13);
        bt.insertNode(root, 14);
        bt.insertNode(root, 18);

        return root;
    }

    public static void main(String[] args) {
        Node root = createBinaryTree();
        printInorder(root);
        System.out.println("\n----------------------------");
        printLeftSideViewTree(root);

    }

    public static void printLeftSideViewTree(Node root){
        int[] levelTouched = {-1};
        printLeftSideViewTreeRec(root,0,levelTouched);

    }

    private static void printLeftSideViewTreeRec(Node root, int level,int[] levelTouched){

        if (root == null)
            return;
        if (level > levelTouched[0]) {
            System.out.print(root.val+" ");
            levelTouched[0]++;
        }
        if(root.left != null)
            printLeftSideViewTreeRec(root.left,level+1,levelTouched);
        if(root.right !=null)
            printLeftSideViewTreeRec(root.right,level+1,levelTouched);

    }

}
