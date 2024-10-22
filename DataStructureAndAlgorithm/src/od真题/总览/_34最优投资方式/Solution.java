package od真题.总览._34最优投资方式;

import java.util.Scanner;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-03-24
 **/
public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //产品数
        int n = scanner.nextInt();
        //总投资数
        int m = scanner.nextInt();
        //可接受的风险
        int k = scanner.nextInt();
        
        int[] w = new int[n];//回报率
        int[] risk = new int[n];//风险值
        int[] cost = new int[n];//最大投资额 投资额 * 回报率 = 投资回报
        
        for(int i = 0; i < n; i++){
            w[i] = scanner.nextInt();
        }
        for(int i = 0; i < n; i++){
            risk[i] = scanner.nextInt();
        }
        for(int i = 0; i < n; i++){
            cost[i] = scanner.nextInt();
        }
        //产品投资回报
        for(int i = 0; i < n; i++){
            w[i] = w[i] * cost[i];
        }
        int[] choose = new int[n];//创建长度为n的数组choose
        int ans = 0;//最大收益
        
        //首先考虑只投资一个产品
        for(int i = 0; i < n; i++){
            if(risk[i] <= k && cost[i] <= m && ans < w[i]){
                ans = w[i];
                choose = new int[]{i};
            }
        }
        //然后考虑投资两个产品
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (risk[i] + risk[j] <= k && cost[i] + cost[j] <= m && ans < w[i] + w[j]) {
                    ans = w[i] + w[j];
                    choose = new int[]{i, j};
                }
            }
        }

        int[] ansVec = new int[n];  // 创建长度为n的数组ansVec

        for (int x : choose) {
            ansVec[x] = cost[x];
        }

        for (int x : ansVec) {
            System.out.print(x + " ");  // 输出最终选择的投资序列
        }
    }
}
