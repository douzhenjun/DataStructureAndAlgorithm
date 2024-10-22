package 力扣真题.贪心算法.跳跃游戏;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-03-12
 **/
public class Solution {
    public boolean canJump(int[] nums) {
        int len = nums.length;
        if(len == 1){
            return true;
        }
        int coverRange = 0;//覆盖范围,初始0
        for(int i = 0; i <= coverRange; i++){
            coverRange = Math.max(coverRange, i+nums[i]);//更新
            if(coverRange >= len-1){
                return true;
            }
        }
        return false;
    }
}
