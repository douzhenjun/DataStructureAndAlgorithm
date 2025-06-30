package 力扣真题.哈希表.两个数组的交集;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2023-10-12
 **/
public class TestDemo {

    Solution solution = new Solution();

    @Test
    public void test01() {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        int[] nums3 = solution.intersection(nums1, nums2);
        System.out.println(Arrays.toString(nums3));
    }

    @Test
    public void test02() {
        int[] nums1 = {4, 9, 5};
        int[] nums2 = {9, 4, 9, 8, 4};
        int[] nums3 = solution.intersection(nums1, nums2);
        System.out.println(Arrays.toString(nums3));
    }
}
