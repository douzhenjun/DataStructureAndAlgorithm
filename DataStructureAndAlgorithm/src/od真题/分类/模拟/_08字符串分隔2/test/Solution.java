package od真题.分类.模拟._08字符串分隔2.test;

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
        String str = sc.next();//读取输入流的下一个单词,以空格作为默认的分隔符
//        String str = sc.nextLine(); //这么写会以一行文本作为输入,以回车符结束
        System.out.println(getResult(k, str));
    }
    
    private static String getResult(int k, String str){
        String[] arr = str.split("-");
        StringJoiner sj = new StringJoiner("-");
        sj.add(arr[0]);
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < arr.length; i++){
            sb.append(arr[i]);
        }
        String newStr = sb.toString();
        for(int i = 0; i < newStr.length(); i+=k){
            String strs = newStr.substring(i, Math.min(i+k, newStr.length()));
            sj.add(convert(strs));
        }
        return sj.toString();
    }
    
    private static String convert(String str){
        int lowerCount = 0;
        int upperCount = 0;
        char[] array = str.toCharArray();
        for(int i = 0; i < array.length; i++){
            if('a' <= array[i] && array[i] <= 'z'){
                lowerCount++;
            }
            if('A' <= array[i] && array[i] <= 'Z'){
                upperCount++;
            }
        }
        if(lowerCount > upperCount){
            return str.toLowerCase();
        }else if(upperCount > lowerCount){
            return str.toUpperCase();
        }else{
            return str;
        }
    }
}
