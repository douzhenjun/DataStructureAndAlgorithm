package od真题.分类.dfs或者bfs._83最长连续手牌;

import java.util.Scanner;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-04-03
 **/
public class Solution {

    static int[] w;
    static String[] color;
    static int n;
    static int[] st;
    static int res;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] wStr = scanner.nextLine().split(" ");//读取牌的数字
        w = new int[wStr.length];
        for (int i = 0; i < wStr.length; i++) {
            w[i] = Integer.parseInt(wStr[i]);
        }
        color = scanner.nextLine().split(" ");
        n = w.length;
        st = new int[n];
        res = 0;
        dfs(0, -1, "");
        System.out.println(res);
    }

    static void dfs(int cnt, int preNum, String preColor) {
        res = Math.max(res, cnt);//更新结果变量res
        for (int i = 0; i < n; i++) {//遍历牌的数量
            if (st[i] == 1) {
                continue;
            }
            if (preNum == -1 || preNum == w[i] || preColor.equals(color[i])) {//满足题目条件
                st[i] = 1;//标记当前牌被选择
                dfs(cnt + 1, w[i], color[i]);//递归调用dfs函数
                st[i] = 0;//取消当前牌的选择
            }
        }
    }
}
