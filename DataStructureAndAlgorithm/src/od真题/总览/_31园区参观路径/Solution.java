package od真题.总览._31园区参观路径;

import java.util.Scanner;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-03-24
 **/
public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);  // 创建Scanner对象，用于从标准输入流读取数据

        int N = 1010;  // 定义常量N为1010
        long[][] g = new long[N][N];  // 创建二维数组g
        long[][] f = new long[N][N];  // 创建二维数组f

        int n = scanner.nextInt();  // 从标准输入流读取n的值
        int m = scanner.nextInt();  // 从标准输入流读取m的值

        for (int i = 0; i < n; i++) {  // 遍历n次
            for (int j = 0; j < m; j++) {  // 遍历m次
                g[i][j] = scanner.nextLong();  // 从标准输入流读取数据，赋值给g[i][j]
            }
        }

        for (int i = 0; i < m; i++) {  // 遍历m次
            if (g[0][i] != 0) {  // 如果g[0][i]不为0
                break;  // 跳出循环
            }
            f[0][i] = 1;  // 将f[0][i]的值设为1
        }

        for (int i = 0; i < n; i++) {  // 遍历n次
            if (g[i][0] != 0) {  // 如果g[i][0]不为0
                break;  // 跳出循环
            }
            f[i][0] = 1;  // 将f[i][0]的值设为1
        }

        for (int i = 1; i < n; i++) {  // 遍历n-1次
            for (int j = 1; j < m; j++) {  // 遍历m-1次
                if (g[i][j] != 0) {  // 如果g[i][j]不为0
                    f[i][j] = 0;  // 将f[i][j]的值设为0
                } else {
                    f[i][j] = f[i - 1][j] + f[i][j - 1];  // 否则，将f[i][j]的值设为f[i-1][j]+f[i][j-1]
                }
            }
        }

        System.out.println(f[n - 1][m - 1]);  // 输出f[n-1][m-1]的值
    }
}
