package od真题.总览._01字符串变换最小字符串;

import java.util.Scanner;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-03-22
 **/
public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int indexMin = -1;
        int min = Integer.MAX_VALUE;
        int index = 0;
        while (str.charAt(index) <= str.charAt(index + 1) && index < str.length() - 1) {
            index++;
        }
        int index2 = index + 1;
        //所有的字符都按照字典序排列
        if (index2 >= str.length()) {
            System.out.println(str);
        }
        //并非完全按照字典序排序,则从index2出发找到字典序最小的那个字母，标记它的下标和值
        for (int i = index2; i < str.length(); i++) {
            if (str.charAt(i) - 'a' <= min) {
                indexMin = i;
                min = str.charAt(i);
            }
        }
        char[] array = str.toCharArray();
        for (int i = 0; i < array.length; i++) {
            if (array[indexMin] < array[i]) {
                char temp = array[i];
                array[i] = array[indexMin];
                array[indexMin] = temp;
                break;
            }
        }
        String str2 = new String(array);
        System.out.println(str2);
    }
}
