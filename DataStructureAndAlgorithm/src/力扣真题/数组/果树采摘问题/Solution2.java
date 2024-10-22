package 力扣真题.数组.果树采摘问题;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description 滑动窗口解法
 * 节省时间,牺牲空间
 * 定义一个哈希表用来存放fruits中数字的出现次数
 * 定义左右指针,左指针默认为0,右指针遍历fruits
 * 遍历过程中,如果哈希表的元素个数<=2,那么向哈希表新增此时的元素
 * 但当哈希表的元素个数>2时,说明这个时候需要滑动左指针了,每滑动一次左指针,就对哈希表做一次减值操作
 * 直到哈希表的元素个数恢复成2为止,停止左指针的滑动
 * @Author douzhenjun
 * @DATE 2023-10-02
 **/
public class Solution2 {

    public int totalFruit(int[] fruits) {
        int n = fruits.length;
        Map<Integer, Integer> cnt = new HashMap<Integer, Integer>();

        int left = 0, ans = 0;
        for (int right = 0; right < n; right++) {
            cnt.put(fruits[right], cnt.getOrDefault(fruits[right], 0) + 1);
            while (cnt.size() > 2) {
                //如果哈希表里的元素个数超过2,移动左指针,记录的左指针所指的水果的个数-1
                cnt.put(fruits[left], cnt.get(fruits[left]) - 1);
                //如果这时候个数为0,那么相当于这个水果(数字)要被移除
                if (cnt.get(fruits[left]) == 0) {
                    cnt.remove(fruits[left]);
                }
                left++;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}
