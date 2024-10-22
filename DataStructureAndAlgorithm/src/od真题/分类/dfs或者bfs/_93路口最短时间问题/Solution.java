package od真题.分类.dfs或者bfs._93路口最短时间问题;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-04-05
 **/
public class Solution {
    class Node implements Comparable<Node> {
        int x, y, p, v; // 节点的位置和时间

        public Node(int x, int y, int p, int v) {
            this.x = x;//节点坐标1
            this.y = y;//节点坐标2
            this.p = p;//节点的上一个节点过来的方向(上右下左)
            this.v = v;//节点的时间
        }

        @Override
        public int compareTo(Node b) {
            return Integer.compare(b.v, this.v); // 重载运算符，按照时间从小到大排序
        }
    }

    // 存储最短时间的数组，ans[i][j][k]就代表从起点走到(i,j)点，并且最后一步的方向为k的最小花费
    int[][][] ans;
    int[] dx = {-1, 0, 1, 0}; // 上右下左四个方向的x坐标变化
    int[] dy = {0, 1, 0, -1}; // 上右下左四个方向的y坐标变化

    public int calcTime(int[][] lights, int timePerRoad, int rowStart, int colStart, int rowEnd, int colEnd) {
        ans = new int[10][10][4];
        PriorityQueue<Node> q = new PriorityQueue<>();
        for (int[][] array2D : ans) {
            for (int[] array1D : array2D) {
                Arrays.fill(array1D, Integer.MAX_VALUE);
            }
        }

        for (int i = 0; i < 4; i++) {
            q.add(new Node(rowStart, colStart, i, 0)); // 将起点的四个方向入队列
            ans[rowStart][colStart][i] = 0; // 起点的时间为0
        }

        while (!q.isEmpty()) {
            Node t = q.poll(); // 取出队列中时间最小的节点
            if (t.v > ans[t.x][t.y][t.p]) continue; // 如果当前节点的时间大于已经记录的最小时间，跳过
            for (int i = 0; i < 4; i++) {
                if (i == 2) continue; // 遇到下方向时跳过
                int tp = (t.p + i) % 4; // 计算新方向
                int tx = t.x + dx[tp], ty = t.y + dy[tp]; // 计算新位置
                if (tx < 0 || tx >= lights.length || ty < 0 || ty >= lights[tx].length) continue; // 如果新位置超出边界，跳过
                int tv = t.v + timePerRoad; // 计算新时间
                if (i != 1) tv += lights[t.x][t.y]; // 如果不是右转方向，加上当前位置的红绿灯时间
                if (tv >= ans[tx][ty][tp]) continue; // 如果新时间大于已经记录的最小时间，跳过
                ans[tx][ty][tp] = tv; // 更新最短时间
                q.add(new Node(tx, ty, tp, tv)); // 将新节点入队列
            }
        }
        return Math.min(ans[rowEnd][colEnd][0], Math.min(ans[rowEnd][colEnd][1], ans[rowEnd][colEnd][2])); // 返回终点的最短时间
    }
}

