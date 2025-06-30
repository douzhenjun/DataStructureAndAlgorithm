package 力扣真题.贪心算法.摆动序列;

import 力扣真题.贪心算法.单调递增的数字.Solution;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-05-23
 **/
public class TestDemos {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 2, 3};
        Solution2 solution2 = new Solution2();
        System.out.println(solution2.wiggleMaxLength(nums));
        int[] nums1 = new int[]{1, 2, 1};
        System.out.println(solution2.wiggleMaxLength(nums1));
        int[] nums2 = new int[]{1, 1, 1};
        System.out.println(solution2.wiggleMaxLength(nums2));
        int[] nums3 = new int[]{1, 2, 2, 2, 1};
        System.out.println(solution2.wiggleMaxLength(nums3));
    }
}
