package od真题.总览._30执行任务赚积分.test;

import java.util.*;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-03-24
 **/
public class Solution {
    public static void main(String[] args) {
        List<int[]> v = new ArrayList<>();
        int[][] array = {{1, 2}, {1, 3}, {1, 4}, {3, 5}};
        for(int i = 0 ; i < array.length; i++){
            v.add(array[i]);
        }
        getResult(3, v);
    }
    public static void getResult(int T, List<int[]> v){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        v.sort(Comparator.comparingInt(x -> x[0]));
        for(int i = 0; i < v.size(); i++){
            if(v.get(i)[0] > pq.size()){
                if(pq.size() < T){
                    pq.add(v.get(i)[1]);
                }else{
                    if(v.get(i)[1] > pq.peek()){
                        pq.poll();
                        pq.add(v.get(i)[1]);
                    }
                }
            }else{
                if(v.get(i)[1] > pq.peek()){
                    pq.poll();
                    pq.add(v.get(i)[1]);
                }
            }
        }
        int result = 0;
        while(!pq.isEmpty()){
            result += pq.poll();
        }
        System.out.println(result);
    }
}
