package od真题.总览._13连续字母长度;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-03-22
 **/
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int k = sc.nextInt();
        Integer[] cnts = new Integer[26];
        Arrays.fill(cnts, 0);
        int n = s.length();
        for (int i = 0; i < n; i++) {
            int j = i;
            while (j < n && s.charAt(j) == s.charAt(i)) {
                j++;
            }
            int c = s.charAt(i) - 'A';
            cnts[c] = Math.max(cnts[c], j - i);
            i = j - 1;
        }
        Arrays.sort(cnts, Collections.reverseOrder());
        if (k > 26 || cnts[k - 1] == 0) {
            System.out.println("-1");
        } else {
            System.out.println(cnts[k - 1]);
        }
    }
}
