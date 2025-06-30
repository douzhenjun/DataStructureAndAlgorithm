package 力扣真题.回溯.给表达式添加运算符;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-07-26
 **/
class Solution2 {
    List<String> ans;

    void dfs(char[] path, int pathNext, long noChange, long changing, char[] nums, int index, int target) {
        if (index == nums.length) {
            if (noChange + changing == target)
                ans.add(new String(path, 0, pathNext));
            return;
        }
        long cur = 0;
        int next = pathNext + 1;
        for (int i = index; i < nums.length; i++) {
            cur = cur * 10 + nums[i] - '0';
            path[next++] = nums[i];
            path[pathNext] = '+';
            dfs(path, next, noChange + changing, cur, nums, i + 1, target);
            path[pathNext] = '-';
            dfs(path, next, noChange + changing, -cur, nums, i + 1, target);
            path[pathNext] = '*';
            dfs(path, next, noChange, changing * cur, nums, i + 1, target);
            if (nums[index] == '0')
                break;
        }
    }

    public List<String> addOperators(String num, int target) {
        ans = new ArrayList<>();
        int n = num.length();
        if (n == 0)
            return ans;

        char[] nums = num.toCharArray();

        char[] path = new char[n * 2 - 1];
        long start = 0;
        for (int i = 0; i < n; i++) {
            start = start * 10 + nums[i] - '0';
            path[i] = nums[i];
            dfs(path, i + 1, 0, start, nums, i + 1, target);
            if (start == 0)
                break;
        }
        return ans;
    }
}
