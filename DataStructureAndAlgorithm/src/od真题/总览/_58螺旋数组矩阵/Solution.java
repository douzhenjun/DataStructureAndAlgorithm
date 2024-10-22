package od真题.总览._58螺旋数组矩阵;

import java.util.Scanner;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-03-26
 **/
public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //输入k和n
        int k = scanner.nextInt();//数字个数
        int n = scanner.nextInt();//行数
        int m = (k - 1) / n + 1;//向上取整, 列数

        //创建n*m的矩阵并初始化为* 
        String[][] g = new String[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                g[i][j] = "*";
            }
        }

        //从左上角开始填充
        int x = 0;
        int y = 0;
        int num = 1;//从1开始填充
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        int dirc = 0;//方向

        while (num <= k) {
            g[x][y] = Integer.toString(num);
            num++;
            if (x + dx[dirc] < 0
                    || x + dx[dirc] >= n
                    || y + dy[dirc] < 0
                    || y + dy[dirc] >= m
                    || !g[x + dx[dirc]][y + dy[dirc]].equals("*")) {
                dirc = (dirc + 1) % 4;//改变方向
            }
            x += dx[dirc];
            y += dy[dirc];
        }
        //输出矩阵
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.println(g[i][j] + " ");
            }
            System.out.println();
        }
    }
}
