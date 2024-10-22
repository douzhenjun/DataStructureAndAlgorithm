package 力扣真题.动态规划.完全背包问题.组合总和IV.暴力;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-03-07
 **/
public class Solution {
    private int result;
    List<Integer> path = new ArrayList<>();
    List<List<Integer>> pathList = new ArrayList<>();
    public int combinationSum4(int[] nums, int target){
        backTracking(nums, target, 0);
        return result;
    }
    
    public void backTracking(int[] nums, int target, int sum){
        if(sum >= target){
            if(sum == target){
                result++;
                pathList.add(new ArrayList<>(path)); 
            }
            return;//可以return的原因是nums[i]>=1,所以再找也没有意义了
        }
        
        for(int i = 0; i < nums.length; i++){
            path.add(nums[i]);
            sum += nums[i];
            backTracking(nums, target, sum);
            sum -= nums[i];
            path.remove(path.size()-1);
        }
    }
}
