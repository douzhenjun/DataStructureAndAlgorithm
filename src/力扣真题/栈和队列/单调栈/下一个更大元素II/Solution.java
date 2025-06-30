package 力扣真题.栈和队列.单调栈.下一个更大元素II;

import java.util.Arrays;
import java.util.Stack;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-03-17
 **/
public class Solution {
    public int[] nextGreaterElements(int[] nums){
        if(nums == null || nums.length <= 1){
            return new int[]{-1};
        }
        int size = nums.length;
        int[] result = new int[size];
        Arrays.fill(result, -1);
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < 2*size; i++){
            while(!st.empty() && nums[i % size] > nums[st.peek()]){
                result[st.peek()] = nums[i % size];
                st.pop();
            }
            st.push(i%size);
        }
        return result;
    }
}
