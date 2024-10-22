package 力扣真题.栈和队列.使用队列模拟栈;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description
 * 定义两个队列模拟栈结构，并封装入栈，出栈，获取栈顶元素以及判断栈是否为空这四个方法。
 * @Author douzhenjun
 * @DATE 2024-01-27
 **/
public class Solution {
    public static void main(String[] args) {
        MyStack stack = new MyStack();
        int[] nums = {1, 2, 3, 4};
        int[] result = new int[4];
        for(int i = 0; i < nums.length; i++){
            stack.push(nums[i]);
            System.out.printf("%2d",stack.peek());
        }
        System.out.println();
        int index = 0;
        while(!stack.empty()){
            result[index++] = stack.pop();
        }
        System.out.println(Arrays.toString(result));
    }
}

//考虑使用Queue类
class MyStack{
    Queue<Integer> queue1 = new LinkedList<>();
    Queue<Integer> queue2 = new LinkedList<>();
    
    public void push(int value){
        //新增当前的元素到queue2
        queue2.offer(value);
        //将queue1中的元素新增到辅助队列queue2中
        while(!queue1.isEmpty()){
            queue2.offer(queue1.poll());
        }
        //交换queue1和queue2
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }
    
    public int peek(){
        return queue1.peek();
    }
    
    public int pop(){
        return queue1.poll();
    }
    
    public boolean empty(){
        return queue1.isEmpty();
    }
}
