package 力扣真题.回溯.N皇后.test;

import java.util.Arrays;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-03-03
 **/
public class TestDemo {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solveNQueens(4));
        
        String[][] board = new String[4][4];
        for(String rows[] : board){
            Arrays.fill(rows, ".");
        }
        board[1][3] = "Q";
        System.out.println(solution.isAttacked(2,2,board));
    }
}
