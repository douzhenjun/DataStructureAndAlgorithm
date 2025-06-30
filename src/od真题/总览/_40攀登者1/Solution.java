package od真题.总览._40攀登者1;

import java.util.Scanner;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-03-24
 **/
public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        s = s.substring(1, s.length() - 1);  // 去掉开头的[和结尾的]
        String[] split = s.split(",");  // 转为数组
        int[] w = new int[split.length];

        for (int i = 0; i < split.length; i++) {
            w[i] = Integer.parseInt(split[i]);
        }

        int res = 0;
        int n = w.length;

        for (int i = 0; i < n; i++) {
            int l = -1000000000, r = -1000000000;  // 初始化相邻元素值
            if (i > 0) {
                l = w[i - 1];
            }
            if (i + 1 < n) {
                r = w[i + 1];
            }
            if (w[i] > l && w[i] > r) {
                res++;
            }
        }
        
        System.out.println(res);
    }
}
