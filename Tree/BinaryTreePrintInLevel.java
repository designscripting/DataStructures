/*

Print the nodes in a level
            2
           /  \
          7    5
         / \     \
        2   6     9
           / \   /
          5  11 4
 Traverses from top to bottom, when level == 1, print node.data
 Here recursive acts like a while loop
 
 */
class Node{
    int data;
    Node left;
    Node right;
}

public class BinaryTree {

    public Node createNode(int data){
        Node a = new Node();
        a.data = data;
        a.left = null;
        a.right = null;
        return a;
    }

    public void printItemsinLevel(Node root, int level){
        if(root == null)
            return;
        if(level == 1)
            System.out.printf(root.data+" ");
        printItemsinLevel(root.left, level-1);
        printItemsinLevel(root.right, level-1);
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

        bt.printItemsinLevel(root,4);
    }

}

// Outputs
// 5 11 4
