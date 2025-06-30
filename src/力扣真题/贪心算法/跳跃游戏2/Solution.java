package 力扣真题.贪心算法.跳跃游戏2;

/**
 * @Description
 * 局部最优:当前可移动距离尽可能多走,如果还没到终点,步数再加1
 * 整体最优:一步尽可能多走,从而达到最少步数
 * 定义当前所能到达的最大区域curDistance,全局所能到达的最大区域maxDistance,以及跳跃的次数count
 * 遍历数组,如果i+nums[i],它的值超过了maxDistance,那么更新maxDistance
 * 然后判断maxDistance是否大于等于len-1,如果是,说明再跳一次就能完成,count++,这时候也不用遍历了
 * 否则的话,说明目前没有办法到达最后的位置,必须试探下一步,也就是i++
 * 这时候不对count自增,假设第i步的最少步数为count(i),如果
 * 可能在i+1,i+2...i+nums[i]的某个位置能够到达,这时候也只是count=count(i)+1.(count(i)表示第i次的时候更新的count)
 * 只有当i+1,i+2,...,i+nums[i]这些位置都不能到达的时候,count=count(i)+2;因为这些位置都没办法一步到达,必须走到下一步
 * 所以在走到i+nums[i]这个位置之前都不能随便地对count(i)自增
 * @Author douzhenjun
 * @DATE 2024-03-12
 **/
public class Solution {
    public int jump(int[] nums){
        if(nums == null || nums.length == 0 || nums.length == 1){
            return 0;
        }
        int count = 0;//记录跳跃的次数
        int curDistance = 0;//当前的覆盖最大区域
        int maxDistance = 0;//最大的覆盖区域
        for(int i = 0; i < nums.length; i++){
            //更新最大的覆盖区域
            maxDistance = Math.max(maxDistance, i+nums[i]);
            //如果当前的最大覆盖范围能够到达末尾,说明可以直接一步跳到
            if(maxDistance >= nums.length-1){
                count++;
                break;
            }
            //如果当前的最大覆盖范围并没有到达末尾,不对count自增,直接进行下一步
            //如果这时候当前的最大覆盖范围并没有到达末尾,并且i走到了上一次的最大覆盖范围,说明
            //上一次覆盖范围内的所有方式都不能够达到终点,这时候更新新的最大覆盖范围并且count++
            if(i == curDistance){
                curDistance = maxDistance;
                count++;
            }
        }
        return count;
    }
}
