package com.data.structure;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class RatInMazeAllPaths {
    public static void main(String... args) {
        int originalMatrix[][] = {{1, 0, 0, 0},
                {1, 1, 0, 1},
                {1, 1, 0, 0},
                {0, 1, 1, 1}};
        boolean[][] visitedNode=new boolean[4][4];
        //visitedNode[0][0]=true;
        List<String>ans=new ArrayList<>();
        traversePath(originalMatrix, 0, 0,new ArrayList<>(),visitedNode,"");
        System.out.println("visitedNode"+visitedNode);
        System.out.println("visitedNode"+ans);


    }


    private static void traversePath(int[][]originalMatrix, int row, int col, List<String> ans,boolean[][] visitedNode,String move) {
        if(row== originalMatrix.length-1 && col == originalMatrix.length-1) {
            ans.add(move);
            System.out.println(ans);
            return ;
        }
        if(col==originalMatrix[0].length) {
            col = 0;
            row++;
        }
        if(row>=0 && row<originalMatrix.length && col>=0 && col< originalMatrix[0].length) {

            if (isPathSafeToTraverse(originalMatrix, row + 1, col, ans, visitedNode)) {
                visitedNode[row][col] = true;
                move += "d";
                traversePath(originalMatrix, row+1, col, ans, visitedNode, move);
                visitedNode[row][col] = false;
            }
            if (isPathSafeToTraverse(originalMatrix, row, col + 1, ans, visitedNode)) {
                visitedNode[row][col] = true;
                move += "r";
                traversePath(originalMatrix, row, col+1, ans, visitedNode, move);
                visitedNode[row][col] = false;
            }
            if (isPathSafeToTraverse(originalMatrix, row, col - 1, ans, visitedNode)) {
                visitedNode[row][col] = true;
                move += "l";
                traversePath(originalMatrix, row, col-1, ans, visitedNode, move);
                visitedNode[row][col] = false;
            }
            if (isPathSafeToTraverse(originalMatrix, row - 1, col, ans, visitedNode)) {
                visitedNode[row][col] = true;
                move += "u";
                traversePath(originalMatrix, row-1, col, ans, visitedNode, move);
                visitedNode[row][col] = false;
            }
        }
    }




    private static boolean isPathSafeToTraverse(int[][]originalMatrix,int row,int col,List<String> ans,boolean[][] visitedNode){
        if(row>=0 && row<originalMatrix.length && col>=0&& col<originalMatrix[0].length){
            if(originalMatrix[row][col]==1 && !visitedNode[row][col])
                return true;
        }
        return false;
    }
    public static String pathDirection(int[][]originalMatrix,int row,int col,String ans){
        System.out.println("row"+row+" "+col);
        if(row< originalMatrix.length && col < originalMatrix.length && originalMatrix[row][col]==1 ) {


            if (row + 1 < originalMatrix.length && originalMatrix[row + 1][col] == 1) {
                ans="D";

                return ans;
            }
            if (col + 1 < originalMatrix.length && originalMatrix[row][col + 1] == 1) {
                ans="R";
                return ans;
            }
        }

        return ans;
    }
    public static String pathDirectionSide(int[][]originalMatrix,int row,int col,String ans){
        System.out.println("row"+row+" "+col);
        if(row< originalMatrix.length && col < originalMatrix.length && originalMatrix[row][col]==1 ) {



            if (col + 1 < originalMatrix.length && originalMatrix[row][col + 1] == 1) {
                ans+= "R";
                return ans;
            }
            if (row + 1 < originalMatrix.length && originalMatrix[row + 1][col] == 1) {
                ans+= "D";

                return ans;
            }
        }

        return ans;
    }
}
