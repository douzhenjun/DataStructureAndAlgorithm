package 力扣真题.栈和队列.单调栈.每日温度;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Description 定义一个单调栈，用来保存当天的温度对应的天数(下标)
 * 入栈的原理如下:
 * 一开始将0入栈. 然后遍历温度列表,下标从1开始
 * 如果当天的温度大于栈顶的天数对应的温度,那么就将<当天-栈顶的天数>作为res中栈顶天数对应的结果
 * 将栈顶元素弹出. 这个比较过程是一个循环,除非栈为空或者栈顶元素对应的温度超过了当前天数对应的温度才停止弹出栈顶元素.
 * 这时候再将这时的温度对应的天数入栈.
 * 如果当天的温度小于等于栈顶元素对应的温度,或者栈为空,那么直接入栈即可.
 * @Author douzhenjun
 * @DATE 2024-03-17
 **/
public class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int lens = temperatures.length;
        int[] res = new int[lens];

        Deque<Integer> stack = new LinkedList<>();
        stack.push(0);
        for (int i = 1; i < lens; i++) {

            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                res[stack.peek()] = i - stack.peek();
                stack.pop();
            }
            stack.push(i);
            
        }
        return res;
    }
}
