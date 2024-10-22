package 力扣真题.回溯.分割回文串;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-02-29
 **/
public class Solution {
    List<List<String>> result = new ArrayList<>();
    LinkedList<String> path = new LinkedList<>();

    public List<List<String>> partition(String s) {
        partition(s, 0);
        return result;
    }

    private boolean isHuiwen(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i <= j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    private void partition(String s, int startIndex) {
        if (startIndex == s.length()) {
            result.add(new LinkedList<>(path));
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = startIndex; i < s.length(); i++) {
            sb.append(s.charAt(i));
            if (isHuiwen(sb.toString())) {
                path.add(sb.toString());
                partition(s, i + 1);
                path.removeLast();
            }
        }
    }
}
