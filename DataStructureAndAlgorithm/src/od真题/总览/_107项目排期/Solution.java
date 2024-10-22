package od真题.总览._107项目排期;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @Description
 * N个开发人员, 做M个工作, 最少需要多少天?
 * 用二分去枚举最终的天数x, 判断这N个人能否在x天完成所有的任务, 其实就是看能否把这些任务分成至多N组, 
 * 而且每一组的份数都不超过x.
 * @Author douzhenjun
 * @DATE 2024-04-08
 **/
public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> w = new ArrayList<>();//w用来保存工作量,单位为天
        //读取输入,将每个工作的时间添加到列表中
        while (scanner.hasNextInt()) {
            w.add(scanner.nextInt());
        }
        //获取人数n
        int n = w.get(w.size() - 1);
        w.remove(w.size() - 1);

        //对工作时间进行降序排序
        Collections.sort(w, Collections.reverseOrder());
        //初始化二分查找的左右边界
        int l = 1;
        int r = w.stream().mapToInt(Integer::intValue).sum();
        while (l < r) {
            int mid = (l + r) >> 1;
            //初始化选择数组,标记
            int[] choose = new int[n];
            if (check(mid, 0, choose, w)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        System.out.println(l);
    }

    //定义检查函数,判断在x天内是否能完成n个人的m个工作
    //x表示目标天数
    //cnt表示此时应该处理的元素在w的位置
    //choose表示每个人的工作量
    //w表示存储了工作量的列表
    private static boolean check(int x, int cnt, int[] choose, List<Integer> w) {
        if (cnt == w.size()) {
            return true;
        }
        for (int i = 0; i < choose.length; i++) {
            //跳过遍历和上一个位置元素相同的i
            if (i > 0 && choose[i] == choose[i - 1]) {
                continue;
            }
            //如果第i个人的工作量加上这一次的工作量不超过x,那么就加上这一次的工作量
            if (choose[i] + w.get(cnt) <= x) {
                choose[i] += w.get(cnt);
                //如果工作量被分配完毕,返回true
                if (check(x, cnt + 1, choose, w)) {
                    return true;
                }
                choose[i] -= w.get(cnt);
            }
        }
        return false;
    }
}
