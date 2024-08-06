import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q_1991 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        Tree tree = new Tree();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            tree.add(st.nextToken(), st.nextToken(), st.nextToken());
        }
        System.out.println(tree.preorder());
        System.out.println(tree.inorder());
        System.out.println(tree.postorder());
    }

    static class Node{
        String data;
        Node left, right;
        Node(String data){
            this.data = data;
        }
    }
    static class Tree{
        Node root;
        private Node target;
        private StringBuilder preorder;
        private StringBuilder inorder;
        private StringBuilder postorder;

        public void add(String data, String left, String right) {
            if(root == null) root = new Node(data);
            search(root, data);
            if(!left.equals(".")) target.left = new Node(left);
            if(!right.equals(".")) target.right = new Node(right);
        }

        private void search(Node node, String data){
            if(data.equals(node.data)) target = node;
            if(node.left != null) search(node.left, data);
            if(node.right != null) search(node.right, data);
        }

        public String preorder() {
            this.preorder = new StringBuilder();
            this.preorder(root);
            return this.preorder.toString();
        }

        private void preorder(Node node) {
            if(node == null) return;
            this.preorder.append(node.data);
            preorder(node.left);
            preorder(node.right);
        }

        public String inorder() {
            this.inorder = new StringBuilder();
            this.inorder(root);
            return this.inorder.toString();
        }

        private void inorder(Node node) {
            if(node == null) return;
            inorder(node.left);
            this.inorder.append(node.data);
            inorder(node.right);
        }

        public String postorder() {
            this.postorder = new StringBuilder();
            this.postorder(root);
            return this.postorder.toString();
        }

        private void postorder(Node node) {
            if(node == null) return;
            postorder(node.left);
            postorder(node.right);
            this.postorder.append(node.data);
        }
    }
}
