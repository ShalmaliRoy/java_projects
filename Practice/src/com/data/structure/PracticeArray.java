package com.data.structure;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PracticeArray {


    public static void main(String... args) {
      // int[][] a = {{1, 2, 3, }, {4, 5, 6}, {7, 8, 9}};
     //  int[][]a={{6},{9},{7}};
        //int[][]a={{6,9,7}};
       int[][] a = {{1, 2, 3,4 }, {5, 6, 7,8}, {9, 10, 11,12}};

         //int[][] a = {{1, 2, 3, 4,5}, { 6, 7, 8,9,10}, {11, 12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};
        //  printArrayWave(a);

        int rowMin=0;
        int rowMax=a.length;
        int colMin=0;
        int colMax=a[0].length-1;

       //printArraySpiral( rowMin, rowMax, colMin, colMax,a);
        printArraySpiralAnticlock(rowMin, rowMax, colMin, colMax,a,new ArrayList<Integer>());
       // printMatrixRotation(a);

    }

    private static void printArrayWave(int [][] a) {
        for (int i = 0; i < a[0].length; i++) {
            int row = a.length;
            int count = row - 1;
            for (int j = 0; j < row; j++) {
                if (i % 2 == 0)
                    System.out.println(a[j][i]);
                else {
                    System.out.println(a[count][i]);
                    count--;
                }


            }
        }
    }

    private static void printArraySpiral(int rowMin,int rowMax,int colMin,int colMax,int [][] matrix) {

        for (int i = rowMin; i < rowMax; i++) {
            //  int row = a[0].length;
            System.out.print(matrix[i][colMin]);
        }
        for (int j = colMin+1; j <= colMax-1; j++) {
            System.out.print(matrix[rowMax-1][j]);

        }
        for(int k=rowMax-1;k>=rowMin;k--){

            System.out.print(matrix[k][colMax]);
            //count++;

        }
        for(int l=colMax-1;l> colMin;l--){
            System.out.print(matrix[rowMin][l]);

        }
        if(rowMin+1 < rowMax-1)
        printArraySpiral( rowMin+1, rowMax-1, colMin+1, colMax-1,matrix);

    }

    private static List<Integer> printArraySpiralAnticlock(int rowMin, int rowMax, int colMin, int colMax, int [][] matrix,List list) {
        for (int j = colMin; j <= colMax; j++) {
            list.add(matrix[rowMin][j]);

        }
        for(int k=rowMin+1;k<rowMax;k++){

            list.add(matrix[k][colMax]);
            //count++;

        }
        if(colMax!=0 && colMax<=rowMax) {
            for (int l = colMax - 1; l > colMin; l--) {
                list.add(matrix[rowMax - 1][l]);

            }
            for (int i = rowMax - 1; i > rowMin; i--) {
                //  int row = a[0].length;
                list.add(matrix[i][colMin]);
            }
        }



        if(rowMin+1 < rowMax-1)
            printArraySpiralAnticlock( rowMin+1, rowMax-1, colMin+1, colMax-1,matrix,list);
        return list;

    }


    private static void printMatrixRotation(int[][]matrix) {
        int temp = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix[0].length; j++) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

            int col = 0;
            for (int i = 0; i < matrix.length; i++) {
                col=matrix[0].length-1;
                for (int j = 0; j < matrix.length/2; j++) {

                        temp = matrix[i][j];
                        matrix[i][j] = matrix[i][col];
                        matrix[i][col] = temp;
                        col--;
                    }

            }


    }
    private static int fibonnaci(int x){
        int num=0;
        return num=(x==1)?x:x+fibonnaci(x-1);



    }


}
