package od真题.分类.硬骨头._26分披萨.test;

import java.util.Scanner;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-03-31
 **/
public class Solution {
    static int n;
    static int[] a;
    static long[][] dp;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
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
        System.out.println(ans);
    }

    static long solve(int L, int R) {
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
