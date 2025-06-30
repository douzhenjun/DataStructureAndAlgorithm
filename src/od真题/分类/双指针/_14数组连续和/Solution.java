package od真题.分类.双指针._14数组连续和;

import java.util.Scanner;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-03-22
 **/
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();//数组大小
        int x = sc.nextInt();//目标数x,要求数组中的元素和大于等于x
        int[] w = new int[n];
        long ans = 0;//记录结果
        int l = 0, r = 0;
        int sum = 0;
        
        for(int i = 0; i < n; i++){
            w[i] = sc.nextInt();
        }
        while(r < n){
            sum += w[r];
            while(sum >= x && l <= r){
                ans += n - r;
                sum -= w[l];
                l++;
            }
            r++;
        }
        System.out.println(ans);
    }
}
