package od真题.总览._38求最多可以派出多少支团队;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-03-24
 **/
public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        
        int[] w = new int[n];
        for(int i = 0; i < n; i++){
            w[i] = scanner.nextInt();
        }
        int target = scanner.nextInt();
        Arrays.sort(w);
        
        int res = 0;
        int l = 0, r = n-1;
        while(l < r){
            if(w[r] >= target){
                res++;
                r--;
            }else if(w[l] + w[r] >= target){
                l++;
                r--;
                res++;
            }else{
                l++;
            }
        }
        if(l == r && w[l] >= target){
            res++;
        }
        System.out.println(res);
    }
}
