package od真题.总览._64靠谱的车;

import java.util.Scanner;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-03-27
 **/
public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String w = scanner.next();
        int n = w.length();
        long ans = 0;
        for (int i = 0; i < n; i++) {
            int cost = Character.getNumericValue(w.charAt(i));
            if (Character.getNumericValue(w.charAt(i)) > 4) {
                cost -= 1;
            }
            for (int j = n - i - 1; j > 0; j--) {
                cost *= 9;
            }
            ans += cost;
        }
        System.out.println(ans);
    }
}
