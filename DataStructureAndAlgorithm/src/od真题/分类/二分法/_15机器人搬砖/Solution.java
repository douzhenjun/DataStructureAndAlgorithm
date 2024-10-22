package od真题.分类.二分法._15机器人搬砖;

import java.util.Scanner;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-03-22
 **/
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        int[] w = new int[input.length];
        for(int i = 0; i < input.length; i++){
            w[i] = Integer.parseInt(input[i]);
        }
        System.out.println(getResult(w));
    }
    
    private static int getResult(int[] w){
        int n = w.length;
        if(n > 8){
            return -1;
        }else{
            //二分查找,找到最小的能量格,能在8小时之内搬完w[0]+...+w[n](n<=7)
            int l = 1, r = (int) 1e9;
            while(l < r){
                int mid = (l + r) / 2;
                if(check(w, mid)){
                    r = mid;
                }else{
                    l = mid + 1;
                }
            }
            return l;
        }
    }
    
    private static  boolean check(int[] w, int mid){
        int cnt = 0;//搬完所有仓库中的砖块所需的时间,假设每个仓库所需的时间是w[i]/mid,mid表示速度,
                    //也就是每小时补充的能量格
        for(int x : w){
            cnt += (x + mid - 1) / mid;
            if(cnt > 8){
                return false;
            }
        }
        return true;
    }
}
