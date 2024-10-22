package 华为面试模拟题.最长公共子串;

import org.junit.Test;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-04-24
 **/
public class TestDemos {
    Solution solution = new Solution();
    @Test
    public void test01(){
        String str1 = "abcabcddd";
        String str2 = "abcabc";
        System.out.println(solution.findMaxLength(str1, str2));
    }

    @Test
    public void test02(){
        String str1 = "abcldef";
        String str2 = "abcdef";
        System.out.println(solution.findMaxLength(str1, str2));
    }

    @Test
    public void test03(){
        Solution2 solution2 = new Solution2();
        String str1 = "abcldef";
        String str2 = "abcdef";
        System.out.println(solution2.LCS(str1, str2));
    }
}
