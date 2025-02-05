package 力扣真题.回溯.电话号码的字母组合;

import java.util.LinkedList;
import java.util.List;

/**
 * @Description 使用bfs方式
 * @Author douzhenjun
 * @DATE 2024-11-10
 **/
public class Solution1 {
    public List<String> letterCombinations(String digits) {
        LinkedList<String> res = new LinkedList<>();
        // 空判断
        if (digits == null || digits.isEmpty()) {
            return res;
        }
        char[][] tab = {{'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'}, {'j', 'k', 'l'},
                {'m', 'n', 'o'}, {'p', 'q', 'r', 's'}, {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}};
        res.add("");
        while (res.peek().length() != digits.length()) {
            String remove = res.poll();
            char[] chars = tab[digits.charAt(remove.length()) - '2'];
            // 相当于之前所有节点的子节点
            for (int i = 0; i < chars.length; i++) {
                res.add(remove + chars[i]);
            }
        }
        return res;
    }
}
