package com.data.structure;

import java.util.*;

public class LCATree {
    Node root;

    public int findLCA(int no1,int no2){
        Queue<Node> queue=new ArrayDeque<>();
        queue.add(root);
        Node p=null;
        Node q=null;
        Map<Node,Node> hirarchyMap=new HashMap<>();
        hirarchyMap.put(root,null);
        while (!queue.isEmpty()){
            Node head=queue.poll();
            if(head.item==no1)
                p=head;
            if(head.item==no2)
                q=head;
            if(head.left!=null){
                hirarchyMap.put(head.left,head);
                queue.add(head.left);
            }
            if(head.right!=null){
                hirarchyMap.put(head.right,head);
                queue.add(head.right);
            }
        }
        return findLCA(hirarchyMap,p,q).item;
    }


    public int findDistanceBetweenNodes(int no1,int no2){
        Queue<Node> queue=new ArrayDeque<>();
        root.distance=0;
        queue.add(root);

        Node p=null;
        Node q=null;
        Map<Node,Node> hirarchyMap=new LinkedHashMap<>();
        hirarchyMap.put(root,null);
        while (!queue.isEmpty()){
            Node head=queue.poll();
            head.distance+=1;
            if(head.item==no1)
                p=head;
            if(head.item==no2)
                q=head;
            if(head.left!=null){
                hirarchyMap.put(head.left,head);
                head.left.distance+=head.distance;
                queue.add(head.left);
            }
            if(head.right!=null){
                hirarchyMap.put(head.right,head);
                head.right.distance+=head.distance;

                queue.add(head.right);
            }
        }
        Node n1=   hirarchyMap.get(p);
        Node n2= hirarchyMap.get(q);
        int totalDistance=0;

        if(n1!=null && n1==n2)
            return 2;
        else if(n1==q)
            return 1;
        else if(n2==p)
            return 1;
        else if(n2==null)
            return p.distance-1;
        else if(n1==null)
            return q.distance-1;
        else{
           totalDistance=p.distance+q.distance-2;
        }

       return totalDistance;

    }

    private Node findLCA(Map<Node,Node> hirarchyMap,Node p,Node q){
        Node commonAncestor=null;
        Node n1=   hirarchyMap.get(p);
     Node n2= hirarchyMap.get(q);
     if(n1!=null && n1==n2)
         return n1;
     else if(n1==q)
         return q;
     else if(n2==p)
         return p;
     else if(n2==null)
         return q;
     else if(n1==null)
         return p;
     else{
         while(true){
             Node root1=hirarchyMap.get(n1);
             Node root2=hirarchyMap.get(n2);
             if(root1==root2) {
                 commonAncestor = root;
                 break;
             }
             n1=root1;
             n2=root2;
         }
         return commonAncestor;
     }
    }

    private   class Node {
        public int item;
        public Node right;
        public Node left;
        public transient int distance;
        public Node(int item){
            this.item=item;
        }



    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LCATree lcaTree = (LCATree) o;
        return root.equals(lcaTree.root);
    }

    @Override
    public int hashCode() {
        return Objects.hash(root);
    }

    public static void main(String ...args){
        LCATree tree=new LCATree();
        tree.root=tree.new Node(1);
        tree.root.left = tree.new Node(2);
        tree.root.right = tree.new Node(3);
        tree.root.left.left = tree.new Node(4);
        tree.root.left.right = tree.new Node(5);

        tree.root.left.left.left = tree.new Node(8);
        tree.root.left.left.right = tree.new Node(9);
        tree.root.right.left = tree.new Node(6);
        tree.root.right.right = tree.new Node(7);



      /* System.out.println("LCA(2, 3) = "
                + tree.findLCA(2, 3));
        System.out.println("LCA(5, 7) = "
                + tree.findLCA(5, 7));
        System.out.println("LCA(4, 6) = "
                + tree.findLCA(4, 6));
        System.out.println("LCA(3, 4) = "
                + tree.findLCA(3, 4));
       System.out.println("LCA(2, 4) = "
                + tree.findLCA(2, 4));*/

     /*  System.out.println("Distance(8, 5) = "
                + tree.findDistanceBetweenNodes(8, 5));*/
        System.out.println("Distance(3, 6) = "
                + tree.findDistanceBetweenNodes(3, 6));
        /*System.out.println("Distance(3, 4) = "
                + tree.findDistanceBetweenNodes(3, 4));*/
        /*System.out.println("Distance(2, 4) = "
                + tree.findDistanceBetweenNodes(2, 4));
        System.out.println("Distance(2, 3) = "
                + tree.findDistanceBetweenNodes(2, 3));*/
    }
}
