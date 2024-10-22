package 华为面试模拟题.排列数;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-05-17
 **/
public class Solution {
    private List<String> result = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();

    public void getResult(int n) {
        backTracking(n, path, result);
        result.forEach(System.out::println);
    }

    private void backTracking(int limit, List<Integer> path, List<String> result) {
        if (path.size() == limit) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < path.size(); i++) {
                sb.append(path.get(i));
            }
            result.add(sb.toString());
            return;
        }
        for (int i = 1; i <= 3; i++) {
            int size = path.size();
            if (size > 0 && path.get(size - 1) == i) {
                continue;
            }
            if(size >= 3 && i == path.get(size - 2) && path.get(size - 1) == path.get(size - 3)){
                continue;
            }
            if(size >= 5 && i == path.get(size - 3) && path.get(size - 1) == path.get(size - 4) && path.get(size - 2) == path.get(size - 5)){
                continue;
            }
            path.add(i);
            backTracking(limit, path, result);
            path.remove(path.size() - 1);
        }
    }
}
