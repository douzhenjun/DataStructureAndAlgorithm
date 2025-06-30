package 华为面试模拟题.等长字符串中最大的元音数目;

import java.util.HashSet;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-05-17
 **/
class Solution {
    public int maxVowels(String s, int k) {
        HashSet<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');

        int len = s.length();
        int count = 0;
        int res = 0;

        // 初始化窗口中的元音数目
        int left = 0;
        while (left < k) {
            if (set.contains(s.charAt(left))) {
                count++;
            }
            left++;
        }
        res = count;
        // 滑动窗口
        for (int right = left; right < len; right++) {
            if (set.contains(s.charAt(right))) {
                count++;
            }
            if (set.contains(s.charAt(right - k))) {
                count--;
            }
            res = Math.max(res, count);
        }
        return res;
    }
}