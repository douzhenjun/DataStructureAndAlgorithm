package 力扣真题.动态规划.买卖股票的最佳时机.III;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-07-02
 **/
public class Main {
    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        int[] prices = {3, 3, 5, 0, 0, 3, 1, 4};
        int[] prices2 = {1, 2, 3, 4, 5};
        System.out.println(solution2.maxProfit(prices));
        int[] prices3 = {7, 6, 4, 3, 1};
        System.out.println(solution2.maxProfit(prices2));
        System.out.println(solution2.maxProfit(prices3));

        Solution3 solution3 = new Solution3();
        System.out.println(solution3.maxProfit(prices));
        System.out.println(solution3.maxProfit(prices2));
        System.out.println(solution3.maxProfit(prices3));

        Solution4 solution4 = new Solution4();
        System.out.println(solution4.maxProfit(prices));
        System.out.println(solution4.maxProfit(prices2));
        System.out.println(solution4.maxProfit(prices3));
        
    }
}
