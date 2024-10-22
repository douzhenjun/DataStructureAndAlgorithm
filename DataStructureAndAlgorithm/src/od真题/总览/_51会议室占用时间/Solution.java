package od真题.总览._51会议室占用时间;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @Description
 * 合并区间
 * @Author douzhenjun
 * @DATE 2024-03-26
 **/
public class Solution {
    public int[][] merge(int[][] roomTimes) {
        if (roomTimes.length == 0) {
            return new int[0][2];
        }
        //将元素按照数组中的第一个元素升序排序
        Arrays.sort(roomTimes, new Comparator<int[]>() {
            public int compare(int[] interval1, int[] interval2) {
                return interval1[0] - interval2[0];
            }
        });
        //保存最后的区间合并后的结果
        List<int[]> merged = new ArrayList<int[]>();
        for (int i = 0; i < roomTimes.length; ++i) {
            int L = roomTimes[i][0], R = roomTimes[i][1];
            //如果merged为空或者merged的最后一个位置的第二个元素(区间右边)小于待添加元素的第一个元素(区间左边)
            //说明添加的元素和前面的元素没有交集,则直接添加即可
            if (merged.size() == 0 || merged.get(merged.size() - 1)[1] < L) {
                merged.add(new int[]{L, R});
            } else {
                //否则,将最后一个位置的元素的第二个元素替换成Math.max(待添加元素的第二个元素,最后一个位置元素的第二个元素)
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], R);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
}
