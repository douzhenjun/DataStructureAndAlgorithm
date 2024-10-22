package 华为面试模拟题.无重复字符的最长子串;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * 采用双指针方法,使用哈希表记录字符串s的所有元素最近一次出现的下标
 * 遍历字符串s,当s中的元素在哈希表中出现过了,那么首先我们拿到这个元素上一次在哈希表中出现的位置i.
 * 接着我们更新这个元素的最新出现位置为j.
 * 然后我们获得s.substring(i,j)这个子串,这个子串一定是没有重复的元素的最长子串,长度为j-i.
 * 这个长度拿去和全局最长的结果res做比较.
 * @Author douzhenjun
 * @DATE 2024-04-24
 **/
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> dic = new HashMap<>();//记录的是元素及其出现最近的一次下标
        int i = -1, res = 0, len = s.length();
        for(int j = 0; j < len; j++) {
            if (dic.containsKey(s.charAt(j)))
                i = Math.max(i, dic.get(s.charAt(j))); // 更新左指针 i
            dic.put(s.charAt(j), j); // 更新哈希表记录
            res = Math.max(res, j - i); // 更新结果
        }
        return res;
    }
}
