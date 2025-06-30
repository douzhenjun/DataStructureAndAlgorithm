package od真题.总览._79小华和小为的聚餐地点;

import java.util.*;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-04-03
 **/
public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[][] a = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = scanner.nextInt();//读入地图
            }
        }

        int[] s1 = {-1, -1};//小华所在的起点
        int[] s2 = {-1, -1};//小为所在的起点
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i][j] == 2) {
                    if (s1[0] == -1) {
                        s1 = new int[]{i, j};
                    } else {
                        s2 = new int[]{i, j};
                    }
                }
            }
        }

        int[][] arrive = new int[n][m];//表示地图上每个点被每个人bfs走过的情况
        bfs(s1, arrive, 1, n, m, a);//小华bfs
        bfs(s2, arrive, 2, n, m, a);//小为bfs

        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i][j] == arrive[i][j] && a[i][j] == 3) {
                    ans++;
                }
            }
        }
        System.out.println(ans);
    }

    static void bfs(int[] st, int[][] arrive, int val, int n, int m, int[][] a) {
        Queue<int[]> q = new LinkedList<>();
        q.add(st);
        arrive[st[0]][st[1]] = val;
        List<int[]> directions = Arrays.asList(new int[]{0, -1}, new int[]{1, 0}, new int[]{0, 1}, new int[]{-1, 0});

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int x = curr[0];
            int y = curr[1];
            for (int[] dir : directions) {
                int nx = x + dir[0];
                int ny = y + dir[1];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    continue;
                }
                if (a[nx][ny] == 1 || (arrive[nx][ny] & val) == val) {
                    continue;
                }
                arrive[nx][ny] = arrive[nx][ny] | val;
                q.add(new int[]{nx, ny});//加入队列
            }
        }
    }
}
