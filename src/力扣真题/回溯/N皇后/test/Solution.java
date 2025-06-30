package 力扣真题.回溯.N皇后.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-03-03
 **/
public class Solution {
    private List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        String[][] board = new String[n][n];
        for (String[] row : board) {
            Arrays.fill(row, ".");
        }
        backtracking(0, board);
        return res;
    }

    public void backtracking(int row, String[][] board) {
        if (row == board.length) {
            List<String> list = new ArrayList<>();
            for (String[] boardRow : board) {
                StringBuilder sb = new StringBuilder();
                for (String col : boardRow) {
                    sb.append(col);
                }
                list.add(sb.toString());
            }
            res.add(list);
            return;
        }
        for (int col = 0; col < board.length; col++) {
            if (!isAttacked(row, col, board)) {
                board[row][col] = "Q";
                backtracking(row + 1, board);
                board[row][col] = ".";
            }
        }
    }

    public boolean isAttacked(int x, int y, String[][] board) {
        for (int i = -board.length+1; i != 0 && i < board.length; i++) {
            if ((0 <= x + i && x + i < board.length) && board[x + i][y].equals("Q")) {
                return true;
            }
            if ((0 <= y + i && y + i < board.length) && board[x][y + i].equals("Q")) {
                return true;
            }
            if ((0 <= x + i && x + i < board.length) && (0 <= y + i && y + i < board.length)
                    && board[x + i][y + i].equals("Q")) {
                return true;
            }
            if ((0 <= x + i && x + i < board.length) && (0 <= y - i && y - i < board.length)
                    && board[x + i][y - i].equals("Q")) {
                return true;
            }
        }
        return false;
    }
    
}
