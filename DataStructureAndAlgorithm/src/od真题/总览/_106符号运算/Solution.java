package od真题.总览._106符号运算;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;


/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-04-08
 **/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> num = new Stack<>();
        Stack<Character> op = new Stack<>();
        String s = br.readLine();
        int len = s.length();
        Map<Character, Integer> map = new HashMap<>();
        map.put('+', 1);
        map.put('-', 1);
        map.put('*', 2);
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                continue;
            }
            if (Character.isDigit(c)) {
                int x = 0, j = i;
                while (j < len && Character.isDigit(s.charAt(j))) {
                    x = x * 10 + s.charAt(j++) - '0';
                    num.push(x);
                    i = j - 1;
                }
            } else if (s.charAt(i) == '(') {
                op.push(s.charAt(i));
            } else if (s.charAt(i) == ')') {
                while (op.peek() != '(') {
                    eval(num, op);
                }
                op.pop();
            } else if (op.isEmpty()) {
                op.push(s.charAt(i));
            } else {//在这里多一个判断,因为优先级中并没有存储左括号的优先级,故map会产生空指针异常
                while (!op.isEmpty() && op.peek() != '(' && map.get(op.peek()) >= map.get(s.charAt(i))) {
                    eval(num, op);
                }
                op.push(s.charAt(i));
            }
        }
        while (op.size() > 0) {
            eval(num, op);
        }
        System.out.print(num.peek());
    }

    public static void eval(Stack<Integer> num, Stack<Character> op) {
        int num1 = num.pop();
        int num2 = num.pop();
        char x = op.pop();
        if (x == '*') {
            num.push(num2 * num1);
        } else if (x == '+') {
            num.push(num2 + num1);
        } else if (x == '-') {
            num.push(num2 - num1);
        }
    }
}
