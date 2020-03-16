/*

Print left view of a tree
- As a person view from lef of a tree views only the left node's
- level = maxlevel, print node.data and move to next level by maxlevel++;

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

    int maxLevel;
    public void printLeftView(Node root, int level){
        if (root == null)
            return;
        if(level >= maxLevel){
            System.out.printf(" "+root.data);
            maxLevel++;
        }
        printLeftView(root.left, level+1);
        printLeftView(root.right, level+1);
    }

    public void printRightView(Node root, int level){
        if (root == null)
            return;
        if(level >= maxLevel){
            System.out.printf(" "+root.data);
            maxLevel++;
        }

        printRightView(root.right, level+1);
        printRightView(root.left, level+1);
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

        System.out.printf("LeftView: ");
        bt.printLeftView(root, 0);

        bt.maxLevel = 0;
        System.out.println();
        System.out.printf("RightView: ");
        bt.printRightView(root, 0);
    }

}

// Outputs
// LeftView: 2 7 2 5
// RightView: 2 5 9 4

