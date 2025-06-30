package od真题.总览._85图像物体的边界;

import java.util.Scanner;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-04-04
 **/
public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //读取地图的行数和列数
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        String[] mp = new String[n + 1];
        //读取地图信息
        for (int i = 1; i <= n; i++) {
            mp[i] = " " + scanner.next();
        }
        int[][] a = new int[n + 1][m + 1];
        int[][] visited = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (mp[i].charAt(j) == '5') {
                    //如果当前位置为5,则更新其周围相邻位置可达
                    for (int k = 0; k < 8; k++) {
                        int ni = i + dx[k];
                        int nj = j + dy[k];
                        if (ni >= 1 && ni <= n && nj >= 1 && nj <= m && mp[ni].charAt(nj) == '1') {
                            a[ni][nj] = 1;
                        }
                    }
                }
            }
        }
        int cnt = 0;//记录联通块的数量
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (a[i][j] == 1 && visited[i][j] == 0) {
                    cnt++;
                    dfs(i, j, a, visited, n, m);
                }
            }
        }
        //输出联通块的数量
        System.out.println(cnt);
    }

    static int[] dx = {0, 0, -1, 1, -1, 1, -1, 1};
    static int[] dy = {-1, 1, 0, 0, -1, 1, 1, -1};

    //深度优先搜索,用于遍历地图中的联通块
    static void dfs(int x, int y, int[][] a, int[][] visited, int n, int m) {
        if (x < 1 || x > n || y < 1 || y > m || a[x][y] == 0 || visited[x][y] == 1) {
            return;
        }
        visited[x][y] = 1;//标记当前位置位已访问
        //遍历当前位置的所有相邻位置
        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            dfs(nx, ny, a, visited, n, m);
        }
    }
}
