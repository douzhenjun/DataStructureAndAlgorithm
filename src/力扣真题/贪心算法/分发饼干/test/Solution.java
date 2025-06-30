package 力扣真题.贪心算法.分发饼干.test;

import java.util.Arrays;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-03-18
 **/
public class Solution {
    public int getCookies(int[] g, int[] s){
        Arrays.sort(g);
        Arrays.sort(s);
        int count = 0;
        int index = s.length-1;
        for(int i = g.length - 1; i >= 0; i--){
            if(index >= 0 && s[index] >= g[i]){
                index--;
                count++;
            }
        }
        return count;
    }
}
