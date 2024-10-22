package 双指针求最多水的容器;

/*
*   给你n个非负整数a1, a2, ..., an,每个数代表坐标中的一个点(i, ai).
*   在坐标内画n条垂直线,垂直线i的两个端点分别为(i, ai)和(i, 0).找出其中的两条线,使得它们与
*   x轴共同构成的容器可以容纳最多的水.
* */
public class MaxAreaBetweenTwoPillars {

    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int maxArea = maxArea1(height);
        System.out.println(maxArea);
    }

    public static int maxArea1(int[] height){
        int maxArea = 0, left = 0, right = height.length - 1;
        int area = 0;
        while(left < right){
            //计算面积,面积等于宽 * 高, 宽就是left和right之间的距离,
            //left 和 right 所对应的最低高度
            area = Math.min(height[left], height[right]) * (right - left);
            //保存计算过的最大的面积
            maxArea = Math.max(maxArea, area);
            //柱子矮的往中间靠
            if(height[left] < height[right]){
                left++;
            }else{
                right--;
            }
        }
        return maxArea;
    }
    public static int maxArea(int[] height){
        //最大面积变量,左指针下标,数组height的长度
        int maxArea = 0, left = 0, length = height.length;
        //也是面积变量,因为需要另一个表示面积的变量用来和当前的最大面积比较
        int area;
        //右指针下标
        int right;

        //从前面开始找
        while(left < length){
            right = length - 1;
            while(right > left){
                if(height[right] < height[left]){
                    right--;
                }else{
                    break;
                }
            }
            //计算矩形的面积
            area = height[left] * (right - left);
            //保存计算过的最大的面积
            maxArea = Math.max(maxArea, area);
            left++;
        }
        //上面的遍历完成后,得到的不一定时每个高度所对应的最大面积.
        //从后面开始找
        right = length - 1;
        while(right > 0){
            left = 0;
            while(right > left){
                if(height[right] > height[left]){
                    left++;
                }else{
                    break;
                }
            }
            area = height[right] * (right - left);
            maxArea = Math.max(maxArea, area);
            right--;
        }
        return maxArea;
    }
}

