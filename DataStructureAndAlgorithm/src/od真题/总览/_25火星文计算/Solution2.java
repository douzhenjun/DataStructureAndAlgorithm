package od真题.总览._25火星文计算;

import java.util.Scanner;
import java.util.Stack;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-03-23
 **/
public class Solution2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        System.out.println(getResult(s));
    }

    public static int getResult(String str){
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

    private static int calculate(char s, int x, int y){
        if(s == '#'){
            return 4 * x +3 * y + 2;
        }else if(s == '$'){
            return 2 * x + y + 3;
        }else{
            return 0;
        }
    }
}
