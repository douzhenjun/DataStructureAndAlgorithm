package 力扣真题.贪心算法.摆动序列;

/**
 * @Description 
 * 去掉所有单调的节点,所谓单调,指的是
 * num[i]-nums[i-1]>0且nums[i+1]-nums[i]>0 或 num[i]-nums[i-1]<0且nums[i+1]-nums[i]<0
 * 定义两个变量curDiff和preDiff,一个记录当前的差值,一个记录上一次的差值
 * 我们考虑删除curDiff和preDiff同号(要么大于0,要么小于0)的当前节点(注意当前)
 * 而实际操作中并非删除而是对curDiff和preDiff异号的情况做好统计.
 * 考虑会有平坡的情况(nums[i]-nums[i-1]=0,nums[i+1]-nums[i]=0)
 * 这种情况下
 * @Author douzhenjun
 * @DATE 2024-03-03
 **/
public class Solution2 {
    public int wiggleMaxLength(int[] nums){
        if(nums.length <= 1){
            return nums.length;
        }
        //当前差值
        int curDiff = 0;
        //上一个差值
        int preDiff = 0;
        int count = 1;
        for(int i = 1; i < nums.length; i++){
            //得到当前差值
            curDiff = nums[i] - nums[i-1];
            //如果当前差值和上一个差值为一正一负
            //波谷||波峰,包含
            if((curDiff > 0 && preDiff <= 0) || (curDiff < 0 && preDiff >= 0)){
                count++;
                preDiff = curDiff;//注意这里,只在摆动变化的时候更新PreDiff
            }
        }
        return count;
    }
}
