package 力扣真题.贪心算法.摆动序列.test;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-03-18
 **/
public class Solution {
    public int getLongestLengthOfSeq(int[] nums){
        int result = 1;
        int len = nums.length;
        if(len <= 2){
            return len;
        }
        int curDiff = 0;
        int preDiff = 0;
        for(int i = 1; i < len; i++){
            curDiff = nums[i] - nums[i-1];
            if(curDiff > 0 && preDiff <= 0 || curDiff < 0 && preDiff >= 0){
                result++;
                preDiff = curDiff;
            }
        }
        return result;
    }
}
