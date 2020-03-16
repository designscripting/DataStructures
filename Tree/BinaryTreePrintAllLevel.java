/*

Print the nodes in each level
- Implement height of tree
- Implement nodes in a level
- Implement loop for height and print nodes

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

public class BinaryTree {

    public Node createNode(int data){
        Node a = new Node();
        a.data = data;
        a.left = null;
        a.right = null;
        return a;
    }

    public int getHeightOfTree(Node root){
        if(root == null)
            return -1;
        else
            return 1 + Math.max(getHeightOfTree(root.left), getHeightOfTree(root.right));
    }

    public void printItemsinLevel(Node root, int level){
        if(root == null)
            return;
        if(level == 1)
            System.out.printf(root.data+" ");
        printItemsinLevel(root.left, level-1);
        printItemsinLevel(root.right, level-1);
    }

    public void printLeftView(Node root){
        int height = getHeightOfTree(root);
        for(int level=0;level<=height;level++){
            printItemsinLevel(root, level+1);
            System.out.println();
        }
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

        bt.printLeftView(root);
    }

}

// Outputs
// 2
// 7 5
// 2 6 9
// 5 11 4

