package od真题.总览._109亲子游戏;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-04-11
 **/
public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //读取地图的大小n
        int n = scanner.nextInt();
        //存储糖果数量的二维数组w,初始值为0
        int[][] w = new int[n][n];
        //存储起点坐标的队列
        Queue<int[]> q = new LinkedList<>();
        //存储地图元素的二维数组g
        int[][] g = new int[n][n];
        //读取地图元素并初始化起点和糖果数量数组
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                g[i][j] = scanner.nextInt();
                if (g[i][j] == -3) {
                    q.offer(new int[]{i, j});
                    w[i][j] = 0;
                }
            }
        }
        //四个方向的移动
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        //调用广度优先搜索函数获取结果
        int result = bfs(q, g, w, dx, dy, n);
        System.out.println(result);
    }

    //定义广度优先搜索函数
    private static int bfs(Queue<int[]> q, int[][] g, int[][] w, int[] dx, int[] dy, int n) {
        while (!q.isEmpty()) {
            //从队列中取出队首位置
            int[] t = q.poll();
            int x = t[0];
            int y = t[1];
            //如果当前位置为终点返回糖果数量
            if (g[x][y] == -2) {
                return w[x][y];
            }
            //遍历四个方向
            for (int i = 0; i < 4; i++) {
                int x1 = x + dx[i];
                int y1 = y + dy[i];
                //判断是否越界或者是不可访问的位置
                if (x1 < 0 || x1 >= n || y1 < 0 || y1 >= n || g[x1][y1] == -1) {
                    continue;
                }
                //如果该位置没有访问过,将其加入队列,并初始化糖果数量为0
                if (w[x1][y1] == 0) {
                    q.offer(new int[]{x1, y1});
                    w[x1][y1] = 0;
                }
                //更新糖果数量,取当前位置糖果数和上一步位置的糖果数量之和的最大值
                w[x1][y1] = Math.max(w[x1][y1], Math.max(0, g[x1][y1]) + w[x][y]);
            }
        }
        //如果无法到达终点, 返回-1
        return -1;
    }
}
