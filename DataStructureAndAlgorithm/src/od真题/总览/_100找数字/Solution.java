package od真题.总览._100找数字;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-04-07
 **/
public class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();  // 输入整数 n
        List<Integer> w = new ArrayList<>();  // 存储二进制表示的数组

        // 将整数 n 转换为二进制表示，并存储到列表 w 中
        while (n > 0) {
            w.add(n % 2);
            n /= 2;
        }

        w.add(0);  // 在列表末尾添加一个前导0

        int m = w.size();  // 获取列表长度

        for (int i = 0; i < m; i++) {
            // 找到第一个01子串，进行交换操作
            if (i + 1 < m && w.get(i) == 1 && w.get(i + 1) == 0) {
                Collections.swap(w, i, i + 1);  // 使用 Collections 类交换列表中的元素

                int l = 0, r = i - 1;

                // 将低位中的1全部移动到最低位，0移动到最高位，以保证结果尽可能小
                while (l < r) {
                    while (l < r && w.get(l) == 1) {
                        l++;
                    }

                    while (l < r && w.get(r) == 0) {
                        r--;
                    }

                    if (l < r) {
                        // 使用 Collections 类交换列表中的元素
                        Collections.swap(w, l, r);
                        l++;
                        r--;
                    }
                }

                break;  // 跳出循环
            }
        }

        int res = 0;

        // 将二进制列表转换为十进制数
        for (int i = 0; i < m; i++) {
            if (w.get(i) == 1) {
                res += 1 << i;
            }
        }

        System.out.println(res);  // 输出结果
    }
}
