package od真题.分类.dfs或者bfs._82分月饼.test;

import java.util.Scanner;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-04-13
 **/
public class Solution {
    static int res = 0;
    static int m, n;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        m = scanner.nextInt();
        n = scanner.nextInt();
        dfs(0, n, 1, n);
        System.out.println(res);
    }

    private static void dfs(int u, int sum, int down, int up) {
        if (u == m) {
            if(sum == 0){
                res++;
            }
            return;
        }
        if(up < down || sum < 0 || sum < down){
            return;
        }
        for(int i = down; i <= up; i++){
            dfs(u + 1, sum - i, i, Math.min(sum - i, i + 3));
        }
    }
}
