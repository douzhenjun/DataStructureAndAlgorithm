package od真题.总览._45围棋的气;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-03-25
 **/
public class Solution {
    public static void main(String[] args) {
        int[][] g = new int[19][19];
        Scanner scanner = new Scanner(System.in);
        int[] b = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] w = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        //测试
//        System.out.println(Arrays.stream(b).boxed().collect(Collectors.toList()));
//        System.out.println(Arrays.stream(w).boxed().collect(Collectors.toList()));
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        for (int i = 0; i < b.length; i += 2) {
            int x = b[i];
            int y = b[i + 1];
            g[x][y] = 1;
        }
        for(int i = 0; i < w.length; i += 2){
            int x = w[i];
            int y = w[i + 1];
            g[x][y] = 2;
        }
        //初始化黑棋和白棋的气数量
        int res1 = 0;//黑棋
        int res2 = 0;//白棋
        
        for(int i = 0; i < 19; i++){
            for(int j = 0; j < 19; j++){
                if(g[i][j] != 0){//如果当前位置有棋子,则跳过
                    continue;
                }
                //遍历该位置的四周,只要有棋子,则该类棋子的气数+1
                for(int d = 0; d < 4; d++){
                    int x = i + dx[d];
                    int y = j + dy[d];
                    //如果越界或者相邻位置无棋子,则跳过
                    if(x < 0 || x >= 19 || y < 0 || y >= 19 || g[x][y] == 0){
                        continue;
                    }
                    if(g[x][y] == 1){
                        res1++;
                    }
                    if(g[x][y] == 2){
                        res2++;
                    }
                }
            }
        }
        System.out.println(res1 + " " + res2 + " ");
    }
}
