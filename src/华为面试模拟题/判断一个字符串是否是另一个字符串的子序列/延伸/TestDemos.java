package 华为面试模拟题.判断一个字符串是否是另一个字符串的子序列.延伸;

import org.junit.Test;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-05-03
 **/
public class TestDemos {
    Solution solution = new Solution();
    @Test
    public void test01(){
        String s = "ababc";
        String t = "bcdea";
        System.out.println(solution.getResult(s, t));
    }
}
