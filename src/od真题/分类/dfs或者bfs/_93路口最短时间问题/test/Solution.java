package od真题.分类.dfs或者bfs._93路口最短时间问题.test;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-04-14
 **/
public class Solution {
    
    static int[][][] ans;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    
    class Node implements Comparable<Node>{
        int x, y, p, v;
        public Node(int x, int y, int p, int v){
            this.x = x;
            this.y = y;
            this.p = p;
            this.v = v;
        }
        
        public int compareTo(Node b){
            return Integer.compare(b.v, this.v);
        }
    }
    
    public int clacTime(int[][] lights, int timePerRoad, int rowStart, int colStart, int rowEnd, int colEnd){
        ans = new int[10][10][4];
        PriorityQueue<Node> q = new PriorityQueue<>();
        for(int[][] array2D : ans){
            for(int[] array1D : array2D){
                Arrays.fill(array1D, Integer.MAX_VALUE);
            }
        }
        
        for(int i = 0; i < 4; i++){
            q.add(new Node(rowStart, colStart, i, 0));
            ans[rowStart][colStart][i] = 0;//起点的时间为0
        }
        
        while(!q.isEmpty()){
            Node t = q.poll();
            if(t.v > ans[t.x][t.y][t.p]){
                continue;
            }
            for(int i = 0; i < 4; i++){
                if(i == 2){
                    continue;
                }
                int tp = (t.p + i ) % 4;
                int tx = t.x + dx[tp];
                int ty = t.y + dy[tp];
                if(tx < 0 || tx >= lights.length || ty < 0 || ty >= lights.length){
                    continue;
                }
                int tv = t.v + timePerRoad;
                if(i != 1){
                    tv += lights[t.x][t.y];
                }
                if(tv >= ans[tx][ty][tp]){
                    continue;
                }
                ans[tx][ty][tp] = tv;
                q.add(new Node(tx, ty, tp, tv));
            }
        }
        return Math.min(ans[rowEnd][colEnd][0], Math.min(ans[rowEnd][colEnd][1], ans[rowEnd][colEnd][2]));
    }
}
