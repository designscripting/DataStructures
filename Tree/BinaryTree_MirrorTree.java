/*

Mirror a tree

            2
           /  \
          7    5
         / \     \
        2   6     9
           / \   /
          5  11 4

 */

import java.util.LinkedList;
import java.util.Queue;

class Node{
    int data;
    Node left;
    Node right;
    int depth;
}

public class BinaryTree {
    //Print the tree to view mirror tree
    static void printLevelOrder(Node root)
    {
        if (root == null)
            return;

        Queue < Node > q = new LinkedList < Node > ();

        q.add(root);
        while (true)
        {
            int nodeCount = q.size();
            if (nodeCount == 0)
                break;

            while (nodeCount > 0)
            {
                Node node = q.peek();
                System.out.print("(" + node.data + ")");

                q.remove();

                if (node.left != null)
                    q.add(node.left);
                if (node.right != null)
                    q.add(node.right);
                if (node.depth>0)
                    System.out.print(" ");
                if (nodeCount > 1)
                {
                    System.out.print(", ");
                }

                nodeCount--;
            }
            System.out.println();
        }
    }

    public Node createNode(int data){
        Node a = new Node();
        a.data = data;
        a.left = null;
        a.right = null;

        a.depth = 1;
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
        //traverse right first
        printRightView(root.right, level+1);
        printRightView(root.left, level+1);
    }

    public Node mirrorTree(Node node){
        if(node == null) return null;
        Node temp = node.left;
        node.left = node.right;
        node.right = temp;

        mirrorTree(node.left);
        mirrorTree(node.right);

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

        BinaryTree.printLevelOrder(root);
        Node mirrorTree = bt.mirrorTree(root);
        System.out.println();
        BinaryTree.printLevelOrder(mirrorTree);
    }

}

// Ouputs
// (2)
// (7) , (5)
// (2) , (6) , (9)
// (5) , (11) , (4)
//
// (2)
// (5) , (7)
// (9) , (6) , (2)
// (4) , (11) , (5)

