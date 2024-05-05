package com.data.structure;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LCABinaryTree {
public Node root;
public Set<Boolean> isSame=new HashSet<>();

public int findLCA(int no1,int no2){
    return findLCA(root,no1,no2).item;
}
    private Node findLCA(Node current,int no1,int no2){
    if(current==null )
        return null;
    if(current.item==no1 || current.item==no2)
        return current;
        Node leftLCA=findLCA(current.left,no1,no2);
        Node  rightLCA=findLCA(current.right,no1,no2);

        if(leftLCA!=null && rightLCA!=null)
            return current;


        return (leftLCA!=null)?leftLCA:rightLCA;

    }
    public boolean inOrder(Node current,Node current1){
    if(current!=null && current1!=null && current.item==current1.item) {
        isSame.add(true);
    }
        if(current!=null && current1!=null && current.item!=current1.item) {
            isSame.add(false);
        }
        if(current!=null && current1==null )
            isSame.add(false);
        if(current==null && current1!=null )
            isSame.add(false);
        if(current!=null && current1!=null) {
              inOrder(current.left,current1.left);
              inOrder(current.right,current1.right);
        }


      return !isSame.contains(false);
    }
    public void preOrder(Node current){
        if(current==null)
            return;
        preOrder(current.left);
            System.out.print("-> "+
                    current.item);

        preOrder(current.right);
    }
    private static class Node {
        public int item;
        public Node right;
        public Node left;
        public Node(int item){
            this.item=item;
        }
    }

    public static void main(String... args) {
        LCABinaryTree tree=new LCABinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        tree.root.left.left.left = new Node(8);
        tree.root.left.left.right = new Node(9);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);

        LCABinaryTree tree1=new LCABinaryTree();
        tree1.root = new Node(1);
        tree1.root.left = new Node(2);
        tree1.root.right = new Node(3);
        tree1.root.left.left = new Node(4);
        tree1.root.left.right = new Node(5);

        tree1.root.left.left.left = new Node(8);
        tree1.root.left.left.right = new Node(9);
        tree1.root.right.left = new Node(6);
        tree1.root.right.right = new Node(77);




        /*System.out.println("LCA(2, 3) = "
                + tree.findLCA(2, 3));*/
        /*System.out.println("LCA(5, 7) = "
                + tree.findLCA(5, 7));*/
       /* System.out.println("LCA(4, 6) = "
                + tree.findLCA(4, 6));
        System.out.println("LCA(3, 4) = "
                + tree.findLCA(3, 4));
       System.out.println("LCA(2, 4) = "
                + tree.findLCA(2, 4));*/
        /*tree.preOrder(tree.root);
        System.out.println("********");*/
       System.out.println(tree.inOrder(tree.root,tree1.root));

    }
}
