package od真题.总览._78部门人力分配;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-04-03
 **/
public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();//开发时间,单位为月,每月最多有两个需求
        
        scanner.nextLine();
        
        String[] wInput = scanner.nextLine().split(" ");
        int n = wInput.length;
        
        int[] w = new int[n];//每个需求工作量大小,需求量为n
        for(int i = 0; i < n; i++){
            w[i] = Integer.parseInt(wInput[i]);
        }
        Arrays.sort(w);
        int l = w[n - 1];
        int r = (int) 1e9;
        while(l < r){
            int mid = (l + r) / 2;
            if(check(w, m, mid)){
                r = mid;
            }else{
                l = mid + 1;
            }
        }
        System.out.println(l);
    }
    
    static boolean check(int[] w, int m, int x){
        int cnt = 0;
        int l = 0;
        int r = w.length - 1;
        
        while(l <= r){
            if(w[l] + w[r] <= x){
                l++;
                r--;
            }else{
                r--;
            }
            cnt++;
        }
        return cnt <= m;
    }
}
