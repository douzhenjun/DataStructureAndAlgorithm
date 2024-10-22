package od真题.总览._24转盘寿司;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-03-23
 **/
public class Solution {
    public static void main(String[] args) {
        
    }
    
    @Test
    public void test01(){
        int[] prices = {3, 15, 6, 14};
        List<Integer> list = Arrays.stream(getResult(prices)).boxed().collect(Collectors.toList());
        System.out.println(list);
    }
    private static int[] getResult(int[] prices){
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[prices.length];
        for(int i = 0; i < prices.length; i++){
            result[i] = prices[i];
        }
        boolean[] used = new boolean[prices.length];//标记数组是否已经被修改
        stack.push(0);
        for(int j = 1; j < 2 * prices.length; j++){
            while(!stack.isEmpty() && prices[j % prices.length] < prices[stack.peek()]){
                if(!used[stack.peek()]) {
                    result[stack.peek()] += prices[j % prices.length];
                    used[stack.peek()] = true;
                }
                stack.pop();
            }
            stack.push(j % prices.length);
        }
        return result;
    }
}
