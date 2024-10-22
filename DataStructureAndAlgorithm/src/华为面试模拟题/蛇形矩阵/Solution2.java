package 华为面试模拟题.蛇形矩阵;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-05-16
 **/
public class Solution2 {
    public void convert(int numRows) {
        int[][] array = new int[numRows][numRows];
        int i = 0, j = 0;
        int index = 1;
        for(int k = 0; k < numRows; k++){
            i = k;
            j = 0;
            while(i >= 0){
                array[i][j] = index;
                i--;
                j++;
                index++;
            }
        }
        //打印
        for(int row = 0; row < numRows; row++){
            for(int col = 0; col < numRows - row; col++){
                System.out.print(array[row][col] + " ");
            }
            System.out.println();
        }
    }
}
