public class BSTToSkewedTree {
    Node node;

    public static void main(String[] args) {
        Main tree = new Main();
        tree.node = new Node(50);
        tree.node.left = new Node(30);
        tree.node.right = new Node(60);
        tree.node.left.left = new Node(10);
        tree.node.left.left.right = new Node(20);
        tree.node.right.left = new Node(55);

        BSTToSkewedTree converter = new BSTToSkewedTree();
        Node skewedRoot = converter.convertBSTToSkewedTree(tree.node);

        converter.printSkewedTree(skewedRoot);
    }
}

class Node {
    int val;
    Node left, right;

    Node(int x) {
        val = x;
        left = right = null;
    }
}

class BSTToSkewedTree {
    Node prev, head;

    public Node convertBSTToSkewedTree(Node root) {
        prev = null;
        head = null;
        convertBSTToSkewedTreeHelper(root);
        return head;
    }

    private void convertBSTToSkewedTreeHelper(Node root) {
        if (root == null)
            return;

        convertBSTToSkewedTreeHelper(root.left);

        if (prev == null) {
            head = root;
        } else {
            prev.right = root;
        }

        root.left = null;

        prev = root;

        convertBSTToSkewedTreeHelper(root.right);
    }

    public void printSkewedTree(Node root) {
        Node current = root;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.right;
        }
    }
}
