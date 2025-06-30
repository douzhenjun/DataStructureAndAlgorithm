package od真题.分类.模拟._07环中最长子串;

import java.util.Scanner;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-03-22
 **/
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int n = s.length();
        int res = n; 
        int num = 0;
        for(int i = 0; i < n; i++){
            if(s.charAt(i) == 'o'){
                num++;
            }
        }
        if(num % 2 == 1){
            res--;
        }
        System.out.println(res);
    }
}
