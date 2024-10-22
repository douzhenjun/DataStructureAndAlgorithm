package od真题.总览._29游戏分组;

import java.util.Scanner;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-03-24
 **/
public class Solution {
    static int[] w = new int[10];
    static int total;
    static int ans = Integer.MAX_VALUE;
    static boolean[] choose = new boolean[10];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 10; i++) {
            w[i] = scanner.nextInt();
            total += w[i];
        }

        dfs(0, 0);
        System.out.println(ans);
    }

    static void dfs(int cnt, int cur) {
        if (cnt == 5) {
            ans = Math.min(ans, Math.abs(total - 2 * cur));
            return;
        }
        for (int i = 0; i < 10; i++) {
            if (choose[i]) {
                continue;
            }
            choose[i] = true;
            dfs(cnt + 1, cur + w[i]);
            choose[i] = false;
        }
    }
}
