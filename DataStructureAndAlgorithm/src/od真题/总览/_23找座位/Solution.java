package od真题.总览._23找座位;

import java.util.Scanner;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-03-23
 **/
public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int res = 0;
        
        String inStr = scanner.nextLine();
        char[] s = inStr.toCharArray();
        for(int i = 0; i < s.length; i++){
            if(s[i] == '0'){//如果有空位
                //空位左边是否也是空位
                boolean left = (i == 0 || s[i - 1] == '0');
                //空位右边是否也是空位
                boolean right = (i == s.length - 1 || s[i + 1] == '0');
                //如果左边有空位并且右边也有空位,那么这个位置就可以坐
                if(left && right){
                    res++;
                    s[i] = '1';
                    i++;
                }
            }
        }
        System.out.println(res);
    }
}
