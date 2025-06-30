package od真题.总览._88查询文本段个数;

import java.util.Scanner;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-04-04
 **/
public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder a = new StringBuilder();

        // 循环输入，将每行的内容拼接到字符串 a 中
        while (true) {
            try {
                String s = scanner.nextLine();
                a.append(s);
            } catch (Exception e) {
                break;
            }
        }

        // 去除字符串中的空格和制表符
        a = new StringBuilder(a.toString().replace(" ", "").replace("\t", ""));

        // 使用分号 ; 分割字符串
        String[] b = a.toString().split(";");

        int cnt = 0;
        // 统计分割后非空字符串的数量
        for (String x : b) {
            if (x.length() > 0) {
                cnt += 1;
            }
        }

        System.out.println(cnt);
    }
}


