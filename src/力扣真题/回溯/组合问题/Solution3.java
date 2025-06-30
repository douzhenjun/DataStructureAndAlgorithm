package 力扣真题.回溯.组合问题;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-09-01
 **/
public class Solution3 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        //边界条件判断
        if (n < k || k == 0) {
            return res;
        }
        //不选择第n个,从前面n-1个数字中选择k-1个构成一个集合
        res = combine(n - 1, k - 1);
        //如果res是空,添加一个空的集合
        if (res.isEmpty()) {
            res.add(new ArrayList<>());
        }
        //前面在前面选择的集合res中的每个子集合的后面添加一个数字n
        for (List<Integer> list : res) {
            list.add(n);
            //res中不光要包含选择第n个数字的集合,也要包含不选择第n个数字的集合
            res.addAll(combine(n - 1, k));
        }
        return res;
    }
}
