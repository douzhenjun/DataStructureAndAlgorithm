package od真题.分类.根堆._30执行任务赚积分;

import org.junit.Test;

import java.util.*;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-03-24
 **/
public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt();//任务数量
        int T = scanner.nextInt();//总时间
        //使用列表存储任务,每个任务用一个长度为2的数组表示
        List<int[]> v = new ArrayList<>();
        //输入每个任务的开始时间和价值
        for(int i = 0; i < n; i++){
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            v.add(new int[]{a, b});
        }
        
        v.sort(Comparator.comparingInt(x -> x[0]));
        getResult(n, T, v);
    }
    
    @Test
    public void test01(){
        int n = 4;
        int T = 3;
        List<int[]> v = new ArrayList<>();
        v.add(new int[]{1, 2});
        v.add(new int[]{1, 3});
        v.add(new int[]{1, 4});
        v.add(new int[]{3, 5});
        getResult(n, T, v);
    }

    private static void getResult(int n, int T, List<int[]> v) {
        //用来存储当前时刻的任务价值
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        //处理任务
        for(int i = 0; i < n; i++){
            //如果当前任务在当前时刻没有过期
            if(v.get(i)[0] > heap.size()){
                //如果堆的大小小于上限T,则直接添加任务价值
                if(heap.size() < T){
                    heap.add(v.get(i)[1]);
                }
                //如果堆已满,比较堆顶任务价值与当前任务价值
                //如果当前任务价值大于堆顶任务价值,则替换堆顶任务价值
                else if(heap.peek() < v.get(i)[1]){
                    heap.poll();
                    heap.add(v.get(i)[1]);
                }
                //如果当前任务在当前时刻已过期,比较堆顶任务价值与当前任务价值
                //如果当前任务价值大于堆顶任务价值,则替换堆顶任务价值
            }else{
                if(v.get(i)[1] > heap.peek()){
                    heap.poll();
                    heap.add(v.get(i)[1]);
                }
            }
        }
        //计算总任务价值
        long res = 0;
        while(!heap.isEmpty()){
            res += heap.poll();
        }
        System.out.println(res);
    }
}
