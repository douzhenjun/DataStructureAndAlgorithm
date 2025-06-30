package od真题.总览._59找朋友;

import java.util.Scanner;
import java.util.Stack;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-03-26
 **/
public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] w = new int[n];
        int i = 0;
        while(i < n){
            w[i] = scanner.nextInt();
            i++;
        }
        getFriendsIdx(w);
    }
    
    private static void getFriendsIdx(int[] w){
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[w.length];
        stack.push(0);
        for(int i = 1; i < w.length; i++){
            while(!stack.isEmpty() && w[stack.peek()] < w[i]){
                res[stack.peek()] = i;
                stack.pop();
            }
           stack.push(i);
        }
        for(int i = 0; i < res.length; i++){
            System.out.print(res[i]+" ");
        }
    }
}
