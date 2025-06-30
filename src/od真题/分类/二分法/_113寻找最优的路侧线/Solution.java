package od真题.分类.二分法._113寻找最优的路侧线;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-04-11
 **/
public class Solution {
    static final int N = 25;
    static int n, m;
    static int[][] g = new int[N][N];
    static boolean[][] vis = new boolean[N][N];
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    // 深度优先搜索函数，判断是否能从起点 (x, y) 到达终点 (n-1, m-1)，
    // 限制条件是当前路径上的值不小于 limit
    static boolean dfs(int x, int y, int limit) {
        // 如果当前位置的值小于 limit，直接返回 False
        if (g[x][y] < limit) return false;
        // 如果已经到达终点，返回 True
        if (x == n - 1 && y == m - 1) return true;
        // 标记当前位置已经访问
        vis[x][y] = true;
        // 遍历四个方向
        for (int i = 0; i < 4; i++) {
            int a = dx[i] + x, b = dy[i] + y;
            // 判断是否越界、已访问或者值小于 limit，是则继续下一个方向
            if (a < 0 || a >= n || b < 0 || b >= m || vis[a][b] || g[a][b] < limit) continue;
            // 递归调用 dfs，判断是否能从新的位置 (a, b) 到达终点
            if (dfs(a, b, limit)) return true;
        }
        // 若四个方向都无法到达终点，则返回 False
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();

        // 读取输入矩阵的值
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                g[i][j] = scanner.nextInt();
            }
        }

        int l = 0, r = 65535;
        // 二分搜索
        while (l < r) {
            int mid = (l + r) / 2;
            // 初始化 vis 数组
            for (int i = 0; i < N; i++) {
                Arrays.fill(vis[i], false);
            }
            // 如果可以从起点到达终点，更新 l 为当前限制条件
            if (dfs(0, 0, mid)) l = mid + 1;
            else r = mid;
        }

        // 输出结果
        System.out.println(l-1);
    }
}
