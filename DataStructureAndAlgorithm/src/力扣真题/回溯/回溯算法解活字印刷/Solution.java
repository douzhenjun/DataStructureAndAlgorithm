package 力扣真题.回溯.回溯算法解活字印刷;

import java.util.Arrays;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-08-26
 **/
public class Solution {
    public int numTilePossibilities(String tiles) {
        char[] chars = tiles.toCharArray();
        //
        Arrays.sort(chars);
        int[] res = new int[1];
        backtrack(res, chars, new boolean[tiles.length()], tiles.length(), 0);
        return res[0];
    }

    private void backtrack(int[] res, char[] chars, boolean[] used, int length, int index) {
        //如果没有可以选择的就返回
        if (index == length) {
            return;
        }
        //
        for (int i = 0; i < length; i++) {
            //一个字符只能选择一次,
            if (used[i]) {
                continue;
            }
            //如果本次元素和上一次元素相等,枝重复
            if (i - 1 >= 0 && chars[i] == chars[i - 1] && !used[i - 1]) {
                continue;
            }
            used[i] = true;
            res[0]++;
            backtrack(res, chars, used, length, index + 1);
            used[i] = false;
        }
    }
}
