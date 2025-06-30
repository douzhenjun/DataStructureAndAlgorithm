package od真题.总览._102局域网中服务器个数;

import java.util.Scanner;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-04-07
 **/
public class Solution {
    static int n, m; // 定义行数和列数
    static int[][] g; // 定义二维数组存储网格
    static boolean[][] st; // 定义二维数组标记是否访问过
    static int[] dx = {-1, 1, 0, 0}; // 方向数组，表示上下左右四个方向的横坐标变化
    static int[] dy = {0, 0, 1, -1}; // 方向数组，表示上下左右四个方向的纵坐标变化
    static int cnt, res; // 计数器和结果

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // 读入数据
        n = scanner.nextInt(); // 读入行数
        m = scanner.nextInt(); // 读入列数
        g = new int[n][m]; // 初始化二维数组
        st = new boolean[n][m]; // 初始化标记数组

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                g[i][j] = scanner.nextInt(); // 读入网格数据
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (g[i][j] == 1 && !st[i][j]) { // 如果当前位置是陆地且未被访问过
                    cnt = 0; // 计数器清零
                    dfs(i, j); // 进行深度优先搜索
                    res = Math.max(res, cnt); // 更新结果
                }
            }
        }

        System.out.println(res); // 输出结果
    }

    private static void dfs(int i, int j) {
        cnt++; // 计数器加一
        st[i][j] = true; // 标记当前位置为已访问
        for (int d = 0; d < 4; d++) { // 遍历四个方向
            int x = dx[d] + i, y = dy[d] + j; // 计算新的位置
            if (x >= 0 && x < n && y >= 0 && y < m && !st[x][y] && g[x][y] == 1) { // 如果新位置合法且是陆地且未被访问过
                dfs(x, y); // 递归访问新位置
            }
        }
    }
}
