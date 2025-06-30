package od真题.总览._101最小矩阵宽度;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-04-07
 **/
public class Solution {

    public static int towPoints(int n, int m, HashMap<Integer, Integer> hm, int[][] arr) {
        HashMap<Integer, Integer> now = new HashMap<>();
        int ans = Integer.MAX_VALUE;

        // 使用双指针遍历矩阵的列
        for (int i = 0, j = 0; j < m; j++) {
            // 将当前右指针 j 所在的列的所有元素加入哈希表 now 中
            for (int k = 0; k < n; k++) {
                now.put(arr[k][j], now.getOrDefault(arr[k][j], 0) + 1);
            }

            // 当哈希表 now 覆盖了哈希表 hm 时，更新最小长度 ans，并将左指针 i 向右移动
            while (mapCover(now, hm)) {
                ans = Math.min(ans, j - i + 1);

                // 将当前左指针 i 所在的列的所有元素从哈希表 now 中删除
                for (int k = 0; k < n; k++) {
                    now.put(arr[k][i], now.getOrDefault(arr[k][i], 0) - 1);
                }
                i++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();  // 输入矩阵的行数 n
        int m = sc.nextInt();  // 输入矩阵的列数 m
        int[][] arr = new int[n][m];  // 用于存储输入矩阵的二维数组

        // 读取输入矩阵
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        int g = sc.nextInt();  // 输入数组 t 的长度 g
        int[] t = new int[g];  // 用于存储数组 t 的一维数组
        HashMap<Integer, Integer> hm = new HashMap<>();

        // 读取数组 t 的元素，并将其存储到哈希表 hm 中
        for (int i = 0; i < g; i++) {
            t[i] = sc.nextInt();
            hm.put(t[i], hm.getOrDefault(t[i], 0) + 1);
        }

        int ans = towPoints(n, m, hm, arr);

        // 如果最小长度 ans 未被更新，则输出 -1；否则输出 ans
        if (ans == Integer.MAX_VALUE) {
            System.out.println(-1);
            return;
        }
        System.out.println(ans);
        return;
    }

    // 检查哈希表 now 是否覆盖了哈希表 hm
    public static boolean mapCover(HashMap<Integer, Integer> now, HashMap<Integer, Integer> hm) {
        for (int i : hm.keySet()) {
            if (now.getOrDefault(i, 0) < hm.get(i)) {
                return false;
            }
        }
        return true;
    }
}
