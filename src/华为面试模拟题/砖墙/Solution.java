package 华为面试模拟题.砖墙;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-04-24
 **/
class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        int n = wall.size();
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            int sum = 0;
            for(int j = 0; j < wall.get(i).size() - 1; j++){
                sum += wall.get(i).get(j);
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
            sum = 0;
        }
        int ans = n;
        for(int u : map.keySet()){
            int cnt = map.get(u);//间隙i的出现次数
            ans = Math.min(ans, n - cnt);
        }
        return ans;
    }
}

