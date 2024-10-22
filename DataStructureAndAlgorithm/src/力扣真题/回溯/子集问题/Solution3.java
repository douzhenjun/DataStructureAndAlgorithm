package 力扣真题.回溯.子集问题;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-09-01
 **/
public class Solution3 {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res, nums, new ArrayList<>(), 0);
        return res;
    }

    private void helper(List<List<Integer>> res, int[] nums, List<Integer> list, int index) {
        //终止条件判断
        if (index == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        helper(res, nums, list, index + 1);
        list.add(nums[index]);
        helper(res, nums, list, index + 1);
        list.remove(list.size() - 1);
    }
}
