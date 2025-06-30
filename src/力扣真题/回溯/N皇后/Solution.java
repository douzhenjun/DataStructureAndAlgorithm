package 力扣真题.回溯.N皇后;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-03-02
 **/
public class Solution {
    List<List<String>> res = new ArrayList<>();
    String[][] board;

    public List<List<String>> solveNQueens(int n) {
        board = new String[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], ".");
        }
        getPath(board, 0);
        return res;
    }

    private void getPath(String[][] board, int row) {
        //当路径中的元素数量等于n时
        if (row == board.length) {
            List<String> newList = new ArrayList<>();
            for(int i = 0; i < board.length; i++){
                String[] array = board[i];
                StringBuilder sb = new StringBuilder();
                for(int j = 0; j < array.length; j++){
                    sb.append(array[j]);
                }
                newList.add(sb.toString());
            }
            res.add(newList);
            return;
        }

        for (int col = 0; col < board.length; col++) {
                if (!isAttacked(row, col, board)) {
                    board[row][col] = "Q";
                    getPath(board, row+1);
                    board[row][col] = ".";
                }
            }
    }

    private boolean isAttacked(int x, int y, String[][] board) {
        for (int k = 1; k < board.length; k++) {
            if ((x + k < board.length && board[x + k][y].equals("Q"))
                    || (x - k >= 0 && board[x - k][y].equals("Q"))
                    || (y + k < board.length && board[x][y + k].equals("Q"))
                    || (y - k >= 0 && board[x][y - k].equals("Q"))
                    || (x + k < board.length && y + k < board.length && board[x + k][y + k].equals("Q"))
                    || (x + k < board.length && y - k >= 0 && board[x + k][y - k].equals("Q"))
                    || (x - k >= 0 && y + k < board.length && board[x - k][y + k].equals("Q"))
                    || (x - k >= 0 && y - k >= 0 && board[x - k][y - k].equals("Q"))) {
                return true;
            }
        }
        return false;
    }
}
