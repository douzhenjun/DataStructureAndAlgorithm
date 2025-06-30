package 力扣真题.动态规划._01背包问题.一和零;


/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-03-05
 **/
public class TestDemo {
    public static void main(String[] args) {
        String[] strs = new String[]{"10", "0001", "111001", "1", "0"};
        int m = 5;
        int n = 3;
        Solution solution = new Solution();
        solution.findMaxForm(strs, m, n);
    }
}
