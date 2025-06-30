package od真题.总览._60灰度图回复;

import java.util.Scanner;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-03-26
 **/
public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int m = Integer.parseInt(input[0]);
        int n = Integer.parseInt(input[1]);
        int[][] xiangsu = new int[m][n];
        int row = 0;
        int col = 0;
        int now = 2;//现在的位置在一维数组
        while(now < input.length){
            for(int k = 0; k < Integer.parseInt(input[now + 1]); k++){
                if(col >= n){
                    col = 0;
                    row += 1;
                }
                xiangsu[row][col] = Integer.parseInt(input[now]);
                col++;
            }
            now += 2;
        }
        String[] xyInput = scanner.nextLine().split(" ");
        int x = Integer.parseInt(xyInput[0]);
        int y = Integer.parseInt(xyInput[1]);
        System.out.println(xiangsu[x][y]);
        
    }
}
