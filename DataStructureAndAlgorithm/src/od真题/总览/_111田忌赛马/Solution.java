package od真题.总览._111田忌赛马;

import java.util.*;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-04-11
 **/
public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();
        List<Integer> w = new ArrayList<>();

        while (scanner.hasNext()) {
            w.add(scanner.nextInt());
        }
        int m = w.size();

        //将列表分成两个列表a和b
        for (int i = 0; i < m; i++) {
            if (i < m / 2) {
                a.add(w.get(i));
            } else {
                b.add(w.get(i));
            }
        }
        //对列表a进行排序
        Collections.sort(a);

        int n = a.size();
        boolean[] st = new boolean[n];//使用数组,a的第i个位置是否已使用
        int[] nums = new int[n];//a的全排列结果的一种
        Map<Integer, Integer> cnts = new HashMap<>();//保存使得a[0~i]>b[0~i]的最大的i及其出现次数

        //调用深度优先搜索函数
        dfs(0, a, b, st, nums, cnts);
        int maxcnt = 0;
        int maxnum = cnts.getOrDefault(0, 0);

        //寻找最大的相同数字数量和对应的排列情况数量
        for (Map.Entry<Integer, Integer> entry : cnts.entrySet()) {
            int k = entry.getKey();
            int v = entry.getValue();
            if (k > maxcnt) {
                maxcnt = k;
                maxnum = v;
            }
        }
        //输出最大的相同数字数量
        System.out.println(maxnum);
    }

    //定义深度优先搜索函数
    private static void dfs(int u, List<Integer> a, List<Integer> b, boolean[] st, int[] nums, Map<Integer, Integer> cnts) {
        if (u == a.size()) {
            int cnt = 0;
            for (int i = 0; i < a.size(); i++) {
                if (nums[i] > b.get(i)) {
                    cnt += 1;
                }
            }
            cnts.put(cnt, cnts.getOrDefault(cnt, 0) + 1);
            return;
        }
        //遍历数字进行排列
        for (int i = 0; i < a.size(); i++) {
            if (st[i] || (i > 0 && a.get(i).equals(a.get(i - 1)) && st[i - 1])){
                continue;
            }
            st[i] = true;
            nums[u] = a.get(i);
            dfs(u + 1, a, b, st, nums, cnts);
            st[i] = false;
        }
    }
}
