package od真题.分类.硬骨头._70解密犯罪的时间;

import java.util.Scanner;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-03-29
 **/
public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String stime = scanner.next();
        int pos = stime.indexOf(":");

        //记录已经出现的数字
        boolean[] exists = new boolean[10];
        for (char c : stime.toCharArray()) {
            if (Character.isDigit(c)) {
                exists[c - '0'] = true;
            }
        }
        int hour = 0;
        int minute = 0;
        int d = Integer.MAX_VALUE;
        //原始时间
        int times = Integer.parseInt(stime.substring(0, pos)) * 60 + Integer.parseInt(stime.substring(pos + 1));
        //枚举所有时间,找到下一个距离当前时间最近的时间
        //如果时间点中有字符未出现, 则不考虑该时间点, 因为该时间点已经不可能是答案了
        for (int h = 0; h < 24; h++) {
            if (!exists[h % 10] || !exists[h / 10]) {
                continue;
            }
            for (int m = 0; m < 60; m++) {
                int curTimes = h * 60 + m;
                if (!exists[m % 10] || !exists[m / 10] || curTimes == times) {
                    continue;
                }
                int curD = (curTimes > times) ? curTimes - times : 24 * 60 - (times - curTimes);
                if (curD < d) {
                    hour = h;
                    minute = m;
                    d = curD;
                }
            }
        }
        System.out.printf("%02d%02d%n", hour, minute);
    }
}
