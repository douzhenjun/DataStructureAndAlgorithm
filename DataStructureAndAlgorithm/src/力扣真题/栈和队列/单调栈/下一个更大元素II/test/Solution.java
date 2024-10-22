package 力扣真题.栈和队列.单调栈.下一个更大元素II.test;

import java.util.Arrays;
import java.util.Stack;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-03-18
 **/
public class Solution {
    public int[] nextGreaterElements(int[] nums){
        if(nums == null || nums.length <= 1){
            return new int[]{-1};
        }
        int[] result = new int[nums.length];
        Arrays.fill(result, -1);
        int size = nums.length;
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for(int i = 1; i < 2 * size; i++){
            while(!stack.isEmpty() && nums[i % size] > nums[stack.peek()]){
                result[stack.peek()] = nums[i % size];
                stack.pop();
            }
            stack.push(i % size);
        }
        return result;
    }
}
