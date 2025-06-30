package 力扣真题.回溯.重新安排行程.test;

import java.util.*;

/**
 * @Description 默写一遍
 * @Author douzhenjun
 * @DATE 2024-03-03
 **/
public class Solution {
    private List<String> res = new ArrayList<>();
    Map<String, Map<String, Integer>> map = new HashMap<>();

    public List<String> findItinerary(List<List<String>> tickets) {
        //初始化
        res.add("JFK");
        for (List<String> ticket : tickets) {
            Map<String, Integer> temp;
            if (map.containsKey(ticket.get(0))) {
                temp = map.get(ticket.get(0));
                temp.put(ticket.get(1), temp.getOrDefault(ticket.get(1), 0) + 1);
            } else {
                temp = new TreeMap<>();
                temp.put(ticket.get(1), 1);
            }
            map.put(ticket.get(0), temp);
        }
        backtracking(tickets.size() + 1);
        return res;
    }

    private boolean backtracking(int targetNum) {
        if (res.size() == targetNum) {
            return true;
        }
        String last = res.get(res.size() - 1);
        if (map.containsKey(last)) {
            for (Map.Entry<String, Integer> target : map.get(last).entrySet()) {
                int count = target.getValue();
                if (count > 0) {
                    res.add(target.getKey());
                    target.setValue(count - 1);
                    if (backtracking(targetNum)) {
                        return true;
                    }
                    target.setValue(count);
                    res.remove(res.size() - 1);
                }
            }
        }

        return false;
    }
}
