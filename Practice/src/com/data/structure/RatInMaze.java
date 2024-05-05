package com.data.structure;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class RatInMaze {

    public static void main(String ...args){
        int[][] originalMatrix={{1,1,0,0},
                {1,0,1,1},{1,1,1,0},{1,1,1,1}};
       /* int originalMatrix[][] = {{1, 0, 0, 0},
            {1, 1, 0, 1},
            {1, 1, 0, 0},
            {0, 1, 1, 1}};*/
        int[][] outPutMatrix={{0,0,0,0},
                {0,0,0,0},{0,0,0,0},{0,0,0,0}};
       traversePath(originalMatrix,0,0,outPutMatrix);
       System.out.println(outPutMatrix);
    }

    public static void traversePath(int[][]originalMatrix,int row,int col,int[][] output) {
        if(col== originalMatrix[0].length){
            row++;
            col=0;
        }

            if (isPathFree(originalMatrix, row, col,output)) {
            col++;
            traversePath(originalMatrix, row, col, output);

        }
            else{
                if(row+1< originalMatrix.length) {
                    traversePath(originalMatrix, row + 2, 0, output);
                }

            }
    }



    public static boolean isPathFree(int[][]originalMatrix,int row,int col,int[][] outputMatrix){
        if(row< originalMatrix.length && col < originalMatrix.length && originalMatrix[row][col]==1 ) {
            outputMatrix[row][col] = 1;
        }

            if(row+1 <originalMatrix.length && originalMatrix[row+1][col]==1) {
                outputMatrix[row+1][col] = 1;

                return true;
            }
            if(col+1 <originalMatrix.length && originalMatrix[row][col+1]==1) {
                outputMatrix[row][col+1]=1;
                return true;
            }
        outputMatrix[row][col] = 0;

        return false;
        }



}
