package od真题.总览._25火星文计算.test;

import java.util.Stack;

/**
 * @Description
 * 
 * x # y = 4 * x + 3 * y + 2
 * x $ y = 2 * x + y + 3
 * #的运算优先级还高于$
 * @Author douzhenjun
 * @DATE 2024-03-23
 **/
public class Solution {
    public int getResult(String str){
        Stack<Integer> nums = new Stack<>();//暂存操作数
        Stack<Character> operator = new Stack<>();//暂存操作符
        char[] charArray = str.toCharArray();
        String strings = "";
        for(int i = 0; i < charArray.length; i++){
            if(charArray[i] == '#' || charArray[i] == '$'){
                nums.push(Integer.parseInt(strings));
                while(!operator.isEmpty()){
                    if(charArray[i] == '#' && operator.peek() == '$'){
                        break;
                    }
                    char op = operator.pop();
                    int y = nums.pop();
                    int x = nums.pop();
                    int z = calculate(op, x, y);
                    nums.push(z);
                }
                operator.push(charArray[i]);
                strings = "";
            }else{
                strings += charArray[i];
                if(i == charArray.length - 1){
                    nums.push(Integer.parseInt(strings));
                }
            }
        }
        while(!operator.isEmpty()){
            char op = operator.pop();
            int y = nums.pop();
            int x = nums.pop();
            int z = calculate(op, x, y);
            nums.push(z);
        }
        return nums.pop();
    }
    
    private int calculate(char s, int x, int y){
        if(s == '#'){
            return 4 * x +3 * y + 2;
        }else if(s == '$'){
            return 2 * x + y + 3;
        }else{
            return 0;
        }
    }
}
