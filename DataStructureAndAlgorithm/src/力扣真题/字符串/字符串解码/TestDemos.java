package 力扣真题.字符串.字符串解码;

import org.junit.Test;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-04-24
 **/
public class TestDemos {
    @Test
    public void test01(){
        String s = new String("3[a]2[bc]");
        Solution solution = new Solution();
        System.out.println(solution.decodeString(s));
    }
}
