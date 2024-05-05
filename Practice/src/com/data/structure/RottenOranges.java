package com.data.structure;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {
    public static void main(String ...args) {
       // int[][] basket = {{2, 1, 1,}, {0, 1, 1}, {1, 0, 1}};
       // int[][] basket = {{2, 1, 1,}, {1, 1, 0}, {0, 1, 1}};
        int[][] basket = {{0,2}};
        boolean[][] visited = new boolean[basket.length][basket[0].length];
        System.out.println(rottingOranges( basket,visited));
    }

    public static int rottingOranges(int[][] basket,boolean[][] visited){
        Orange orange=null;
        int count=0;
        for(int i=0;i< basket.length;i++){
            for(int j=0;j<basket[0].length;j++) {
                if (basket[i][j] == 2 && count==0) {
                    orange = new Orange(i, j, 0);
                    visited[i][j]=true;
                    count++;
                    break;
                }

            }
        }
        Queue<Orange> queue=new LinkedList();

        queue.add(orange);
        Orange orng=null;
        while (!queue.isEmpty()){

             orng=queue.remove();
            if(isOrangeRotting(orng.x-1,orng.y,basket,visited)){
                visited[orng.x-1][orng.y]=true;
                queue.add(new Orange(orng.x-1,orng.y,++orng.time));
            }
            if(isOrangeRotting(orng.x+1,orng.y,basket,visited)){
                visited[orng.x+1][orng.y]=true;
                queue.add(new Orange(orng.x+1,orng.y,++orng.time));
            }
            if(isOrangeRotting(orng.x,orng.y-1,basket,visited)){
                visited[orng.x][orng.y-1]=true;
                queue.add(new Orange(orng.x,orng.y-1,++orng.time));
            }
            if(isOrangeRotting(orng.x,orng.y+1,basket,visited)){
                visited[orng.x][orng.y+1]=true;
                queue.add(new Orange(orng.x,orng.y+1,++orng.time));
            }

        }
        for(int i=0;i< basket.length;i++){
            for(int j=0;j<basket[0].length;j++) {
                if (basket[i][j] == 1 ) {
                   return -1;
                }

            }
        }
        if(basket[orng.x][orng.y]==2 && visited[orng.x][orng.y]){
            return orng.time;
        }
      return -1;
    }
    private static boolean isOrangeRotting(int x,int y,int[][] orange,boolean [][] visited){
        if(x>=0 && x<orange.length && y>=0 && y<orange[0].length){
            if(orange[x][y]==1 && !visited[x][y]) {
                orange[x][y]=2;
                return true;
            }
        }
        return false;
    }

    public static class Orange{
        int x;
        int y;
        int time;
        public Orange(int x,int y,int time){
            this.x=x;
            this.y=y;
            this.time=time;
        }


    }
}
