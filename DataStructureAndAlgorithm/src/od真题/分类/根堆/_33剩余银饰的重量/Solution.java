package od真题.分类.根堆._33剩余银饰的重量;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-03-24
 **/
public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();//读取数组长度
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> b - a);
        
        for(int i = 0; i < n; i++){
            int x = scanner.nextInt();
            heap.add(x);//将元素插入大根堆
        }
        
        while(heap.size() > 2){
            int z = heap.poll();
            int y = heap.poll();
            int x = heap.poll();
            
            if(x == z){
                continue;
            }else if(x == y && y < z){
                heap.add(z - y);
            }else if(x < z && y == z){
                heap.add(y - x);
            }else if(x < y && y < z){
                heap.add(Math.abs(z - y - (y - x)));
            }
        }
        
        //如果堆为空,则输出0,否则输出堆顶元素
        if(heap.size() == 0){
            System.out.println("0");
        }else{
            System.out.println(heap.poll());
        }
    }
}
