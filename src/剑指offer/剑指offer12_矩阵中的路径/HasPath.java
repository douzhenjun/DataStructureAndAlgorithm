package 剑指offer.剑指offer12_矩阵中的路径;

import java.util.Arrays;

public class HasPath {
    public static boolean hasPath(char[] matrix, int rows, int cols, char[] str){
        if(matrix == null || rows < 1 || cols < 1 || str == null){
            return false;
        }
        boolean[] visited = new boolean[rows*cols];
        int pathLength = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if(hasPathCore(matrix, rows, cols, row, col, str, pathLength, visited)){
                    return true;
            }
        }
        }
        return false;
    }

    private static boolean hasPathCore(char[] matrix, int rows, int cols, int row, int col, char[] str, int pathLength, boolean[] visited) {
        boolean hasPath = false;
        if(row >= 0 && row < rows && col >= 0 && col < cols
            && matrix[row*cols+col] == str[pathLength]
            && !visited[row*cols+col]){
            pathLength++;
            visited[row*cols+col] = true;
            hasPath = hasPathCore(matrix, rows, cols, row, col-1, str, pathLength, visited)
                    || hasPathCore(matrix, rows, cols, row-1, col, str, pathLength, visited)
                    || hasPathCore(matrix, rows, cols, row, col+1, str, pathLength, visited)
                    || hasPathCore(matrix, rows, cols, row+1, col, str, pathLength, visited);
        }
        if(!hasPath){
            pathLength--;
            visited[row*cols+col] = false;
        }
        return hasPath;
    }

    public static void main(String[] args) {
        char[] matrix = new char[]{'a', 'b', 't', 'g', 'c', 'f', 'c', 's', 'j', 'd', 'e', 'h'};

        char[] str = new char[]{'b', 'c', 'f', 'e'};

        int rows = 3;

        int cols = 4;

        boolean isPath = hasPath(matrix, rows, cols, str);

        System.out.println("矩阵matrix:");

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                System.out.println(matrix[i*cols+j]);
            }
        }

        System.out.println("路径"+Arrays.toString(str)+"是矩阵matrix的路径:" + isPath);

    }
}
