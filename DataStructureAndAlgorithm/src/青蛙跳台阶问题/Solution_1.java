package 青蛙跳台阶问题;

import java.util.HashMap;

/**
 *  问题描述:如果青蛙只有两种跳台阶的方式,一个是跳一级,一个是跳两级,
 *  那么面对一个n级台阶,青蛙可以有多少种跳跃方式?
 */

public class Solution_1 {
    public static int f(int n){
        if(n < 3){
            return n;
        }
        return f(n-1) + f(n-2);
    }
    private static int f2(int n, HashMap<Integer,Integer> map){
        if (n < 3) return n;
        if(map.containsKey(n))
            return map.get(n);
        int first = f2(n-1, map);
        int second = f2(n-2, map);
        int sum = first + second;
        map.put(n, sum);
        return sum;
    }

    private static int f3(int n){
        if(n < 3){
            return n;
        }
        int first = 1, second = 2, sum = 0;
        while (n --> 2) {
            sum = first + second;
            first = second;
            second = sum;
        }
        return sum;
    }

    public static void main(String[] args) {
        int step = 45;
        long time = System.nanoTime();
        System.out.println(f(step));
        System.out.println("代码优化前时间: " + (double)(System.nanoTime()-time)/1000000000 + "s.");
        time = System.nanoTime();
        System.out.println(f2(step, new HashMap<Integer, Integer>()));
        System.out.println("代码优化后时间: " + (double)(System.nanoTime()-time)/1000000000 + "s.");
        time = System.nanoTime();
        System.out.println(f3(step));
        System.out.println("代码非递归时间: " + (double)(System.nanoTime()-time)/1000000000 + "s.");
    }
}
