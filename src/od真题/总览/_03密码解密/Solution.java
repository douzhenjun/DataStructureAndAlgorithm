package od真题.总览._03密码解密;

import java.util.LinkedList;
import java.util.Queue;
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
        Queue<Integer> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (ch == '*') {
                while (q.size() > 2) {
                    int c = q.poll();
                    sb.append(change(c));
                }
                int x = q.poll();
                int y = q.poll();
                sb.append(change(x * 10 + y));
            }else{
                q.offer(ch - '0');
            }
        }
        System.out.println(sb.toString());
    }

    static char change(int x) {
        return (char) ('a' + x - 1);
    }
}
