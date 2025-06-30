package od真题.分类.模拟._04最大坐标值;

import java.util.Scanner;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-03-22
 **/
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        int[] w = new int[n];
        for(int i = 0; i < n; i++){
            w[i] = sc.nextInt();
        }
        int res = 0;                    //最大的坐标值
        int cur = 0;                    //当前位置
        for(int i = 0; i < n; i++){
            if(w[i] == x && x != 0){
                cur += x / Math.abs(x);//向幸运数所在的方向加1
            }
            cur += w[i];
            res = Math.max(res, cur);//更新最大坐标值
        }
        System.out.println(res);
    }
}
