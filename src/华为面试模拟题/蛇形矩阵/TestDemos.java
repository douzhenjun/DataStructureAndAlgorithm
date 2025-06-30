package 华为面试模拟题.蛇形矩阵;

import org.junit.Test;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-04-24
 **/
public class TestDemos {
    public static void main(String[] args) {
        int N = 4;
        Solution solution = new Solution();
        solution.convert(N);
        System.out.println();
        N = 5;
        solution.convert(N);
        System.out.println();
        N = 1;
        solution.convert(N);
    }
    
    @Test
    public void test01(){
        Solution2 solution2 = new Solution2();
        int N = 5;
        solution2.convert(N);
        N = 6;
        solution2.convert(N);
        N = 1;
        solution2.convert(N);
    }
}
