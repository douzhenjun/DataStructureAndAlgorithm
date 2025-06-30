package 力扣真题.贪心算法.划分字母区间.test;

import java.util.LinkedList;
import java.util.List;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-03-18
 **/
public class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> lst = new LinkedList<>();
        char[] chars = s.toCharArray();
        int[] edge = new int[26];
        for(int i = 0; i < chars.length; i++){
            edge[chars[i] - 'a'] = i;
        }
        int idx = 0;
        int last = -1;
        for(int i = 0; i < chars.length; i++){
            idx = Math.max(idx, edge[chars[i] - 'a']);
            if(i == idx){
                lst.add(i-last);
                last = i;
            }
        }
        return lst;
    }
}
