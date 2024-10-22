package od真题.总览._118伐木工;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-04-11
 **/
public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int[] dp = new int[n + 1];
        //每个数对应的因子的最大乘积
        for (int i = 1; i <= n; i++) {
            dp[i] = i;
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], Math.max(dp[i - j] * j, (i - j) * j));
            }
        }

        List<Integer> res = new ArrayList<>();
        int m = n;
        while (m >= 1) {
            //如果整根最大,那么结果就添加整根长度就可以了
            if (dp[m] == m) {
                res.add(m);
                break;
            }
            //如果整根长度不是最大,找到满足k * (m - k) = dp[m]的这个k, m-k
            for (int k = m - 1; k > 1; k--) {
                if (k * (m - k) == dp[m]) {
                    res.add(k);
                    res.add(m - k);
                    m = 0;
                    break;
                    //如果是k*dp[m-k]=dp[m]成立,那么首先将k添加进res,然后对dp[m-k]进行
                } else if (k * dp[m - k] == dp[m]) {
                    res.add(k);
                    m -= k;
                    break;
                }
            }
        }

        Collections.sort(res);
        for (int i : res) {
            System.out.print(i + " ");
        }
    }
}
