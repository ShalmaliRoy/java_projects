package com.data.structure;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    private Node head;


    public void printAllLevels(Node head) {
        boolean[] visited = new boolean[8];
        Queue<Node> queue = new LinkedList();
        queue.add(head);
        int count=0;
        while (!queue.isEmpty()) {
            Node node = queue.remove();
            if(node!=null)
             System.out.print(node.item);
            if (node!=null && isPathNotTraversed( node.left,visited,count)) {
                queue.add(node.left);
                count++;
            }
            if (node!=null && isPathNotTraversed( node.left,visited,count)) {
                queue.add(node.right);
                count++;

            }
        }
    }

    private boolean isPathNotTraversed(Node node,boolean[] visited,int count) {
        if (node != null && !visited[count])
            return true;
        return false;
    }

    static class Node {
        private int item;
        private Node right;
        private Node left;

        public Node(int item) {
            this.item = item;
        }



}



    public static void main(String ...args){
        BFS bfs=new BFS();
        bfs.head=new Node(1);
        bfs.head.right=new Node(3);
        bfs.head.left=new Node(2);
        bfs.head.right.left=new Node(6);
        bfs.head.right.right=new Node(7);
        bfs.head.left.left=new Node(4);
        bfs.head.left.right=new Node(5);
        bfs.head.left.right.left=new Node(8);
        bfs.printAllLevels(bfs.head);





    }
}
