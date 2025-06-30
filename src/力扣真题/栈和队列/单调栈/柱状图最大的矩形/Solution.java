package 力扣真题.栈和队列.单调栈.柱状图最大的矩形;

import java.util.Stack;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-03-18
 **/
public class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();
        //数组扩容，在头和尾各加入一个元素
        int[] newHeights = new int[heights.length + 2];
        newHeights[0] = 0;
        newHeights[newHeights.length - 1] = 0;
        for (int index = 0; index < heights.length; index++) {
            newHeights[index + 1] = heights[index];
        }
        heights = newHeights;
        st.push(0);
        int result = 0;

        /*
         * 和接雨水类似不过情况相反,如果后面的柱子比前面的柱子高将位置入栈
         * 相等的情况替换掉,如果开始出现后面的柱子比前面的柱子低的情况,则将上一次的柱子出栈
         * 计算面积为
         */
        for (int right = 1; right < heights.length; right++) {
            if (heights[right] > heights[st.peek()]) {
                st.push(right);
            } else if (heights[right] == heights[st.peek()]) {
                st.pop();
                st.push(right);
            } else {
                while (heights[right] < heights[st.peek()]) {
                    int mid = st.pop();
                    int left = st.peek();
                    int w = right - left - 1;
                    int h = heights[mid];
                    result = Math.max(result, w * h);
                }
                st.push(right);
            }
        }
        return result;
    }
}
