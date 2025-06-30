package od真题.总览._72数组去重和排序;

import java.util.*;

import static 多线程练习.ReentrantLock.ReenterLockDemo.i;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-03-30
 **/
public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        
        List<Integer> w = new ArrayList<>();
        Map<Integer, Integer> cnts = new HashMap<>();
        for(String s : input.split(",")){
            int num = Integer.parseInt(s);
            w.add(num);
            cnts.put(num, cnts.getOrDefault(num, 0) + 1);
        }
        Map<Integer, Integer> mp = new HashMap<>();
        for(int i = 0; i < w.size(); i++){
            if(!mp.containsKey(w.get(i))){
                mp.put(w.get(i), i);
            }
        }
        
        List<Integer> res = new ArrayList<>(mp.keySet());
        res.sort((a, b) -> {
            if(!cnts.get(a).equals(cnts.get(b))){
                return cnts.get(b) - cnts.get(a);
            }
            return mp.get(a) - mp.get(b);
        });
        
        for(int i = 0; i < res.size(); i++){
            System.out.println(res.get(i));
            if(i + 1 < res.size()){
                System.out.print(",");
            }
        }
    }
}
