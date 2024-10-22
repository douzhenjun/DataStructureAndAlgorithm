package 力扣真题.贪心算法.加油站;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-03-18
 **/
public class Solution {
    public int canCompleteCurcuit(int[] gas, int[] cost){
        int sum = 0;//sum记录到这一站消耗的油量
        int min = 0;//记录某一站剩余的油量
        for(int i = 0; i < gas.length; i++){
            sum += (gas[i] - cost[i]);
            min = Math.min(sum, min);
        }
        if(sum < 0){
            return -1;
        }
        if(min >= 0){
            return 0;
        }
        for(int i = gas.length - 1; i > 0; i--){
            min += (gas[i] - cost[i]);
            if(min >= 0){
                return i;
            }
        }
        return -1;
    }
}
