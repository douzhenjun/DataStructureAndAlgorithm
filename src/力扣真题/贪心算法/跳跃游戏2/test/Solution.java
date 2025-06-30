package 力扣真题.贪心算法.跳跃游戏2.test;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-03-18
 **/
public class Solution {
    public int jumpGame(int[] nums){
        if(nums == null || nums.length == 0 || nums.length == 1){
            return 0;
        }
        int coverRange = 0;
        int maxCoverange = 0;
        int count = 0;
        for(int i = 0; i < nums.length - 1; i++){
            if(nums[i] + i > maxCoverange){
                maxCoverange = nums[i] + i;
            }
            if(maxCoverange >= nums.length - 1){
                count++;
                break;
            }else{
                if(i == coverRange){
                    count++;
                    coverRange = maxCoverange;
                }
            }
        }
        return count;
    }
}
