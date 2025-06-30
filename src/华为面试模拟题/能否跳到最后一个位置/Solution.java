package 华为面试模拟题.能否跳到最后一个位置;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-04-25
 **/
public class Solution {
    public boolean canJump(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        int coverRange = 0;
        for (int i = 0; i <= coverRange; i++) {
            coverRange = Math.max(coverRange, i + nums[i]);
            if (coverRange >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }
}
