package 力扣真题.数组.最小子串问题;

import org.junit.Test;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2023-10-03
 **/
public class Tests {

    Solution solution = new Solution();

   @Test
    public void test01(){
       String s = "ADOBECODEBANC";
       String t = "ABC";
       System.out.println(solution.minWindow(s, t));
   }
}
