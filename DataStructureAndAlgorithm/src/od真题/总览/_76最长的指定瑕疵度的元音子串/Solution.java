package od真题.总览._76最长的指定瑕疵度的元音子串;

import java.util.Scanner;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-04-03
 **/
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        String s = sc.next();
        boolean[] f = new boolean[s.length()];
        for (int i = 0; i < s.length(); i++) {
            f[i] = isy(s.charAt(i));
        }
        int L = 0, R = 0, ans = 0, cnt = 0;//初始化双指针L和R,结果ans,以及辅音个数cnt
        while (R < s.length()) {
            if (!f[R]) {
                cnt++;
            } else {
                while (cnt > k || !f[L]) {
                    if (!f[L]) {
                        cnt--;
                    }
                    L++;
                }
                if (cnt == k) {
                    ans = Math.max(ans, R - L + 1);
                }
            }
            R++;
        }
        System.out.println(ans);
    }
    
    //判断ch是否是元音字母
    static boolean isy(char ch){
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'
                || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U';
    }
}
