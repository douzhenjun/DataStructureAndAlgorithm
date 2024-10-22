package 力扣真题.哈希表.两个数组的交集;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2023-10-11
 **/
public class Solution {

    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        List<Integer> array1 = Arrays.stream(nums1).boxed().collect(Collectors.toList());
        List<Integer> array2 = Arrays.stream(nums2).boxed().collect(Collectors.toList());
        for (int i = 0; i < array1.size(); i++) {
            if (array2.contains(array1.get(i))) {
                set.add(array1.get(i));
            }
        }
        int[] result = new int[set.size()];
        Iterator<Integer> iterator = set.iterator();
        for (int i = 0; i < set.size(); i++) {
            if (!iterator.hasNext()) {
                return result;
            }
            result[i] = iterator.next();
        }
        return result;
    }

}
