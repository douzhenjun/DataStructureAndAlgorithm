package 力扣真题.贪心算法.加油站.test;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-03-18
 **/
public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost){
        int curSum = 0;
        int totalSum = 0;
        int index = 0;
        for(int i = 0; i < gas.length; i++){
            curSum += gas[i] - cost[i];
            totalSum  += gas[i] - cost[i];
            if(curSum < 0){
                curSum = 0;
                index = (i + 1) % gas.length;
            }
        }
        if(totalSum < 0){
            return -1;
        }
        return index;
    }
}
