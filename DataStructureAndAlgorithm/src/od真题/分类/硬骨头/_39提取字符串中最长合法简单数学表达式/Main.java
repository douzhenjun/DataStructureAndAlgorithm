package od真题.分类.硬骨头._39提取字符串中最长合法简单数学表达式;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-03-24
 **/
import java.util.*;

public class Main {
    // 保存数字的栈
    static Stack<Long> nums = new Stack<>();
    // 保存运算符的栈
    static Stack<Character> ops = new Stack<>();
    // 运算符的集合
    static Set<Character> st = new HashSet<>(Arrays.asList('+', '-', '*'));

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 从输入读取表达式字符串
        String s = scanner.nextLine();
        // 调用方法计算表达式的最大值
        long result = findMaxExpressionValue(s);
        // 输出结果
        System.out.println(result);
    }

    // 计算表达式的最大值
    static long findMaxExpressionValue(String s) {
        int n = s.length();
        nums.clear();
        ops.clear();

        long result = 0;
        int maxLength = 0;

        // 枚举所有可能的子串
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                // 获取子串
                String t = s.substring(i, j + 1);
                // 检查子串是否为有效表达式，并且长度是否大于当前最大长度
                if (check(t) && j - i + 1 > maxLength) {
                    maxLength = j - i + 1;
                    // 计算当前子串的值
                    result = calculate(t);
                }
            }
        }

        return result;
    }

    // 执行一次运算
    static long eval() {
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

    // 计算表达式的值
    static long calculate(String s) {
        int n = s.length();
        nums.clear();
        ops.clear();

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

    // 检查字符串是否为有效表达式
    static boolean check(String s) {
        int n = s.length();
        for (int i = 0; i < n; i++) {
            // 检查相邻的运算符是否合法
            if (i < n - 1 && st.contains(s.charAt(i)) && st.contains(s.charAt(i + 1))) return false;
            // 检查非运算符字符是否合法
            if (!st.contains(s.charAt(i)) && (s.charAt(i) < '0' || s.charAt(i) > '9')) return false;
        }
        return true;
    }
}

