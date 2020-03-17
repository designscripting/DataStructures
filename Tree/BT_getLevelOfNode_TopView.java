/*

Get Level of a Node
 - Traverse left tree & right tree and print level
 - Node left or right null returns 0
Top View
 - Prints from top view, includes new node property: height
 - Height starts with 0 on root node, left increases by -1 right by +1

            2
           /  \
          7    5
         / \     \
        2   6     9
           / \   /
          5  11 4

 */

import java.util.TreeMap;
import java.util.LinkedList;
import java.util.Queue;

class Node{
    int data;
    Node left;
    Node right;
    int height;
}

public class BinaryTree{

    public Node createNode(int data){

        Node node = new Node();
        node.data = data;
        node.left = null;
        node.right = null;

        return node;

    }

    public int getLevel(Node root,int key,int level)
    {
        if(root==null)
            return 0;
        if(root.data==key)
            return level;

        int result=getLevel(root.left,key,level+1) ;
        if(result!=0)
            return result;
        result= getLevel(root.right,key,level+1);

        return result;
    }

    public void getTopView(Node node){
        if(node == null) return;

        TreeMap< Integer, Integer> m = new TreeMap<Integer, Integer>();
        Queue<Node> q = new LinkedList<Node>();
        q.add(node);

        while (!q.isEmpty()){
            Node temp = q.remove();
            int hd = temp.height;
            if(m.get(hd) == null){
                m.put(hd, temp.data);
            }
            if(temp.left != null){
                temp.left.height = hd-1;
                q.add(temp.left);
            }

            if(temp.right != null){
                temp.right.height = hd+1;
                q.add(temp.right);
            }
        }
        System.out.println("Top View: "+m.values());
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


        bt.getLevel(root, 6, 1);
        bt.getTopView(root);
    }
}



// Outputs
// getLevel: 6 data in level 3
// Top View: [2, 7, 2, 5, 9]