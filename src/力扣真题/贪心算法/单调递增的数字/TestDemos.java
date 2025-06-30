package 力扣真题.贪心算法.单调递增的数字;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-03-13
 **/
public class TestDemos {
    public static void main(String[] args) {
        int n = 299;
        Solution solution = new Solution();
        solution.monotoneIncreasingDigits(n);
        
        n = 332;
        solution.monotoneIncreasingDigits(n);
    }
}
