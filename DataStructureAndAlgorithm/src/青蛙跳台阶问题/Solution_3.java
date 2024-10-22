package 青蛙跳台阶问题;

/**
 *      问题描述:一只青蛙一次可以跳上1级台阶,也可以跳上2级,...也可以跳上m级(m <=n).
 *      求该青蛙跳上一个n级的台阶总共有多少种跳法?
 */
public class Solution_3 {
    public static void main(String[] args) {
        int steps = 10;
        //测试一下StepsInM运行结果是否正确
        long num = StepsInM(1, steps, 1);
        System.out.println(num);

        num = jumpTypes(2, 4, 1, 1);
        System.out.println(num);
    }

    public static long jumpTypes(int m, int n, int num, long kind){
        if(n <= m){
            return StepsInM(1, n, 1);
        }else{
            return StepsInM(1, m, 1) + jumpTypes(m+1, n-m, num, kind);
        }
    }

    public static long StepsInM(int num, int m, long kind){
        if(num >= m){
            return kind;
        }else{
            return StepsInM(num+1, m, 2*kind);
        }
    }
}
