package 力扣真题.贪心算法.分发糖果;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-03-12
 **/
public class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        if (n == 0) {
            return 0;
        }
        //定义从左到右遍历的序列和从右到左遍历的序列
        int[] leftToRight = new int[n];
        int[] rightToLeft = new int[n];

        //初始化
        for (int i = 0; i < leftToRight.length; i++) {
            leftToRight[i] = 1;
        }
        for (int i = 0; i < rightToLeft.length; i++) {
            rightToLeft[i] = 1;
        }

        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                //保证从左到右的最少个数
                leftToRight[i] = leftToRight[i - 1] + 1;
            }
        }


        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                //保证从右到左的最少个数
                rightToLeft[i] = rightToLeft[i + 1] + 1;
            }
        }

        int result = 0;
        for (int i = 0; i < n; i++) {
            result += Math.max(leftToRight[i], rightToLeft[i]);
        }
        return result;
    }
}
