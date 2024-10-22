package 华为面试模拟题.三数之和;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2023-10-19
 **/
public class Solution2 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                return result;
            }
            //这是为了避免i所指的元素重复,因为先固定i,然后去遍历left和right,使得三者和为0
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            //定义left,right
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[left] + nums[right] + nums[i];
                //如果三者和大于0,说明需要让和减小,让right左移
                if (sum > 0) {
                    right--;
                    //如果三者和小于0,说明需要让和增大,让left右移
                } else if (sum < 0) {
                    left++;
                } else {
                    //如果三者和等于0,将这三个指针所指的元素添加到result中
                    Integer[] resultNums = {nums[i], nums[left], nums[right]};
                    List<Integer> resultList = Arrays.asList(resultNums);
                    result.add(resultList);
                    //同时继续遍历,但需要避免left重复和right重复的情况,最后right会走到最后一个重复的位置
                    while (right > left && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    //最后left会走到最后一个重复的位置
                    while (right > left && nums[left] == nums[left + 1]) {
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
