package 力扣真题.贪心算法.用最少数量的箭引爆气球.test;

import java.util.Arrays;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-03-18
 **/
public class Solution {
    public int findMinArrowShots(int[][] points){
        Arrays.sort(points, (x, y) -> {
            return x[0] - y[0];
        });
        int count = 1;
        for(int i = 1; i < points.length; i++){
            if(points[i][0] <= points[i-1][1]){
                points[i][1] = Math.min(points[i-1][1], points[i][1]);
            }else{
                count++;
            }
        }
        return count;
    }
}
