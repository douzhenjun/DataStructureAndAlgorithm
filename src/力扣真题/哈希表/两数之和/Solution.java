package 力扣真题.哈希表.两数之和;

import java.util.HashMap;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-04-27
 **/
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int matchNum = target - nums[i];
            if (hashMap.containsKey(matchNum)) {
                result[0] = i;
                result[1] = hashMap.get(matchNum);
                return result;
            } else {
                hashMap.put(nums[i], i);
            }
        }
        return result;
    }
}
