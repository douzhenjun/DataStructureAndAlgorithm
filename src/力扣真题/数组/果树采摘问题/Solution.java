package 力扣真题.数组.果树采摘问题;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2023-10-02
 **/
public class Solution {
    /**
     * 这个问题可以理解成在数组中找到一个最长的子序列, 该序列满足包含两种数字
     * 暴力解法
     * 定义左右指针, left遍历fruits数组, 定义right=left+1.
     * 定义两个临时变量存放这时候的两种数字
     * right遍历fruits数组, 如果满足不超过temp1和temp2所表示的值, sum++
     * right向右继续滑动, 否则说明上一个right所在的位置是窗口的最大值, 更新result
     * 同时更新sum和temp1,temp2
     */
    public int totalFruit(int[] fruits) {
        if(fruits.length == 0){
            return 0;
        }
        if(fruits.length == 1){
            return 1;
        }
        int sum = 1;//记录中间的窗口的长度
        int result = 0;//返回的结果
        int temp1 = -1;//记录中间值
        int temp2 = -1;//记录中间值
        for (int left = 0; left < fruits.length - 1; left++) {
            temp1 = fruits[left];
            int right = left + 1;
            while (right < fruits.length) {
                if (fruits[right] == temp1) {
                    sum++;
                    right++;
                } else if (temp2 == -1) {
                    temp2 = fruits[right];
                    sum++;
                    right++;
                } else if (fruits[right] == temp2) {
                    sum++;
                    right++;
                } else {
                    break;
                }
            }
            //跳出循环需要重置中间值,更新结果
            temp2 = -1;
            result = Math.max(result, sum);
            sum = 1;
        }
        return result;
    }
}
