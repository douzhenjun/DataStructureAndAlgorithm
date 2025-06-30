package 华为面试模拟题.删除字符串中的所有相邻重复项;

import java.util.Stack;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-04-24
 **/
public class Solution {
    public String removeDuplicates(String s) {
        Stack<String> stack = new Stack<>();
        Stack<String> helpStack = new Stack<>();
        String result = "";
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) - 'a' < 0 || s.charAt(i) - 'z' > 0){
                return "-1";
            }
            if(stack.isEmpty() || !String.valueOf(s.charAt(i)).equals(stack.peek())){
                stack.push(String.valueOf(s.charAt(i)));
            }else{
                stack.pop();
            }
        }
        while(!stack.isEmpty()){
            helpStack.push(stack.pop());
        }
        while(!helpStack.isEmpty()){
            result += helpStack.pop();
        }
        return result;
    }
}
