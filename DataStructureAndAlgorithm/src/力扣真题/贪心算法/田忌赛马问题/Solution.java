package 力扣真题.贪心算法.田忌赛马问题;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-09-02
 **/
public class Solution {
    //如何排列nums1,使得nums1对于nums2的元素优势最大?(nums1[i]>nums2[i]的个数最多)
    public int[] advantageCount(int[] nums1, int[] nums2) {
        int length = nums1.length;
        int[] res = new int[length];
        Arrays.sort(nums1);
        //优先队列,元素为两位元素的int[],按照第一个元素的大小排序,从大到小
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        //向pq中新增元素,nums2的第i个元素和下标i
        for (int i = 0; i < length; i++) {
            pq.add(new int[]{nums2[i], i});
        }
        //定义首尾指针
        int left = 0;
        int right = length - 1;
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int index = cur[1];
            int val = cur[0];
            if (nums1[right] > val) {
                res[index] = nums1[right--];
            } else {
                res[index] = nums1[left++];
            }
        }
        return res;
    }
}
