package od真题.分类.dfs或者bfs._26分披萨;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-03-23
 **/
import java.util.Scanner;

public class Main {
    static int n;  // 披萨的数量
    static int[] a;  // 每块披萨的大小
    static long[][] dp;  // 记忆化数组，用于存储已计算过的状态

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();  // 输入披萨的数量
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();  // 输入每块披萨的大小
        }
        dp = new long[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }

        long ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, solve((i + 1) % n, (i + n - 1) % n) + a[i]);
        }

        System.out.println(ans);  // 输出最多能吃到的披萨的美味值
    }

    static long solve(int L, int R) {
        // “馋嘴“选择一块披萨吃掉，对应端点移动
        if (a[L] > a[R]) {
            L = (L + 1) % n;
        } else {
            R = (R + n - 1) % n;
        }

        if (dp[L][R] != -1) {
            return dp[L][R];
        }

        if (L == R) {
            dp[L][R] = a[L];
        } else {
            dp[L][R] = Math.max(a[L] + solve((L + 1) % n, R), a[R] + solve(L, (R + n - 1) % n));
        }

        return dp[L][R];
    }
}





        

