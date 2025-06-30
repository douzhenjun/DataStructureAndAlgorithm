package od真题.总览._110贪吃的猴子;

import java.util.Scanner;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-04-11
 **/
public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //香蕉数组的长度
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for(int i = 0; i < n; i++){
            nums[i] = scanner.nextInt();
        }
        //获取的次数k
        int k = scanner.nextInt();
        int number = 0;
        for(int i = 0; i < k; i++){
            number += nums[i];
        }
        int ans = number;
        int l = k - 1;
        int r = n - 1;
        while(l >= 0){
            number -= nums[l];
            number += nums[r];
            ans = Math.max(ans, number);
            r--;
            l--;
        }
        System.out.println(ans);
    }
}
