package od真题.分类.dfs或者bfs._32悄悄话;

import java.util.Scanner;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-03-24
 **/
public class Solution {
    static int[] w;
    static int n;
    static int res = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] wStr = scanner.nextLine().split(" ");
        n = wStr.length + 1;
        w = new int[n];
        
        for(int i = 1; i < n; i++){
            w[i] = Integer.parseInt(wStr[i-1]);
        }
        dfs(1, 0);//参数1:节点下标,参数2:记录到最后一层节点的最大和
        System.out.println(res);
    }
    
    static void dfs(int u, int sum){
        if(u >= n || w[u] == -1){//如果节点索引超出范围或节点的值为-1,则返回
            return;
        }
        res = Math.max(res, sum + w[u]);//更新最大和
        dfs(2 * u, sum + w[u]);
        dfs(2 * u + 1, sum + w[u]);
    }
}
