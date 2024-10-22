package od真题.分类.模拟._03密码解密.test;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-03-22
 **/
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Deque<Character> deque = new LinkedList<>();
        String str = sc.nextLine();
        char[] chars = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < chars.length; i++){
            if(chars[i] == '*'){
                while(deque.size() > 2){
                    char ch = deque.poll();
                    sb.append(change(ch));
                }
                char a = deque.poll();
                char b = deque.poll();
                sb.append(change(a * 10 + b));
            }else{
                deque.offer(chars[i]);
            }
        }
    }
    
    static char change(int x){
        return (char)('a' + x - 1);
    }
}
