package od真题.分类.模拟._10拼接url;

import java.util.Scanner;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-03-22
 **/
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        
        String pre = "";
        String suf = "";
        boolean flag = true;
        
        for(char ch : s.toCharArray()){
            if(ch == ','){
                flag = false;
                continue;
            }else if(flag){
                pre += ch;
            }else{
                suf += ch;
            }
        }
        
        if(pre.isEmpty()){
            pre = "/";
        }
        if(suf.isEmpty()){
            suf = "/";
        }
        if(pre.charAt(pre.length() - 1) != '/'){
            pre += '/';
        }
        if(suf.charAt(0) != '/'){
            suf = '/' + suf;
        }
        if(pre.charAt(pre.length() - 1) == '/' && suf.charAt(0) == '/'){
            pre = pre.substring(0, pre.length() - 1);
        }
        String res = pre + suf;
        System.out.println(res);
    }
}
