package 力扣真题.动态规划.解码方法;

import java.util.Arrays;

/**
 * @Description 这里是对Solution2的优化, 减少重复的计算
 * @Author douzhenjun
 * @DATE 2024-07-03
 **/
public class Solution3 {
    public int numDecodings(String s) {
        int[] map = new int[s.length()];
        Arrays.fill(map, -1);
        return binaryTreeTraversal(s.toCharArray(), s.length(), map, 0);
    }

    private int binaryTreeTraversal(char[] chars, int length, int[] map, int index) {
        if (index >= length) {
            return 1;
        }
        //查看有没有计算过,如果计算过了就从map中取
        if (map[index] != -1) {
            return map[index];
        }

        //单个0是不构成字符的,要跳过,但两个数字比如10,20是可以构成字符的
        if (chars[index] == '0') {
            return 0;
        }

        int res = binaryTreeTraversal(chars, length, map, index + 1);
        if (index < length - 1 && (chars[index] == '1' || chars[index] == '2' && chars[index + 1] <= '6')) {
            res += binaryTreeTraversal(chars, length, map, index + 2);
        }
        //把计算的结果存储到res中
        map[index] = res;
        return res;
    }
}
