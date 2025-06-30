package od真题.总览._34最优投资方式.test;

import java.util.Scanner;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-04-01
 **/
public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();
        
        int[] w = new int[n];
        int[] risk = new int[n];
        int[] cost = new int[n];
        
        for(int i = 0; i < n; i++){
            w[i] = scanner.nextInt();
        }
        for(int i = 0; i < n; i++){
            risk[i] = scanner.nextInt();
        }
        for(int i = 0; i < n; i++){
            cost[i] = scanner.nextInt();
        }
        for(int i = 0; i < n; i++){
            w[i] = w[i] * cost[i];
        }
        int[] choose = new int[n];
        int ans = 0;
        for(int i = 0; i < n; i++){
            if(risk[i] <= k && cost[i] <= m && ans < w[i]){
                ans = w[i];
                choose = new int[]{i};
            }
        }
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                if(risk[i] + risk[j] <= k && cost[i] + cost[j] <= m && ans < w[i] + w[j]){
                    ans = w[i] + w[j];
                    choose = new int[]{i, j};
                }
            }
        }
        int[] ansVec = new int[n];
        for(int x : choose){
            ansVec[x] = cost[x];
        }
    }
}
