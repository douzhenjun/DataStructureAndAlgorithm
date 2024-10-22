package 力扣真题.贪心算法.单调递增的数字;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-03-13
 **/
public class Solution {

    public int monotoneIncreasingDigits(int n) {
        int result = n;
        while (true) {
            if (result < 10) {
                return result;
            }
            int curNum = result;
            int lastBit = -1;
            int curBit = 0;
            while (curNum > 0) {
                curBit = curNum % 10;
                if (lastBit != -1 && curBit > lastBit) {
                    break;
                }
                curNum = curNum / 10;
                lastBit = curBit;
            }
            if (curNum > 0) {
                result--;
            } else {
                return result;
            }
        }
    }
    
}
