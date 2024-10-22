package 力扣真题.回溯.组合问题;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-09-01
 **/
public class Solution2 {

    List<List<Integer>> list = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(n, k, 1);
        return list;
    }

    private void backtrack(int n, int k, int startIndex) {
        if (k == 0) {
            list.add(new ArrayList<>(path));
            return;
        }
        if (startIndex <= n - k) {
            //不选当前值,k不变
            backtrack(n, k, startIndex + 1);
        }
        //选择当前值,k要减1
        path.add(startIndex);
        backtrack(n, k - 1, startIndex + 1);
        path.remove(path.size() - 1);
    }
}
