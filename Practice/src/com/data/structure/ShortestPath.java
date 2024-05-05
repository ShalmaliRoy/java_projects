package com.data.structure;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPath {

    public static void main(String ...args){
        char[][] path={{'0','*','0','S'},{'*','0','*','*'},{'0','*','*','*'},{'D','*','*','*'}};

        boolean[][] visited=new boolean[path.length][path.length];
        System.out.println(shortestPath(0,3,visited,path));

    }

    private static int shortestPath(int row,int col,boolean[][] visited,char[][] path){
        int distance=0;
        Queue<Point> queue=new LinkedList();
        queue.add(new Point(row,col,0));
        visited[row][col]=true;
        while (!queue.isEmpty()){
            Point p=queue.remove();
            System.out.println("point"+path[p.row][p.col]+"rows--"+p.row+"col--"+p.col);
            if(path[p.row][p.col]=='D')
                return p.distance;
            if(isPathValid(p.row-1,p.col,path,visited)) {
                visited[p.row - 1][p.col] = true;
                queue.add(new Point(p.row-1,p.col,p.distance+1));
            }
            if(isPathValid(p.row,p.col+1,path,visited)) {
                visited[p.row][p.col + 1] = true;
                queue.add(new Point(p.row,p.col+1,p.distance+1));

            }
            if(isPathValid(p.row+1,p.col,path,visited)) {
                visited[p.row + 1][p.col] = true;
                queue.add(new Point(p.row+1,p.col,p.distance+1));

            }
            if(isPathValid(p.row,p.col-1,path,visited)) {
                visited[p.row][p.col - 1] = true;
                queue.add(new Point(p.row,p.col-1,p.distance+1));

            }
         }
        return -1;
    }

    public static boolean isPathValid(int row,int col,char[][] path,boolean[][] visited){
        if(row< path.length && row>=0 && col < path[0].length && col>=0){
            if(path[row][col]!='0' && !visited[row][col])
                return true;
        }
        return false;
    }
    static class Point{
        int row;
        int col;
        int distance;

        public Point(int row,int col,int distance){
            this.row=row;
            this.col=col;
            this.distance=distance;
        }


    }
}
