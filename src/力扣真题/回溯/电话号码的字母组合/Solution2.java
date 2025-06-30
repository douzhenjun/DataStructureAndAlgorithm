package 力扣真题.回溯.电话号码的字母组合;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 使用dfs方式
 * @Author douzhenjun
 * @DATE 2024-11-10
 **/
public class Solution2 {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.isEmpty()) {
            return res;
        }
        char[][] tab = {{'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'}, {'j', 'k', 'l'},
                {'m', 'n', 'o'}, {'p', 'q', 'r', 's'}, {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}};
        dfs(res, 0, digits, tab, "");
        return res;
    }

    private void dfs(List<String> res, int index, String digits, char[][] tab, String path) {
        if(path.length() == digits.length()){
            res.add(path);
            return;
        }
        char[] chars = tab[digits.charAt(index) - '2'];
        //访问当前节点的所有子节点
        for (int i = 0; i < chars.length; i++) {
            dfs(res, index + 1, digits, tab, path + chars[i]);
        }
    }
}
