package od真题.总览._89任务处理;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-04-04
 **/
public class Solution {
    static List<Integer>[] a = new List[100005];
    
    public static int solve(){
        int ans = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < 100005; i++){
            //第一步:从队列中移除已经结束的任务
            while(!pq.isEmpty() && pq.peek() < i){
                pq.poll();
            }
            //第二步:将当前时刻开始的任务加入队列
            for(int j = 0; j < a[i].size(); j++){
                pq.add(a[i].get(j));
            }
            //第三步:从队列中取出结束时间最早的任务,安排在这一天
            if(!pq.isEmpty()){
                ans++;
                pq.poll();
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0; i < 100005; i++){
            a[i] = new ArrayList<>();
        }
        for(int i = 0; i < n; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            a[x].add(y);
        }
        System.out.println(solve());
    }
}
