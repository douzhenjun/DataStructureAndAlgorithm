package 力扣真题.回溯.重新安排行程;

import java.util.*;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-03-02
 **/
public class Solution2 {
    private Deque<String> res;
    private Map<String, Map<String, Integer>> map;
    
    public List<String> findItinerary(List<List<String>> tickets){
        map = new HashMap<String, Map<String,Integer>>();//起始站:{终点站:出现次数}
        res = new LinkedList<>();
        for(List<String> t : tickets){
            Map<String, Integer> temp;
            if(map.containsKey(t.get(0))){
                temp = map.get(t.get(0));
                temp.put(t.get(1), temp.getOrDefault(t.get(1), 0)+1);//每个行程对象包含起始站-终点站,分别
            }else{
                temp = new TreeMap<>();//TreeMap的意思是对终点站按照字典序排序
                temp.put(t.get(1), 1);
            }
            map.put(t.get(0), temp);
        }
        res.add("JFK");
        backTracking(tickets.size());
        return new ArrayList<>(res);
    }
    
    private boolean backTracking(int ticketNum){
        if(res.size() == ticketNum + 1){
            return true;
        }
        String last = res.getLast();//获得结果集中的最后一个元素,也就是上一个站
        if(map.containsKey(last)){//以上一个站为key去map中查找对应的终点站和出现次数>0
            for(Map.Entry<String, Integer> target : map.get(last).entrySet()){
                int count = target.getValue();//从行程票中找到以结果集最后一个元素为起点的行程,找到它终点站的出现次数
                if(count > 0){
                    res.add(target.getKey());//如果终点站的出现次数大于0,就将这个终点站添加到res中
                    target.setValue(count - 1);
                    if(backTracking(ticketNum)){
                        return true;
                    }
                    res.removeLast();//回溯,
                    target.setValue(count);
                }
            }
        }
        return false;
    }
}
