package 力扣真题.回溯.重新安排行程;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-03-02
 **/
public class Solution {

    private LinkedList<String> res;
    private LinkedList<String> path = new LinkedList<>();

    public List<String> findItinerary(List<List<String>> tickets) {
        //将票按照终点站字母顺序排序
        Collections.sort(tickets, (a, b) -> a.get(1).compareTo(b.get(1)));
        path.add("JFK");
        boolean[] used = new boolean[tickets.size()];
        backtracking(tickets, used);
        return res;
    }

    private boolean backtracking(List<List<String>> tickets, boolean[] used) {
        //边界条件,如果路径的长度等于票的长度+1,因为首先始发站已经有了,其次每次从tickets的元素中拿到一个终点站,所以最终路径
        //数组的长度相当于票中元素的个数+1
        if (path.size() == tickets.size() + 1) {
            res = new LinkedList<>(path);
            return true;
        }
        for (int i = 0; i < tickets.size(); i++) {
            //如果当前元素没有在上一次递归函数中被遍历过,并且当前元素的第一个元素(起始站)和路径中的最后一个元素(上一站)相等,则将该元素的终点站添加到路径中去
            if (!used[i] && tickets.get(i).get(0).equals(path.getLast())) {
                path.add(tickets.get(i).get(1));
                used[i] = true;

                if (backtracking(tickets, used)) {
                    return true;
                }
                used[i] = false;
                path.removeLast();
            }
        }
        return false;
    }

}
