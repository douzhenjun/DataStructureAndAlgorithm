package 力扣真题.栈和队列.单调栈.下一个更大元素I.test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-03-18
 **/
public class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];
        Arrays.fill(result, -1);
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for(int i = 0 ; i < nums1.length; i++){
            map.put(nums1[i], i);
        }
        stack.push(nums2[0]);
        for(int j = 1; j < nums2.length; j++){
            while(!stack.isEmpty() && nums2[j] > stack.peek()){
                if(map.containsKey(stack.peek())){
                    result[map.get(stack.peek())] = nums2[j];
                }
                stack.pop();
            }
            stack.push(nums2[j]);
        }
        return result;
    }
}
