package 华为面试模拟题.无重复字符的最长子串;

import org.junit.Test;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-05-04
 **/
public class TestDemos {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "abcabcbb";
        System.out.println(solution.lengthOfLongestSubstring(s));
        String t = "bbbbb";
        System.out.println(solution.lengthOfLongestSubstring(t));
        String u = "pwwkew";
        System.out.println(solution.lengthOfLongestSubstring(u));
        String v = "abcdefg";
        System.out.println(solution.lengthOfLongestSubstring(v));
    }
    
    @Test
    public void test01(){
        Solution solution = new Solution();
        String s = "abcdacb";
    }
}
