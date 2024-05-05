package com.data.structure;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class DistanceBetweenNodes {
    ArrayList<ArrayList<Integer>> graphs=new ArrayList<ArrayList<Integer>>();
    boolean[] visited=new boolean[8];

    public DistanceBetweenNodes(int v){
        for(int i=0;i< v;i++){
            graphs.add(new ArrayList<>());
        }
    }

    public void addEdge(int vertex,int neighbour){
      graphs.get(vertex).add(neighbour);

    }

    public void printRoute(int src,int dest,boolean[] visited,ArrayList<ArrayList<Integer>> graphs){
       Queue<Integer> queue=new LinkedList();
       queue.add(src);
       visited[src]=true;
       while(!queue.isEmpty()){
            int element= queue.remove();
          /* for(List<Integer> vertex:integers){

           }*/
       }
    }



    public static void main(String ...args){
     DistanceBetweenNodes distanceBetweenNodes=new DistanceBetweenNodes(8);
        distanceBetweenNodes.addEdge( 0, 1);
        distanceBetweenNodes.addEdge( 0, 3);
        distanceBetweenNodes.addEdge( 1, 2);
        distanceBetweenNodes.addEdge( 3, 4);
        distanceBetweenNodes.addEdge( 3, 7);
        distanceBetweenNodes.addEdge( 4, 5);
        distanceBetweenNodes.addEdge( 4, 6);
        distanceBetweenNodes.addEdge( 4, 7);
        distanceBetweenNodes.addEdge( 5, 6);
        distanceBetweenNodes.addEdge( 6, 7);
    }
}
