package od真题.总览._54开源项目的热度榜单;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Description
 * 热度计算公式
 * H = W(watch)x*watch + W(star)x*star + W(fork)x*star + W(issue)x*issue + W(mr)x*mr
 * 项目热度相同的, 按照项目名字转换成全小写后的字典排序
 * @Author douzhenjun
 * @DATE 2024-03-26
 **/
public class Solution {
    static class Node {
        String name;
        int hot;
        String nameLower;
        
        Node(String name, int hot, String nameLower){
            this.name = name;
            this.hot = hot;
            this.nameLower = nameLower;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] w = new int[5];
        
        //读取权重数组
        for(int i = 0; i < 5; i++){
            w[i] = scanner.nextInt();
        }
        Node[] a = new Node[n];
        //选取每个节点的信息
        for(int i = 0; i < n; i++){
            String s = scanner.next();
            int[] v = new int[5];
            //读取节点权值
            for(int j = 0; j < 5; j++){
                v[j] = scanner.nextInt();
            }
            int hot = 0;
            for(int j = 0; j < 5; j++){
                hot += v[j] * w[j];
            }
            
            String t = s.toLowerCase();
            a[i] = new Node(s, hot, t);
        }
        //首先按热度降序,然后按名称升序
        Arrays.sort(a, (x, y) -> {
            if(x.hot != y.hot){
                return Integer.compare(y.hot, x.hot);
            }
            return x.nameLower.compareTo(y.nameLower);
        });
        //输出排序后的节点名称
        for(int i = 0; i < n; i++){
            System.out.println(a[i].name);
        }
    }
}
