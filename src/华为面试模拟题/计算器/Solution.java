package 华为面试模拟题.计算器;

import java.util.HashSet;
import java.util.Stack;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-04-24
 **/
public class Solution {
    public int getValue(String expression) {
        Stack<Character> optionStack = new Stack<>();
        Stack<Integer> numStack = new Stack<>();
        //定义一个哈希集合
        HashSet<Character> set = new HashSet<>();
        set.add('+');
        set.add('-');
        set.add('*');
        set.add('/');

        char[] array = expression.toCharArray();
        int num = 0;
        for (int i = 0; i < array.length; i++) {
            if (set.contains(array[i])) {
                if ((array[i] == '*' || array[i] == '/') &&
                        (optionStack.peek() == '+' || optionStack.peek() == '-')) {

                } else {
                    if (numStack.size() > 1) {
                        int last = numStack.pop();
                        int first = numStack.pop();
                        char option = optionStack.pop();
                        int res = eval(first, last, option);
                        numStack.push(res);
                    }
                }
                numStack.push(num);
                optionStack.push(array[i]);
                num = 0;
            } else {
                num += num * 10 + (array[i] - '0');
                if(i == array.length - 1){
                    numStack.push(num);
                }
            }
        }
        while (!optionStack.isEmpty()) {
            int last = numStack.pop();
            int first = numStack.pop();
            char option = optionStack.pop();
            int res = eval(first, last, option);
            numStack.push(res);
        }
        return numStack.peek();
    }

    private int eval(int first, int last, char option) {
        if (option == '+') {
            return first + last;
        } else if (option == '-') {
            return first - last;
        } else if (option == '*') {
            return first * last;
        } else {
            return first / last;
        }
    }
}
