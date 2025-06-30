package 华为面试模拟题.四数相加II;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-04-27
 **/
public class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int result = 0;//result用来统计四个数组元素之和等于0的情况的次数
        Map<Integer, Integer> countMap = new HashMap<>();//用来存放nums1+nums2中各元素之和及其出现次数
        //统计nums1和nums2中个元素之和及其出现的次数
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                int sum = nums1[i] + nums2[j];
                countMap.put(sum, countMap.getOrDefault(sum, 0) + 1);
            }
        }
        //遍历nums3和nums4中个元素之和,如果0-nums3[k]-nums4[l]在Map中存在,则result+=(该元素对应的value)
        for (int i = 0; i < nums3.length; i++) {
            for (int j = 0; j < nums4.length; j++) {
                int sum2 = nums3[i] + nums4[j];
                if (countMap.containsKey(0 - sum2)) {
                    result += countMap.get(0 - sum2);
                }
            }
        }
        return result;
    }

}
