package od真题.总览._116字符串拼接;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-04-11
 **/
public class Solution {
    static char[] s;
    static int k;
    static int ans = 0;
    static int n;
    static boolean[] vis;
    static StringBuilder v = new StringBuilder();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 读取输入
        String input = scanner.nextLine();
        String[] inputArray = input.split(" ");
        s = inputArray[0].toCharArray();
        Arrays.sort(s);  // 将字符数组按照字典序排序，方便后续去重操作
        k = Integer.parseInt(inputArray[1]);
        n = s.length;
        vis = new boolean[n];  // 用于标记当前字符是否被选取

        // 调用深度优先搜索函数
        dfs(0);

        // 输出结果
        System.out.println(ans);
    }

    // 定义深度优先搜索函数
    static void dfs(int u) {
        if (u == k) {
            ans++;
            return;
        }
        for (int i = 0; i < n; i++) {
            // 如果当前字符已经被使用过，或者与上一个字符一样（但上一个字符未被使用），则跳过
            if (vis[i] || (i > 0 && s[i] == s[i - 1] && !vis[i - 1])) {
                continue;
            }
            // 如果相邻字符相同，则跳过
            if (v.length() > 0 && v.charAt(v.length() - 1) == s[i]) {
                continue;
            }
            // 将当前字符添加到序列中，更新标记，并进行递归
            v.append(s[i]);
            vis[i] = true;
            dfs(u + 1);
            // 回溯操作，将当前字符从序列中移除，还原标记
            v.deleteCharAt(v.length() - 1);
            vis[i] = false;
        }
    }
}
