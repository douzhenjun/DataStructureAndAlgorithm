package od真题.总览._67执行时长;

import java.util.Scanner;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-03-28
 **/
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[] nums = new int[n];
        
        for(int i = 0; i < n; i++){
            nums[i] = sc.nextInt();
        }
        int ans = 0;
        int remain = 0;
        for(int x : nums){
            if(remain + x <= m){
                remain = 0;
            }else{
                remain += x - m;
            }
            ans++;
        }
        ans += (remain + m - 1) / m;
        System.out.println(ans);
    }
}
