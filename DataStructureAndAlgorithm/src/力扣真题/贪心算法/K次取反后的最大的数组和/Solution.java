package 力扣真题.贪心算法.K次取反后的最大的数组和;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-03-12
 **/
public class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) {
        List<Integer> numsList = Arrays.stream(nums).boxed().collect(Collectors.toList());
        numsList.sort((x, y) -> Math.abs(y) - Math.abs(x));
        int len = nums.length;
        for(int i = 0; i < len; i++){
            if(numsList.get(i) < 0 && k > 0){
                numsList.set(i, -numsList.get(i));
                k--;
            }
        }
        while(k % 2 == 1){
            numsList.set(0, -numsList.get(0));
            k--;
        }
        int result = 0;
        for(Integer num : numsList){
            result += num;
        }
        return result;
    }
}
