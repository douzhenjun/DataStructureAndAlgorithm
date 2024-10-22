package od真题.分类.模拟._10拼接url.test;

import java.util.Scanner;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-03-22
 **/
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true){
            String str = sc.nextLine();
            StringBuilder pre = new StringBuilder();
            StringBuilder suf = new StringBuilder();
            char[] array = str.toCharArray();
            boolean flag = false;
            for(char c : array){
                if(c == ','){
                    flag = true;
                    continue;
                }else if(!flag){
                    pre.append(c);
                }else if(flag){
                    suf.append(c);
                }
            }
            if(pre.length() == 0){
                pre.append("/");
            }
            if(suf.length() == 0){
                suf.append("/");
            }
            if(suf.charAt(0) != '/'){
                String sufRes = "/" + suf;
                suf = new StringBuilder(sufRes);
            }
            if(pre.charAt(pre.length()-1) == '/' && suf.charAt(0) == '/'){
                pre.deleteCharAt(pre.length()-1);
            }
            String res = pre.toString() + suf.toString();
            System.out.println(res);
        }
        
    }
}
