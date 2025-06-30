package 力扣真题.回溯.复原ip地址;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-02-29
 **/
public class Solution {
    List<String> result = new ArrayList<>();
    List<String> partList = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        if (s == null || s.length() < 4) {
            return result;
        }
        backtracking(s, 0);
        return result;
    }

    public void backtracking(String s, int startIndex) {
        if (partList.size() == 4) {
            if (startIndex < s.length()) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            for (String str : partList) {
                sb.append(str);
                sb.append(".");
            }
            sb.deleteCharAt(sb.length() - 1);//将最后添加的.去掉
            result.add(sb.toString());
        }

        StringBuilder sb2 = new StringBuilder();
        for (int i = startIndex; i < s.length(); i++) {
            sb2.append(s.charAt(i));
            if (sb2.length() > 1 && sb2.charAt(0) == '0') {
                continue;
            }
            try {
                Long num = Long.parseLong(sb2.toString());
                if (0 <= num && num <= 255) {
                    partList.add(sb2.toString());
                    backtracking(s, i + 1);
                    partList.remove(partList.size() - 1);
                }
            } catch (Exception e) {
            }

        }

    }
}
