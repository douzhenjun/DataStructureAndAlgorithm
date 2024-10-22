package 华为面试模拟题.接雨水;

import java.util.Stack;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-03-17
 **/
public class Solution2 {
    public int trap(int[] height){
        int size = height.length;
        if(size <= 2){
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        
        int sum = 0;
        for(int index = 1; index < size; index++){
            int stackTop = stack.peek();
            if(height[index] < height[stackTop]){
                stack.push(index);
            }else if(height[index] == height[stackTop]){
                stack.pop();
                stack.push(index);
            }else{
                int heightAtIdx = height[index];
                while(!stack.isEmpty() && (heightAtIdx > height[stackTop])){
                    int mid = stack.pop();
                    if(!stack.isEmpty()){
                        int left = stack.peek();
                        int h = Math.min(height[left], height[index]) - height[mid];
                        int w = index - left - 1;
                        int hold = h * w;
                        if(hold > 0){
                            sum += hold;
                        }
                        stackTop = stack.peek();
                    }
                }
                stack.push(index);
            }
        }
        return sum;
    }
}
