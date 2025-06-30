package od真题.总览._37小明的绝对值排序;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-03-24
 **/
public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int h = scanner.nextInt();
        int n = scanner.nextInt();
        Integer[] a = new Integer[n];//注意这里使用Integer[]而不是int[]
        
        for(int i = 0; i < n; i++){
            a[i] = scanner.nextInt();
        }
        Arrays.sort(a, (x, y) -> {
            int diffX = Math.abs(x - h);
            int diffY = Math.abs(y - h);
            
            if(diffX == diffY){
                return x.compareTo(y);
            }else{
                return Integer.compare(diffX, diffY);
            }
        });
        for(int i = 0; i < n; i++){
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
}
