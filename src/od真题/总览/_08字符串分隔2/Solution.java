package od真题.总览._08字符串分隔2;

import java.util.Scanner;
import java.util.StringJoiner;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-03-22
 **/
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        String s = sc.next();
        System.out.println(getResult(k, s));
    }
    
    public static String getResult(int k, String s){
        String[] arr = s.split("-");//将字符串以"-"为分隔符分成若干个元素的数组
        StringJoiner sj = new StringJoiner("-");
        sj.add(arr[0]);//将第一个子串添加到sj对象中,以"-"作为分隔符
        //将剩余的子串首先拼接到一起形成一个新串,再对新串每K个一组添加到sj中
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < arr.length; i++){
            sb.append(arr[i]);
        }
        String newStr = sb.toString();
        for(int i = 0; i < newStr.length(); i++){
            //将每个子串再按照k个一组分隔
            String subStr = newStr.substring(i, Math.min(i+k, newStr.length()));
            sj.add(convert(subStr));
        }
        return sj.toString();
    }
    
    public static String convert(String str){
        int lowerCount = 0;
        int upperCount = 0;
        for(int i = 0;i < str.length(); i++){
            char c = str.charAt(i);
            if(c >= 'a' && c <= 'z'){
                lowerCount++;
            }else if(c >= 'A' && c <= 'Z'){
                upperCount++;
            }
        }
        if(lowerCount > upperCount){
            return str.toLowerCase();
        }else if(lowerCount < upperCount){
            return str.toUpperCase();
        }else{
            return str;
        }
    }
}
