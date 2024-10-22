package od真题.总览._42字符串序列判定;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-03-25
 **/

import java.util.*;

public class Solution2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String searchString = scanner.next();
        String targetString = scanner.next();
        int targetLength = targetString.length();
        int currentIndex = 0;
        int position = -1;
        for (int i = 0; i < targetLength; i++) {
            if (targetString.charAt(i) == searchString.charAt(currentIndex)) {
                currentIndex++;
            }
            if (currentIndex == searchString.length()) {
                position = i;
                break;
            }
        }
        System.out.println(position);
    }
}

