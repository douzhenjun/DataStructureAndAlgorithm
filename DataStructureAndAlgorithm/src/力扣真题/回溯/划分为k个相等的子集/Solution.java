package 力扣真题.回溯.划分为k个相等的子集;

import java.util.Arrays;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-07-29
 **/
public class Solution {
    public boolean canPartitionSubsets(int[] nums, int k){
        int total = 0;
        for(int num : nums){
            total += num;
        }
        if(total == 0 || total % k != 0){
            return false;
        }
        Arrays.sort(nums);
        return backtrack(nums, nums.length - 1, total / k, new int[k]);
    }
    
    /**
     * @Description: 
     * @Param:  
     *          nums表示数组
     *          index表示访问到的当前火柴的位置
     *          target表示正方形的边长
     *          size是长度为k的数组,分别表示k边形每条边包含的nums
     * @return: 
     */
    private boolean backtrack(int[] nums, int index, int target, int[] size){
        //如果火柴都访问完了
        if(index == -1){
            //并且size的k个边的长度都相等,说明是正k边形,返回true,否则返回false
            for(int i = 1; i < size.length; i++){
                if(size[i] != size[i - 1]){
                    return false;
                }
            }
            return true;
        }
        //到这一步说明火柴还没有被访问完
        for(int i = 0; i < size.length; i++){
            //如果把当前火柴放到size[i]这个边上,它的长度大于target,我们直接跳过,或者上一个分支的值和当前的分支一样,
            //上一个分支没有成功,说明这个分支也不会成功,直接跳过即可.
            if(size[i] + nums[index] > target || (i > 0 && size[i] == size[i - 1])){
                continue;
            }
            //如果当前火柴放到size[i]这个边上,长度不大于target,我们就放上面
            size[i] += nums[index];
            //然后再放下一个火柴,如果最终能变成正方形,直接返回true
            if(backtrack(nums, index - 1, target, size)){
                return true;
            }
            //移除这根火柴,尝试其他的可能
            size[i] -= nums[index];
        }
        return false;
    }
}
