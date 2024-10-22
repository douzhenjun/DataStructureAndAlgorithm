package 华为面试模拟题.蛇形矩阵;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-04-24
 **/
public class Solution {
    public void convert(int numRows) {
        int[][] matrix = new int[numRows][numRows];
        int rowIncrement = 0;
        matrix[0][0] = 1;
        for (int i = 0; i < numRows; i++) {
            int numCols = numRows;
            int colIncrement = i + 2;
            if (i > 0) {
                matrix[i][0] = matrix[i - 1][0] + rowIncrement;
            }
            for (int j = 1; j < numCols; j++) {
                matrix[i][j] = matrix[i][j - 1] + colIncrement;
                colIncrement++;
            }
            rowIncrement++;
            numCols--;
        }
        // 输出蛇形矩阵
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numRows - i; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
