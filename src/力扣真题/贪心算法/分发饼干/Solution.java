package 力扣真题.贪心算法.分发饼干;

import java.util.Arrays;

/**
 * @Description g为小孩的胃口, s为饼干的尺寸
 * @Author douzhenjun
 * @DATE 2024-03-03
 **/
public class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int index = s.length - 1;
        int result = 0;
        for (int i = g.length - 1; i >= 0; i--) {
            if (index >= 0 && s[index] >= g[i]) {
                result++;
                index--;
            }
        }
        return result;
    }
}
