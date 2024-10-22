package od真题.分类.dfs或者bfs._21小华寻宝;

import java.util.Scanner;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-03-23
 **/
public class Solution {
    static int[][] vis;
    static int m, n, k;
    static int res = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        m = scanner.nextInt();
        n = scanner.nextInt();
        k = scanner.nextInt();

        vis = new int[n][m];
        dfs(0, 0);
        System.out.println(res);
    }

    private static void dfs(int x, int y) {
        if (x < 0 || x >= n || y < 0 || y >= m || vis[x][y] == 1) {
            return;
        }
        vis[x][y] = 1;
        if (get(x) + get(y) > k) {
            return;
        }
        res++;
        dfs(x, y - 1);
        dfs(x, y + 1);
        dfs(x + 1, y);
        dfs(x - 1, y);
    }

    private static int get(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}
