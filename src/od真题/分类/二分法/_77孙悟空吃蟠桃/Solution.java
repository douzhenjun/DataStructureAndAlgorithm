package od真题.分类.二分法._77孙悟空吃蟠桃;

import java.util.Scanner;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-04-03
 **/
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        int h = Integer.parseInt(sc.nextLine());
        int n = input.length;
        int[] w = new int[n];
        for(int i = 0; i < n; i++){
            w[i] = Integer.parseInt(input[i]);
        }
        if(n > h){
            System.out.println(0);
        }else{
            int l = 1;
            int r = (int)1e9;
            while(l < r){
                int mid = l + (r - 1) / 2;
                if(check(w, h, mid)){
                    r = mid;
                }else{
                    l = mid + 1;
                }
            }
            System.out.println(l);
        }
    }
    
    static boolean check(int[] w, int h, int x){
        int cnt = 0;
        for(int num : w){
            cnt += (num + x - 1) / x;
            if(cnt > h){
                return false;
            }
        }
        return true;
    }
}
