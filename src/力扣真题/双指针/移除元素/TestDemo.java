package 力扣真题.双指针.移除元素;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-01-01
 **/
public class TestDemo {
    
    private Solution solution = new Solution();
    private Solution2 solution2 =  new Solution2();
    
    /*
      测试solution
     */
    @Test
    public void test01(){
        int[] nums = {3,2,2,3};
        int val = 2;
        System.out.println(solution.removeVal(nums,val));
        System.out.println(Arrays.toString(nums));
    }

    @Test
    public void test02(){
        int[] nums = {2,2,2,2};
        int val = 2;
        System.out.println(solution.removeVal(nums,val));
        System.out.println(Arrays.toString(nums));
    }

    @Test
    public void test03(){
        int[] nums = {3,3,3,3};
        int val = 2;
        System.out.println(solution.removeVal(nums,val));
        System.out.println(Arrays.toString(nums));
    }
    
    /*
      测试solution2
     */
    @Test
    public void test04(){
        int[] nums = {3,2,2,3};
        int val = 2;
        System.out.println(solution2.removeVal(nums,val));
        System.out.println(Arrays.toString(nums));
    }

    @Test
    public void test05(){
        int[] nums = {2,2,2,2};
        int val = 2;
        System.out.println(solution2.removeVal(nums,val));
        System.out.println(Arrays.toString(nums));
    }

    @Test
    public void test06(){
        int[] nums = {3,3,3,3};
        int val = 2;
        System.out.println(solution2.removeVal(nums,val));
        System.out.println(Arrays.toString(nums));
    }
}

