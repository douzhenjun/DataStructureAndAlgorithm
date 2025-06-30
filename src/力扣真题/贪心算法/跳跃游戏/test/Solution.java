package 力扣真题.贪心算法.跳跃游戏.test;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-03-18
 **/
public class Solution {
    public boolean jumpGame(int[] nums){
        if(nums.length == 1){
            return true;
        }
        int maxLength = 0;
        for(int i = 0; i <= maxLength; i++){
            int length = nums[i];
            maxLength = Math.max(i+length, maxLength);
            if(maxLength >= nums.length - 1){
                return true;
            }
        }
        return false;
    }
}
