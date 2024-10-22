package od真题.分类.硬骨头._39提取字符串中最长合法简单数学表达式.test;

import java.util.HashSet;
import java.util.Stack;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-03-24
 **/
public class Solution {

    Stack<Long> nums = new Stack<>();
    Stack<Character> ops = new Stack<>();
    HashSet<Character> opsSet = new HashSet<>();

    public void getResult(String str) {
        //初始化
        opsSet.add('+');
        opsSet.add('-');
        opsSet.add('*');


        int n = str.length();
        int maxLength = 0;
        long res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                String subStr = str.substring(i, j + 1);
                if (check(subStr) && j - i + 1 > maxLength) {
                    maxLength = j - i + 1;
                    res = calculate(subStr);
                }
            }
        }
        System.out.println(res);
    }

    private long calculate(String s) {
        int n = s.length();
        ops.clear();
        nums.clear();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            // 如果是数字，找到整个数字并压入数字栈
            if (Character.isDigit(c)) {
                int j = i;
                while (j < n && Character.isDigit(s.charAt(j))) j++;
                long x = Long.parseLong(s.substring(i, j));
                nums.push(x);
                i = j - 1;
            } else if (c != '*') {
                // 如果是运算符且不是乘法，清空运算符栈
                while (!ops.isEmpty()) eval();
                ops.push(c);
            } else {
                // 如果是乘法，清空运算符栈中的乘法运算符
                while (!ops.isEmpty() && ops.peek() == '*') eval();
                ops.push(c);
            }
        }
        // 清空剩余的运算符
        while (!ops.isEmpty() && nums.size() > 1) eval();
        return nums.isEmpty() ? -1 : nums.peek();
    }

    // 执行一次运算
    private long eval() {
        // 如果数字栈的大小小于 2，说明运算失败
        if (nums.size() < 2) return -1;
        long b = nums.pop();
        long a = nums.pop();
        char c = ops.pop();
        // 根据运算符执行相应的运算，并将结果压入数字栈
        if (c == '+') nums.push(a + b);
        else if (c == '-') nums.push(a - b);
        else nums.push(a * b);
        return 0;
    }

    private boolean check(String subStr) {
        int n = subStr.length();
        for (int i = 0; i < n; i++) {
            if (i < n - 1 && opsSet.contains(subStr.charAt(i)) && opsSet.contains(subStr.charAt(i + 1))) {
                return false;
            }
            if (!opsSet.contains(subStr.charAt(i)) && subStr.charAt(i) > '9' && subStr.charAt(i) < '0') {
                return false;
            }
        }
        return true;
    }
}
