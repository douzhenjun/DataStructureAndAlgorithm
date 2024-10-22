package 力扣真题.贪心算法.划分字母区间;

import java.util.LinkedList;
import java.util.List;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-03-13
 **/
public class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> list = new LinkedList<>();
        int[] edge = new int[26];
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            edge[chars[i] - 'a'] = i;//记录每个字母出现的最后的下标
        }
        int idx = 0;
        int last = -1;
        for (int i = 0; i < chars.length; i++) {
            idx = Math.max(idx, edge[chars[i] - 'a']);
            if (i == idx) {//如果i走到了前面所有字母的最后出现的下标位置,那么说明这里可以分割了,.,...
                list.add(i - last);
                last = i;
            }
        }
        return list;
    }
}
