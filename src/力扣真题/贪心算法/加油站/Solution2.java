package 力扣真题.贪心算法.加油站;

/**
 * @Description
 * 记每个加油站的剩余油量为rest[i] = gas[i] - cost[i]，
 * curSum记录i从0到n的rest累加结果，一旦curSum<0,说明[0,i]都不能作为起始位置，因为这个区间里任意一个位置作为起点
 * 到i这里都会断油，那么起始位置从i+1开始，再从0计算curSum
 * @Author douzhenjun
 * @DATE 2024-03-18
 **/
public class Solution2 {
    public int canCompleteCircuit(int[] gas, int[] cost){
        int curSum = 0;
        int totalSum = 0;
        int index = 0;
        for(int i = 0; i < gas.length; i++){
            curSum += gas[i] - cost[i];
            totalSum += gas[i] - cost[i];
            if(curSum < 0){
                index = (i + 1) % gas.length;
                curSum = 0;
            }
        }
        if(totalSum < 0){
            return -1;
        }
        return index;
    }
}
