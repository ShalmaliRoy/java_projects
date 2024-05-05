package com.data.structure;

public class NQueens {

    public static void main(String... args) {

        NQueen(new boolean[4][4], 0, 0, 4, 0, "");
    }

    public static void NQueen(boolean board[][], int row, int col, int queenPlacedToBePlaced, int queenPlaced, String ans) {
        if (queenPlacedToBePlaced == queenPlaced) {
            System.out.println(ans);
            return;
        }
        if(col==board[0].length) {
            col = 0;
            row++;
        }
        if(row==board.length)
            return;
       if(isSafeToPlace(board,row,col)) {
           board[row][col] = true;
           NQueen(board, row, col+1, queenPlacedToBePlaced, queenPlaced + 1, ans+"["+row + "-" + col+"]");
           board[row][col] = false;

       }
      NQueen(board, row, col+1, queenPlacedToBePlaced, queenPlaced
              , ans);

    }

    public static boolean isSafeToPlace(boolean board[][], int row, int col) {

        int row1 = row - 1;
        int col1 = col;
        while (row1 >= 0) {
            if (board[row1][col1]) {
                return false;
            }
            row1--;
        }

        col1 = col-1;
        row1=row-1;
        while (row1 >= 0 && col1 >= 0) {
            if (board[row1][col1]) {
                return false;
            }
            row1--;
            col1--;
        }
        row1 = row-1;
        col1 = col+1;
        while (row1 >=0 && col1 <
                board[0].length) {
             if (board[row1][col1]) {
                 return false;
             }
            row1--;
            col1++;
        }

        return true;
    }
}
