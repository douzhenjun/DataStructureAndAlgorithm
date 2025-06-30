package od真题.总览._80结对编程;

import java.util.Scanner;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-04-03
 **/
public class Solution {
    static long ans = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] w = new int[n];
        
        for(int i = 0; i < n; i++){
            w[i] = scanner.nextInt();
        }
        calculate(w);
        calculate(reverseArray(w));
        System.out.println(ans);
    }
    
    static void calculate(int[] w){
        int n = w.length;
        int[] R = new int[n];
        int[] L = new int[n];
        
        //计算每个元素左边比它小的元素个数
        for(int i = 0; i < n; i++){
            for(int j = 0; j < i; j++){
                if(w[j] < w[i]){
                    L[i]++;
                }
            }
            //计算每个元素右边比它大的元素个数
            for(int j = i + 1; j < n; j++){
                if(w[j] > w[i]){
                    R[i]++;
                }
            }
        }
        //计算逆序对的数量
        for(int i = 0; i < n; i++){
            ans += L[i] * R[i];
        }
    }
    
    //反转数组的方法
    static int[] reverseArray(int[] arr){
        int n = arr.length;
        int[] reversed = new int[n];
        //将数组反转
        for(int i = 0; i < n; i++){
            reversed[i] = arr[n - i + 1];
        }
        return reversed;
    }
}
