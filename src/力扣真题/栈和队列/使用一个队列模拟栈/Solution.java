package 力扣真题.栈和队列.使用一个队列模拟栈;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description
 * 只使用一个队列,在入栈操作的时候我们每加入一个元素就将该队列中的元素重新排列
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
            System.out.printf("%2d",stack.top());
        }
        System.out.println();
        int index = 0;
        while(!stack.empty()){
            result[index++] = stack.pop();
        }
        System.out.println(Arrays.toString(result));
    }
}

class MyStack{
    Queue<Integer> queue = new LinkedList<>();
    
    public void push(int value){
        queue.offer(value);
        int size = queue.size();
        while(size-- > 1){
            queue.offer(queue.poll());
        }
    }
    public int top(){
        return queue.peek();
    }
    public int pop(){
        return queue.poll();
    }
    public boolean empty(){
        return queue.isEmpty();
    }
}
