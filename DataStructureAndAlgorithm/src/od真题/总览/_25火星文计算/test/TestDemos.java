package od真题.总览._25火星文计算.test;

import od真题.总览._25火星文计算.test.Solution;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-03-23
 **/
public class TestDemos {
    public static void main(String[] args) {
        String str = "7#6$5#12";
//        String str = "1$2#3";
        Solution solution = new Solution();
        System.out.println(solution.getResult(str));
    }
}
