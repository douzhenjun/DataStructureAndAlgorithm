package 剑指offer.剑指offer12_矩阵中的路径;

import java.util.Arrays;

public class HasPath_2 {
    public static boolean hasPath(int rows, int cols, char[][] matrix, char[] path) {
        if (rows < 0 || rows > matrix.length || cols < 0 || cols > matrix[0].length) {
            return false;
        }
        int k = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == path[k]) {
                    boolean[][] visited = new boolean[rows][cols];
                    boolean hasPath = hasPathCore(i, j, k, rows, cols, matrix, path, visited);
                    if (hasPath) {
                        return hasPath;
                    }
                }
            }
        }
        return false;
    }

    private static boolean hasPathCore(int i, int j, int k, int rows, int cols, char[][] matrix, char[] path, boolean[][] visited) {
        if (i < 0 || i > rows - 1 || j < 0 || j > cols - 1 || k < 0) {
            return false;
        }

        int n = path.length - 1;
        if (matrix[i][j] == path[k] && !visited[i][j]) {
            if (k == n) {
                return true;
            } else if (k < n) {
                visited[i][j] = true;
                return hasPathCore(i - 1, j, k + 1, rows, cols, matrix, path, visited)
                        || hasPathCore(i + 1, j, k + 1, rows, cols, matrix, path, visited)
                        || hasPathCore(i, j - 1, k + 1, rows, cols, matrix, path, visited)
                        || hasPathCore(i, j + 1, k + 1, rows, cols, matrix, path, visited);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        char[][] matrix = {{'a', 'b', 't', 'g'}, {'c', 'f', 'c', 's'}, {'j', 'd', 'e', 'h'}};

        char[] path = {'b', 'f', 'c', 'e'};

        int rows = matrix.length;

        int cols = matrix[0].length;

        boolean hasPath = hasPath(rows, cols, matrix, path);

        System.out.println("path" + Arrays.toString(path) + "在matrix中:" + hasPath);

        char[] path2 = {'a', 'b', 'f', 'b'};

        boolean hasPath2 = hasPath(rows, cols, matrix, path2);

        System.out.println("path2" + Arrays.toString(path2) + "在matrix中:" + hasPath2);
    }
}
