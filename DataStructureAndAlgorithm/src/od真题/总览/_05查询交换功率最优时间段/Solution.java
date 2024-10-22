package od真题.总览._05查询交换功率最优时间段;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-03-22
 **/
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();       //第一行读入一个整数m
        int[] w = new int[110];
        int n = 0;
        while (sc.hasNextInt()) {   //第二行读入n个整数
            w[n++] = sc.nextInt();
        }
        List<List<Integer>> res = new ArrayList<>();
        int maxLen = 0;                                 //记录最长的数组段
        for (int l = 0; l < n; l++) {                   //枚举数组左端点
            for (int r = l, sum = 0; r < n; r++) {      //枚举数组右端点
                sum += w[r];
                if (sum <= m * (r - l + 1)) {
                    if (maxLen < r - l + 1) {
                        maxLen = r - l + 1;
                        res.clear();
                    }
                    if (maxLen == r - l + 1) {
                        res.add(Arrays.asList(l, r));
                    }
                }
            }
        }
        for(List<Integer> e : res){
            System.out.printf("%d"+"-"+"%d ", e.get(0), e.get(1));
        }
    }

}
