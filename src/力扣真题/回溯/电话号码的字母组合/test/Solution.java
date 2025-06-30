package 力扣真题.回溯.电话号码的字母组合.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-03-19
 **/
public class Solution {
    List<String> result = new ArrayList<>();
    Map<String, String> map = new HashMap<>();
    StringBuilder sb = new StringBuilder();

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return result;
        }
        //初始化
        map.put("2", "abc");
        map.put("3", "def");
        map.put("4", "ghi");
        map.put("5", "jkl");
        map.put("6", "mno");
        map.put("7", "pqrs");
        map.put("8", "tuv");
        map.put("9", "wxyz");

        backTracking(digits, 0);
        return result;
    }

    public void backTracking(String digits, int startIndex) {
        if (startIndex == digits.length()) {
            result.add(sb.toString());
            return;
        }

        char chars = digits.charAt(startIndex);
        String strings = map.get(String.valueOf(chars));
        for (int idx = 0; idx < strings.length(); idx++) {
            sb.append(strings.charAt(idx));
            backTracking(digits, startIndex + 1);
            sb.deleteCharAt(sb.length() - 1);
        }

    }
}
