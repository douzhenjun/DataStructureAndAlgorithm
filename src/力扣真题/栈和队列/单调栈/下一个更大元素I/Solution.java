package 力扣真题.栈和队列.单调栈.下一个更大元素I;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @Description
 * 定义一个res数组，初始化的值为-1
 * 定义一个Map对象，用来遍历nums1中的所有元素，将nums1[i]作为key，i作为value存入
 * 定义一个Stack对象，用来保存所有不大于栈顶元素的nums2的下标，如果栈为空，那么保存当前的i即可，i遍历nums2
 * 
 * 遍历nums2,一开始栈为空，stack.push(nums2[0])
 * 接下来比较nums2[1]和nums2[0]哪个大，如果前者大，再判断nums2【0】是否在nums1中出现过，如果出现过,说明
 * nums2[1]就是我们要找的第一个超过nums1[i]的元素
 * @Author douzhenjun
 * @DATE 2024-03-17
 **/
public class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] res = new int[nums1.length];
        Stack<Integer> stack = new Stack<>();
        
        for(int i = 0; i < nums1.length; i++){
            map.put(nums1[i], i);
        }
        Arrays.fill(res, -1);
        for(int i = 0 ; i < nums2.length; i++){
            while(!stack.isEmpty() && nums2[i] > nums2[stack.peek()]){
                int pre = nums2[stack.peek()];
                if(map.containsKey(pre)){
                    res[map.get(pre)] = nums2[i];
                }
                stack.pop();
            }
            stack.push(i);
        }
        return res;
    }
}
