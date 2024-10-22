package od真题.总览._23找座位;

import java.util.Scanner;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-03-23
 **/
public class Solution2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int res = 0;

        String inStr = scanner.nextLine();
        char[] s = inStr.toCharArray();
        if(s[0] == '0' && s[1] == '0'){
            s[0] = '1';
            res++;
        }
        for(int i = 1; i < s.length - 1; i++){
            if(s[i] == '0'){//如果有空位
                if(s[i - 1] == '0' && s[i + 1] == '0'){
                    s[i] = '1';
                    res++;
                }
            }
        }
        if(s[s.length-1] == '0' && s[s.length-2] == '0'){
            s[s.length-1] = '1';
            res++;
        }
        System.out.println(res);
    }
}
