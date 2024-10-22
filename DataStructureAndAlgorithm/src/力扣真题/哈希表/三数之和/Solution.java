package 力扣真题.哈希表.三数之和;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Description 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]]
 * 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请
 * 你返回所有和为 0 且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 * @Author douzhenjun
 * @DATE 2023-10-19
 **/
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Integer[] nums2 = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            nums2[i] = Integer.valueOf(nums[i]);
        }
        List<Integer> numsList = Arrays.asList(nums2);
        Collections.sort(numsList);

        for (int i = 0; i < numsList.size(); i++) {
            if (numsList.get(i) > 0) {
                return result;
            }
            //这是为了避免i所指的元素重复,因为先固定i,然后去遍历left和right,使得三者和为0
            if (i > 0 && numsList.get(i) == numsList.get(i - 1)) {
                continue;
            }
            //定义left,right
            int left = i + 1;
            int right = numsList.size() - 1;
            while (left < right) {
                int sum = numsList.get(left) + numsList.get(right) + numsList.get(i);
                //如果三者和大于0,说明需要让和减小,让right左移
                if (sum > 0) {
                    right--;
                    //如果三者和小于0,说明需要让和增大,让left右移
                } else if (sum < 0) {
                    left++;
                } else {
                    //如果三者和等于0,将这三个指针所指的元素添加到result中
                    Integer[] resultNums = {numsList.get(i), numsList.get(left), numsList.get(right)};
                    List<Integer> resultList = Arrays.asList(resultNums);
                    result.add(resultList);
                    //同时继续遍历,但需要避免left重复和right重复的情况,最后right会走到最后一个重复的位置
                    while (right > left && numsList.get(right) == numsList.get(right - 1)) {
                        right--;
                    }
                    //最后left会走到最后一个重复的位置
                    while (right > left && numsList.get(left) == numsList.get(left + 1)) {
                        left++;
                    }
                    //移动指针,寻找下一个满足三者和为0的情况
                    //left和right必须同时移动并且同时指向和上一个所指元素不一样的位置
                    left++;
                    right--;
                }
            }
        }
        return result;
    }
}
