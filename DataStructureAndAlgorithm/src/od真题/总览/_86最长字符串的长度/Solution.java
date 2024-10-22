package od真题.总览._86最长字符串的长度;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-04-04
 **/
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        int n = s.length();
        s += s;
        Queue<Integer>[] pre = new Queue[1 << 3];
        for (int i = 0; i < (1 << 3); i++) {
            pre[i] = new LinkedList<>();
        }
        pre[0].offer(-1);
        int x = 0, ans = 0;
        for (int i = 0; i < 2 * n; i++) {
            if (s.charAt(i) == 'l') {
                x ^= 1;
            } else if (s.charAt(i) == 'o') {
                x ^= 2;
            } else if (s.charAt(i) == 'x') {
                x ^= 4;
            }
            Queue<Integer> q = pre[x];
            q.offer(i);
            while (i - q.peek() > n) {
                q.poll();
            }
            ans = Math.max(ans, i - q.peek());
        }
        System.out.println(ans);
    }
}
