package od真题.分类.dfs或者bfs._82分月饼;

import java.util.Scanner;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-04-03
 **/
public class Solution {

    static int res = 0;
    static int n, m;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().trim().split(" ");//读取用户的输入
        m = Integer.parseInt(input[0]);//m个员工
        n = Integer.parseInt(input[1]);//n个月饼
        dfs(0, n, 1, n);
        System.out.println(res);
    }

    //u表示分配到第u个人
    //sum表示分配到第u个人时剩余的月饼数量
    //down表示第u个人应该获得的月饼数量的最小值
    //up表示第u个人应该获得的月饼数量的最大值
    static void dfs(int u, int sum, int down, int up) {
        if (u == m) {
            if (sum == 0) {
                res++;
            }
            return;
        }

        if (down > sum || sum < 0 || down > up) {
            return;
        }

        for (int i = down; i <= up; i++) {
            dfs(u + 1, sum - i, i, Math.min(sum - i, i + 3));
        }
    }
}
