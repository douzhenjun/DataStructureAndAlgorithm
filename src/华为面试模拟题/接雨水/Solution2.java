package 华为面试模拟题.接雨水;

import java.util.Stack;

/**
 * @Description
 * 使用单调栈解决的接雨水问题
 * 从1开始到size-1遍历数组
 * 对于每个索引right,根据当前柱子的高度和栈顶柱子的高度执行下面的操作
 *  a.如果当前柱子高度小于栈顶柱子的高度,将当前索引压入栈中
 *  b.如果当前柱子高度等于栈顶,弹出栈顶元素,将当前索引压入栈中
 *  c.如果当前柱子高度大于栈顶,进入一个while循环,直到栈为空或者当前柱子高度小于等于栈顶高度
 *  在循环中弹出栈顶元素mid,计算雨水量公式为hold=(min(height[left],height[right])-height[mid])*(right-left-1)
 * @Author douzhenjun
 * @DATE 2024-03-17
 **/
public class Solution2 {
    public int trap(int[] height){
        int size = height.length;
        if(size <= 2){
            return 0;
        }
        
        /*
         * 定义一个单调栈,并将第一个柱子位置入栈
         */
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        
        /*
         * 如果柱子从左到右高度呈下降趋势,将这些柱子的位置入栈,如果出现高度相等的情况,将前面的位置替换成现在的
         * 因为相邻的柱子高度相等,左边的柱子不能够帮助接水(没有高度差)
         * 当接下来的柱子高度高于上一次的柱子高度时,就能够接水了,此时能够接的水就是中间柱子和左右两边较短的那根柱子的高度差
         * 乘以柱子位置的差值,这是一个循环过程,只要是当前柱子的高度比栈顶元素高,就可以接水,就计算一次接水量,同时将原来的栈顶元素出栈
         * 直到柱子的高度仍旧是剩下柱子当中最低的,等待下一次更高的柱子
         */
        int sum = 0;
        for(int right = 1; right < size; right++){
            int stackTop = stack.peek();
            if(height[right] < height[stackTop]){
                stack.push(right);
            }else if(height[right] == height[stackTop]){
                stack.pop();
                stack.push(right);
            }else{
                while(!stack.isEmpty() && (height[right] > height[stackTop])){
                    int mid = stack.pop();
                    if(!stack.isEmpty()){
                        int left = stack.peek();
                        int h = Math.min(height[left], height[right]) - height[mid];
                        int w = right - left - 1;
                        int hold = h * w;
                        if(hold > 0){
                            sum += hold;
                        }
                        stackTop = stack.peek();
                    }
                }
                stack.push(right);
            }
        }
        return sum;
    }
}
