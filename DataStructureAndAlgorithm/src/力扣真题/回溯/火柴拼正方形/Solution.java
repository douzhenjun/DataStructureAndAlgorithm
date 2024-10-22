package 力扣真题.回溯.火柴拼正方形;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-08-21
 **/
public class Solution {
    public boolean makeSquare(int[] nums){
        int total = 0;
        for(int num : nums){
            total += num;
        }
        if(total == 0 || (total & 3) != 0){
            return false;
        }
        return backtrack(nums, 0, total >> 2, new int[4]);
    }
    
    private boolean backtrack(int[] nums, int index, int target, int[] size){
        if(index == nums.length){
            //如果火柴都访问完了,并且size的4个边的长度都相等,说明是正方形,直接返回true,否则返回false
            if(size[0] == size[1] && size[1] == size[2] && size[2] == size[3]){
                return true;
            }
            return false;
        }
        for(int i = 0; i < size.length; i++){
            //如果当前火柴放到size[i]这个边上,它的长度大于target,直接跳过就可以了
            if(size[i] + nums[index] > target){
                continue;
            }
            //当前火柴放到size[i]中
            size[i] += nums[index];
            if(backtrack(nums, index + 1, target, size)){
                return true;
            }
            size[i] -= nums[index];
        }
        return false;
    }
}
