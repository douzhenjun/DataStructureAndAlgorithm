package 力扣真题.贪心算法.加油站;

/**
 * @Description 暴力法
 * @Author douzhenjun
 * @DATE 2024-03-18
 **/
public class Solution3 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        for (int i = 0; i < cost.length; i++) {
            int rest = gas[i] - cost[i];
            int index = (i + 1) % cost.length;
            while (rest > 0 && index != i) {
                rest += gas[index] - cost[index];
                index = (index + 1) % cost.length;
            }
            if (rest >= 0 && index == i) {
                return i;
            }
        }
        return -1;
    }
}
