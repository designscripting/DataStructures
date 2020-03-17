/*

Delete a tree:
 - Traverse live post order traversal and delete nodes
Check two trees are identical
 - Check two roots are null then identical
 - Check each node data is identical

            2
           /  \
          7    5
         / \     \
        2   6     9
           / \   /
          5  11 4

 */

class Node{
    int data;
    Node left;
    Node right;
}

public class BinaryTree{

    public Node createNode(int data){

        Node node = new Node();
        node.data = data;
        node.left = null;
        node.right = null;

        return node;

    }

    public boolean checkIFTreeIdentical(Node t1, Node t2){

        if (t1 == null && t2 == null)
            return true;

        if (t1 == null || t2 == null)
            return false;

        return t1.data == t2.data
               && checkIFTreeIdentical(t1.left, t2.left)
               && checkIFTreeIdentical(t1.right , t2.right);

    }

    public Node deleteTree(Node node){
        if (node == null) return null;

        node.left = deleteTree(node.left);
        node.left = deleteTree(node.right);
        System.out.println("Deleting node: "+ node.data);
        node = null;
        return node;
    }

    public static void main(String[] args) {

        BinaryTree bt = new BinaryTree();
        Node root = bt.createNode(2);
             root.left = bt.createNode(7);
             root.right = bt.createNode(5);
             root.left.left = bt.createNode(2);
             root.left.right = bt.createNode(6);
             root.left.right.left = bt.createNode(5);
             root.left.right.right = bt.createNode(11);
             root.right.right = bt.createNode(9);
             root.right.right.left = bt.createNode(4);

        Node root2 = bt.createNode(2);
            root2.left = bt.createNode(7);
            root2.right = bt.createNode(5);
            root2.left.left = bt.createNode(2);
            root2.left.right = bt.createNode(6);
            root2.left.right.left = bt.createNode(5);
            root2.left.right.right = bt.createNode(11);
            root2.right.right = bt.createNode(9);
            root2.right.right.left = bt.createNode(4);

        boolean isIdentical = bt.checkIFTreeIdentical( root, root2 );
        System.out.printf("Identical Tree:"+isIdentical);
        System.out.println();
        bt.deleteTree(root);
    }
}

// Outputs
// Identical Tree:true

// Deleting node: 2
// Deleting node: 5
// Deleting node: 11
// Deleting node: 6
// Deleting node: 7
// Deleting node: 4
// Deleting node: 9
// Deleting node: 5
// Deleting node: 2