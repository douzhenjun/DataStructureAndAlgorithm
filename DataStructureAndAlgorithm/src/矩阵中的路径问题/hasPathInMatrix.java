package 矩阵中的路径问题;

public class hasPathInMatrix {
    public static boolean hasPath(char[][] matrix, int rows, int cols, String strs){
        if(matrix == null || rows < 1 || cols < 1 || strs == null){
            return false;
        }

        boolean[][] visited = new boolean[rows][cols];
        int pathLength = 0;
        for(int row = 0; row < rows; row++){
            for(int col = 0; col < cols; col++){
                if(hasPathCore(matrix, rows, cols, row, col, strs, pathLength, visited)){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean hasPathCore(char[][] matrix, int rows, int cols, int row, int col, String strs, int pathLength, boolean[][] visited) {
        if (pathLength == strs.length()) {
            return true;
        }
        boolean hasPath = false;
        if (row >= 0 && row < rows && col >= 0 && col < cols
                && matrix[row][col] == strs.charAt(pathLength)
                && !visited[row][col]) {
            pathLength++;
            visited[row][col] = true;
        }
        hasPath = hasPathCore(matrix, rows, cols, row, col - 1, strs, pathLength, visited)
                || hasPathCore(matrix, rows, cols, row - 1, col, strs, pathLength, visited)
                || hasPathCore(matrix, rows, cols, row, col+1, strs, pathLength, visited)
                || hasPathCore(matrix, rows, cols, row+1, col, strs, pathLength, visited);

        if(!hasPath){
            pathLength--;
            visited[row][col] = false;
    }
        return hasPath;
    }


}
