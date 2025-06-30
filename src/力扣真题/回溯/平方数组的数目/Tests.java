package 力扣真题.回溯.平方数组的数目;

import org.junit.Test;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-08-10
 **/
public class Tests {
    
    @Test
    public void test1(){
        int i = 4;
        int j = (int)Math.sqrt(i);
        System.out.println(j * j == i);
        i = 6;
        j = (int)Math.sqrt(i);
        System.out.println(j * j == i);
    }
    
    @Test
    public void test2(){
        int[] nums = {1, 17, 8};
        Solution solution = new Solution();
        int[] nums2 = {2, 2, 2};
        System.out.println(solution.numSquarefulPerms(nums2));
    }
}
