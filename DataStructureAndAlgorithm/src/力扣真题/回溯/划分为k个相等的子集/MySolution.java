package 力扣真题.回溯.划分为k个相等的子集;

import java.util.Arrays;

/**
 * @Description
 *      
 * @Author douzhenjun
 * @DATE 2024-08-07
 **/
public class MySolution {
    public boolean canPartitionSubsets(int[] nums, int k){
        int total = 0;
        for(int i = 0; i < nums.length; i++){
            total += nums[i];
        }
        if(total % k != 0){
            return false;
        }
        boolean[] visited = new boolean[nums.length];
        Arrays.sort(nums);
        return backtrack(nums, 0, nums.length - 1, visited, total / k, k);
    }
    
    
    /**
     * @Description: 
     * @Param: nums 原数组
     *          total 当前边的长度
     *          start 数组中元素的开始位置
     *          visited 数组中对应的元素是否被使用过
     *          target 平均值,也就是每条边的长度
     *          k 计算到第几条边了
     * @return: 
     */
    private boolean backtrack(int[] nums, int total, int start, boolean[] visited, int target, int k){
        if(k == 0){
            return true;
        }
        if(total == target){
            return backtrack(nums, 0, nums.length - 1, visited, target, k - 1);
        }
        for(int i = start; i >= 0; i--){
            if(visited[i]){
                continue;
            }
            if(total + nums[i] > target){
                continue;
            }
            visited[i] = true;
            if(backtrack(nums, total + nums[i], i - 1, visited, target, k)){
                return true;
            }
            visited[i] = false;
        }
        return false;
    }
}
