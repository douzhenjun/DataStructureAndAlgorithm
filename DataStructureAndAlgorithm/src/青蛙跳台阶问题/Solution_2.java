package 青蛙跳台阶问题;

/**
 * 问题描述:
 * 跟前一个问题不同的是,现在的青蛙可以从任何一级台阶跳到n级,
 * 那么请问青蛙跳到一个n级的台阶总共需要多少种跳法?
 */
public class Solution_2 {
    public static void main(String[] args) {
        int step = 30;
        long time = System.nanoTime();
        long kinds = jumpTypes_2(step);
        System.out.println(kinds);
        System.out.println("递归方法所花的时间为:" + (double)(System.nanoTime()-time)/1000000000 + ".s");

        time = System.nanoTime();
        kinds = jumpTypes(1, step, 1);
        System.out.println(kinds);
        System.out.println("非递归方法所花的时间为:" + (double)(System.nanoTime()-time)/1000000000 + ".s");
    }
    public static long jumpTypes(int num, int max, int kinds){
        if(num >= max){
            return kinds;
        }else{
           return jumpTypes(num+1, max, 2*kinds);
        }
    }

    public static long jumpTypes_2(int n){
        if(n == 1){
            return 1;
        }
        return 1 << (n-1);
    }
}
