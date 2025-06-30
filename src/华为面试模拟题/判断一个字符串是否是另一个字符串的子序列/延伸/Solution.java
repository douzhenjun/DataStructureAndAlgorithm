package 华为面试模拟题.判断一个字符串是否是另一个字符串的子序列.延伸;

import java.util.*;

/**
 * @Description 采用双指针的方法求解.
 * i遍历长字符串s,使用index遍历字符串t.
 * if-else if条件判断s[i]和t[index]若相等, index++
 * else if s[i]和t[index]不相等但s[i]和t[0]相等,那么index = 1
 * 如果index == t.length, 说明t是s的子串, 这个时候定义一个res, res=
 * @Author douzhenjun
 * @DATE 2024-05-03
 **/
public class Solution {
    public int getResult(String s, String t) {
        int res = t.length();
        HashMap<Character, Integer> cnt = new HashMap<>();//用来记录t中元素出现次数
        for (int j = 0; j < t.length(); j++) {
            cnt.put(t.charAt(j), cnt.getOrDefault(t.charAt(j), 0) + 1);
        }
        //遍历s中元素,如果s中元素在t中也出现了,则更新cnt和res
        for (int k = 0; k < s.length(); k++) {
            if (cnt.containsKey(s.charAt(k))) {
                cnt.put(s.charAt(k), cnt.get(s.charAt(k)) - 1);
                res--;
                if (cnt.get(s.charAt(k)) == 0) {
                    cnt.remove(s.charAt(k));
                }
            }
        }
        return res;
    }
}
