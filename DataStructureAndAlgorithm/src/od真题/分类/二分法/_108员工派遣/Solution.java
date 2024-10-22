package od真题.分类.二分法._108员工派遣;

import java.util.Scanner;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-04-09
 **/
public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long x, y, cntx, cnty;
        x = scanner.nextLong();
        y = scanner.nextLong();
        cntx = scanner.nextLong();
        cnty = scanner.nextLong();
        binarySearch(1, (long)Math.pow(10, 18), x, y, cntx, cnty);
    }
    
    public static boolean check(long k, long x, long y, long cntx, long cnty){
        long a = k / x - k / (x * y);//只被x整除不被y整除
        long b = k / y - k / (x * y);//只被y整除不被x整除
        long c = k / (x * y);//同时被x,y整除
        long d = k - a - b - c;//不被x和y整除
        return d >= Math.max(0, cntx - b) + Math.max(0, cnty - a);
    }
    
    public static void binarySearch(long l, long r, long x, long y, long cntx, long cnty){
        while(l < r){
            long mid = l + (r - l) / 2;
            if(check(mid, x, y, cntx, cnty)){
                r = mid;
            }else{
                l = mid + 1;
            }
        }
        System.out.println(l);
    }
}
