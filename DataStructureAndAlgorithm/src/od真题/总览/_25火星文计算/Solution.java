package od真题.总览._25火星文计算;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-03-23
 **/
public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();  // 读取一行字符串
        List<Integer> a = new ArrayList<>();  // 保存数字的数组
        List<Integer> op = new ArrayList<>();  // 保存操作类型的数组
        String now = "";  // 保存当前读取的数字字符串
        // 遍历字符串的每个字符
        for (char x : s.toCharArray()) {
            if (Character.isDigit(x)) {  // 如果是数字
                now += x;  // 追加到当前数字字符串
            } else {
                if (x == '#') {
                    op.add(1);  // 如果是 '#'，表示加法操作
                } else {
                    op.add(0);  // 否则表示数字入栈操作
                }
                a.add(Integer.parseInt(now));  // 将当前数字字符串转为数字并存入数组
                now = "";  // 重置当前数字字符串
            }
        }

        a.add(Integer.parseInt(now));  // 处理最后一个数字字符串

        int n = op.size();
        int i = 0;
        List<Integer> b = new ArrayList<>();

        // 进行一系列操作
        while (i < n) {
            if (op.get(i) == 1) {
                int x = a.get(0);
                int y = a.get(1);
                int z = 4 * x + 3 * y + 2;
                a.remove(0);
                a.remove(0);
                a.add(0, z);
                i += 1;
            } else {
                b.add(a.remove(0));
                i += 1;
            }
        }

        b.addAll(a);  // 将 b 数组中的元素和 a 数组连接起来

        int m = b.size();
        for (i = 1; i < m; i++) {
            int x = b.get(i - 1);
            int y = b.get(i);
            int z = 2 * x + y + 3;
            b.set(i, z);
        }

        System.out.println(b.get(m - 1));  // 输出最后一个元素
    }
}

