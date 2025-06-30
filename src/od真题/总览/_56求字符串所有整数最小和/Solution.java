package od真题.总览._56求字符串所有整数最小和;

import java.util.Scanner;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-03-26
 **/
public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long res = 0;
        String s = scanner.nextLine();
        int n = s.length();
        for(int i = 0; i < n; i++){
            //非数字或者非'-'跳过
            if(!Character.isDigit(s.charAt(i)) && s.charAt(i) != '-'){
                continue;
            }
            //如果遇到-,并且其后有数字,获得全部的数字
            if(s.charAt(i) == '-'){
                int j = i + 1;
                long num = 0;
                while(j < n && Character.isDigit(s.charAt(j))){
                    num = num * 10 + s.charAt(j) - '0';
                    j++;
                }
                res -= num;
                i = j - 1;
            }else{
                res += s.charAt(i) - '0';
            }
        }
        System.out.println(res);
    }
}
