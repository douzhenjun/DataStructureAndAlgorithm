package 力扣真题.回溯.平方数组的数目;

import java.util.*;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-08-10
 **/
public class Solution {
    private static int res = 0;
    private static boolean[] used;

    public int numSquarefulPerms(int[] nums) {
        used = new boolean[nums.length];
        List<Integer> path = new ArrayList<>();
        backTracking(nums, path);
        return res;
    }

    private void backTracking(int[] nums, List<Integer> path) {
        if (path.size() == nums.length) {
            int[] nums1 = path.stream().mapToInt(Integer::intValue).toArray();
            if (isNumSquareList(nums1)) {
                res++;
                return;
            }
        }
        Set<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (hashSet.contains(nums[i]) || used[i]) {
                continue;
            }
            hashSet.add(nums[i]);
            used[i] = true;
            path.add(nums[i]);
            backTracking(nums, path);
            used[i] = false;
            path.remove(path.size() - 1);
        }
    }

    private boolean isNumSquareList(int[] nums) {
        if (nums.length == 1) {
            int sqrtNum = (int)Math.sqrt(nums[0]);
            return sqrtNum * sqrtNum == nums[0];
        }
        int pre = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int sum = pre + nums[i];
            int sqrt = (int)Math.sqrt(sum);
            if (sqrt * sqrt != sum) {
                return false;
            }
            pre = nums[i];
        }
        return true;
    }
}
