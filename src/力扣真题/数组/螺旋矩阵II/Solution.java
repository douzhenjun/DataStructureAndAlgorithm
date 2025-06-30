package 力扣真题.数组.螺旋矩阵II;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-04-20
 **/
public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] nums = new int[n][n];
        int startX = 0, startY = 0;//每一圈的起始点
        int offset = 1;
        int count = 1;//矩阵中需要填写的数字
        int loop = 1;

        int i, j;
        while (loop <= n / 2) {
            for (j = startY; j < n - offset; j++) {
                nums[startX][j] = count++;
            }
            for (i = startX; i < n - offset; i++) {
                nums[i][j] = count++;
            }
            for (; j > startY; j--) {
                nums[i][j] = count++;
            }
            for (; i > startX; i--) {
                nums[i][j] = count++;
            }
            startX++;
            startY++;
            offset++;
            loop++;
        }
        if (n % 2 == 1) {
            nums[startX][startY] = count;
        }
        return nums;
    }
}
