package com.data.structure;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree {
    public Node head;
    public static int count=0;

    public Node add(int item){
       head=addItem(item,head);
       return head;
    }
    private Node addItem(int item, Node current){
       if(current==null){
           current=new Node(item);
           return current;
       }
       else{
           if(item> current.item){
               current.right=addItem(item,current.right);
           }
           if(item< current.item){
               current.left=addItem(item,current.left);
           }

       }
       return current;
    }
   public void mirrorTree(Node head){
        Node temp,temp1;
        if(head!=null) {
            temp = head.right;
            head.right = head.left;
            head.left = temp;
        }
       if(head!=null) {
           mirrorTree(head.right);
           mirrorTree(head.left);
       }
   }

    public static boolean findPath(Node node,int item) {
        List list= new ArrayList();
        if(node==null){
            return false;
        }
        if(node.item!=item){
            list.remove(node.item);
        }
        if(node!=null ){
            list.add(node.item);
        }
        if(!list.contains(item))
        {
            findPath(node.right,item);
            findPath(node.left,item);
        }
        return true;

    }

    public static void  inOrderSuccessor(Node node,Node p){
        if(node.left!=null)
            inOrderSuccessor(node.left,p);
        if(count==1) {
            System.out.println(node.item);
        }
        if(node.item==p.item) {
            System.out.println(node.item);
            count=1;
            inOrderSuccessor(node.left,p);
        }
        if(node.right!=null)
            inOrderSuccessor(node.right,p);

    }
    public boolean searchTree(int item) {
        boolean found =  searchTree(head,item);
        System.out.println(found);
        return found;
    }

    public boolean searchTree(Node node, int item) {
        if(node != null && item == node.item){
            return true;
        }
        if (node != null && item > node.item) {
             return searchTree(node.right,item);
        }
        if(node != null && item < node.item){
             return searchTree(node.left,item);
        }
        return false;
    }
    static class Node{
        int item;
        Node right;
        Node left;

        public Node(int item){
           this.item=item;
        }
    }

    public static void main(String ...args){
        BinarySearchTree btree=new BinarySearchTree();
        btree.add(20);
        btree.add(25);
        btree.add(23);
        btree.add(30);
        btree.add(28);
        btree.add(10);
        btree.add(18);
        btree.add(5);
        btree.add(18);
        btree.add(4);
        btree.searchTree(18);
       // System.out.println("Its done");
        //btree.mirrorTree(btree.head);
        /*System.out.println("Its done");
        BinarySearchTree btree1=new BinarySearchTree();
        btree1.add(25);
        btree1.add(23);
        btree1.add(30);
        btree1.add(28);
        inOrderSuccessor(btree.head,btree1.head);*/


    }




}
