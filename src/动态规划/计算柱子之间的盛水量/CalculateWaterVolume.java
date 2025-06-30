package 动态规划.计算柱子之间的盛水量;

public class CalculateWaterVolume {
    public int trap(int[] height) {
        if (height.length <= 2) {
            return 0;
        }
        //找到最高柱子的下标
        int max = Integer.MIN_VALUE;
        int maxIndex = -1;
        for (int i = 0; i < height.length; i++) {
            if (height[i] > max) {
                max = height[i];
                maxIndex = i;
            }
        }
        //统计最高柱子左边能接的雨水数量
        int left = height[0];
        int right = 0;
        int water = 0;
        for (int i = 1; i < maxIndex; i++) {
            right = height[i];
            if (right > left) {
                left = right;
            } else {
                water += left - right;
            }
        }
        //统计最高柱子右边能接的雨水数量
        right = height[height.length - 1];
        for (int i = height.length - 2; i > maxIndex; i--) {
            left = height[i];
            if (height[i] > right) {
                right = left;
            } else {
                water += right - left;
            }
        }
        return water;
    }
}
