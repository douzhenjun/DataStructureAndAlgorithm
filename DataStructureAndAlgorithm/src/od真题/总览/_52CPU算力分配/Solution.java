package od真题.总览._52CPU算力分配;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @Description
 * 设A组算力和为total1, B组算力和为total2, 考虑A组的a和B组的b做交换
 * total1 - a + b = total2 - b + a
 * 则 b = a - (total1 - total2) / 2;
 * 可以将B的每一个元素存到哈希表中, 然后对数组A进行排序之后从小到大遍历A服务器
 * 如果哈希表中存在a - (total1 - total2) / 2, 则说明存在一个答案满足条件, 直接输出即可.
 * @Author douzhenjun
 * @DATE 2024-03-26
 **/
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] w1 = new int[n];
        int[] w2 = new int[m];
        int total_1 = 0;//记录第一行数组中的元素之和
        int total_2 = 0;//记录第二行数组中的元素之和
        for (int i = 0; i < n; i++) {
            w1[i] = sc.nextInt();
            total_1 += w1[i];
        }
        for (int i = 0; i < m; i++) {
            w2[i] = sc.nextInt();
            total_2 += w2[i];
        }
        //定义一个哈希表,拿到w2的算力保存(重复元素只存一个)
        // 遍历w1数组中寻找算力=target的cpu所属编号
        int target = (total_1 - total_2) / 2;
        Set<Integer> st = new HashSet<>();
        for (int x : w2) {
            st.add(x);
        }
        Arrays.sort(w1);
        for (int x : w1) {
            if (st.contains(x - target)) {
                System.out.println(x + " " + (x - target));
                return;
            }
        }
    }
}
