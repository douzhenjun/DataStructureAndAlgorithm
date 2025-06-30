package 力扣真题.回溯.回溯算法解单词搜索;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-08-27
 **/
public class Solution {
    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, words, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    boolean dfs(char[][] board, char[] word, int i, int j, int index) {
        if (i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != word[index]) {
            return false;
        }
        if (index == word.length - 1) {
            return true;
        }
        char tmp = board[i][j];
        board[i][j] = '-';
        boolean res = dfs(board, word, i + 1, j, index + 1)
                || dfs(board, word, i - 1, j, index + 1)
                || dfs(board, word, i, j + 1, index + 1)
                || dfs(board, word, i, j - 1, index + 1);
        board[i][j] = tmp;
        return res;
    }
}
