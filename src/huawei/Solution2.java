package huawei;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Stack;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-05-23
 **/
public class Solution2 {
   static HashSet<Character> left = new HashSet<>();
   static HashSet<Character> right = new HashSet<>();
   static Map<Character, Character> map = new HashMap<>();
    static{
        left.add('(');
        left.add('[');
        left.add('{');
        right.add(')');
        right.add(']');
        right.add('}');
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
    }
    

    public static boolean func(String s) {
        if(s.length() == 0){
            return true;
        }
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < chars.length; i++) {
            if(left.contains(chars[i])){
                stack.push(chars[i]);
            }else if(right.contains(chars[i])){
                if(!stack.isEmpty() && map.get(stack.peek()).equals(chars[i])){
                    stack.pop();
                }else{
                    return false;
                }
            }else{
                return false;
            }
        }
        if(!stack.isEmpty()){
            return false;
        }
        return true;
    }
}
