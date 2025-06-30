package od真题.分类.排序._20字符串筛选排序;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-03-23
 **/
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int k = sc.nextInt();
        String s1 = s;
        
        //将字符串转成字符数组再排序
        char[] charArray = s1.toCharArray();
        Arrays.sort(charArray);
        s1 = new String(charArray);
        
        //获取字符串长度
        int n = s.length();
        //确保k不超过字符串长度
        k = Math.min(k, n);
        //获取排序后的第k个字符
        char ch = s1.charAt(k-1);
        
        //遍历原字符串,找到第一个与ch相等的字符的下标并输出
        for(int i = 0; i < n; i++){
            if(s.charAt(i) == ch){
                System.out.println(i);
                break;
            }
        }
    }
}
