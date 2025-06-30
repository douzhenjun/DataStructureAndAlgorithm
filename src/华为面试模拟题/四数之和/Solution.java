package 华为面试模拟题.四数之和;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-04-27
 **/
public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            //这种情况下遍历后面的指针不可能出现和为target的情况,直接返回即可,遍历可以提前结束了
            if (nums[i] > 0 && nums[i] > target) {
                return result;
            }
            //为了去重,如果两个四元组元素一一对应,则认为两个四元组重复了
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            //固定i,定义j=i+1,
            for (int j = i + 1; j < nums.length; j++) {
                //去掉不可能满足和为target的情况以及重复的情况
                if (nums[j] > 0 && nums[i] + nums[j] > target) {
                    continue;
                }
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                //固定了i和j以后,再定义两个指针,分别指向j+1和末尾.
                int left = j + 1;
                int right = nums.length - 1;
                //双指针移动,当sum==target时,将结果添加到res中
                while (left < right) {
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum > target) {
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        //这时候继续对接下来的结果去重,继续遍历其他情况
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        left++;
                        right--;
                    }
                }
            }
        }
        return result;
    }
}
