package 力扣真题.字符串.KMP;

import org.junit.Test;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-01-27
 **/
public class TestDemos {
    Solution solution = new Solution();
    @Test
    public void test1(){
        String haystack = "abcabcafab";
        String needle = "abcaf";
        System.out.println(solution.strStr(haystack, needle));
    }

    @Test
    public void test2(){
        String haystack = "abcabcafab";
        String needle = "abcdf";
        System.out.println(solution.strStr(haystack, needle));
    }
}
