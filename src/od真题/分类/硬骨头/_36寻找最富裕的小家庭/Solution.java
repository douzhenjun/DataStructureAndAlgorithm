package od真题.分类.硬骨头._36寻找最富裕的小家庭;

import java.util.Scanner;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-03-24
 **/
public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] a = new int[n + 1];//权值集合

        for (int i = 1; i <= n; i++) {
            a[i] = scanner.nextInt();
        }

        int[] fa = new int[n + 1];//存储每个节点的父节点
        int[][] e = new int[n + 1][n + 1];//存储树的边关系
        
        //读入树的边关系,构建树结构
        int index = 1;
        for(int i = 1; i < n; i++){
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            fa[y] = x;
            e[x][index++] = y;
        }
        for(int row = 0; row < n+1; row++){
            for(int col = 0; col < n + 1; col++){
                System.out.print(e[row][col] + " ");
            }
            System.out.println();
        }
        //存储最大的权值和
        int ans = 0;
        for(int i = 1; i <= n; i++){
            int sum = a[i];
            for(int j = 1; j < index; j++){
                sum += a[e[i][j]];
            }
            ans = Math.max(ans, sum);
        }
        System.out.println(ans);
    }
}
