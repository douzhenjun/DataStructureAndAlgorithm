package 力扣真题.贪心算法.用最少数量的箭引爆气球;

import java.util.Arrays;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-03-12
 **/
public class Solution {
    public int findMinArrowShots(int[][] points){
        Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));
        
        int count = 1;//至少需要一支箭
        for(int i = 1; i < points.length; i++){
            if(points[i][0] > points[i-1][1]){
                count++;
            }else{
                points[i][1] = Math.min(points[i][1], points[i-1][1]);
            }
        }
        return count;
    }
}
