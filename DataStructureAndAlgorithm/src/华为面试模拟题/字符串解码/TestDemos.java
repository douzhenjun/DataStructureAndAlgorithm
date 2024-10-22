package 华为面试模拟题.字符串解码;

import org.junit.Test;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-04-24
 **/
public class TestDemos {
    @Test
    public void test01(){
        String s = "3[a2[c]]";
        Solution2 solution = new Solution2();
        System.out.println(solution.decodeString(s));
    }

    @Test
    public void test02(){
        String s = "2[a3[ab]]";
        Solution2 solution = new Solution2();
        System.out.println(solution.decodeString(s));
    }
}
