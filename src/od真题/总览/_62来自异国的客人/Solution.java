package od真题.总览._62来自异国的客人;

import java.util.Scanner;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-03-27
 **/
public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();//十进制位数字
        int n = scanner.nextInt();//客人的幸运数字
        int m = scanner.nextInt();//表示客人所在的国度的进制数
        int ans = 0;
        while(k > 0){
            ans += k % m == n ? 1 : 0;
            k /= m;
        }
        System.out.println(ans);
    }
}
