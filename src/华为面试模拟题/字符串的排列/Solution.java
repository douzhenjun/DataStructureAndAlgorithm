package 华为面试模拟题.字符串的排列;

import java.util.Arrays;

/**
 * @Description 判断s2中是否包含s1的排列
 * @Author douzhenjun
 * @DATE 2024-04-24
 **/
public class Solution {
    public boolean checkInclusion(String s1, String s2){
        int n = s1.length();
        int m = s2.length();
        if(n > m){
            return false;
        }
        int[] cnt1 = new int[26];
        int[] cnt2 = new int[26];
        //首先n<=m成立,首先初始化cnt1,cnt2,获得每个字符的个数,判断是否相等
        for(int i = 0; i < n; i++){
            cnt1[s1.charAt(i) - 'a']++;
            cnt2[s2.charAt(i) - 'a']++;
        }
        if(Arrays.equals(cnt1, cnt2)){
            return true;
        }
        //如果不相等,维护一个长度为n的滑动窗口,然后左边移除一个元素,右边新增一个元素,时刻比较
        //两个字符串的元素数量是否相等.
        for(int i = n; i < m; i++){
            ++cnt2[s2.charAt(i) - 'a'];
            --cnt2[s2.charAt(i - n) - 'a'];
            if (Arrays.equals(cnt1, cnt2)) {
                return true;
            }
        }
        return false;
    }
}
