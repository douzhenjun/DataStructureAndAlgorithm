package od真题.总览._99_5G网络建设;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-04-06
 **/
public class Solution {
    static int[] fa = new int[200];
    static List<Integer[]> a = new ArrayList<>();
    
    //合并两个集合,返回是否成功合并
    public static int merge(int x, int y){
        int fx = getfa(x);
        int fy = getfa(y);
        if(fx == fy){
            return 0;
        }
        fa[fx] = fy;
        return 1;
    }
    
    //使用路径压缩找到节点x的根节点
    public static int getfa(int x){
        if(fa[x] == x){
            return x;
        }
        return fa[x] = getfa(fa[x]);
    }

    //初始化并查集
    public static void init(){
        for(int i = 1; i < fa.length; i++){
            fa[i] = i;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        init();
        for(int i = 1; i <= m; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            int z = sc.nextInt();
            int p = sc.nextInt();
            if(p == 1){
                merge(x, y);
            }else{
                a.add(new Integer[]{x, y, z});//否则将边加入到边列表中
            }
        }
        //按照边的权值排序
        a.sort((a, b) -> {
            return a[2].compareTo(b[2]);
        });
        int ans = 0;
        for(Integer[] x : a){
            if(merge(x[0], x[1]) == 1){
                ans += x[2];//如果成功合并两个节点,累加权重
            }
        }
        //判断所有节点是否连通
        boolean ok = true;
        for(int i = 1; i<= n; i++){
            if(getfa(i) != getfa(1)){
                ok = false;
            }
        }
        if(ok){
            System.out.println(ans);
        }else{
            System.out.println(-1);
        }
    }
}
