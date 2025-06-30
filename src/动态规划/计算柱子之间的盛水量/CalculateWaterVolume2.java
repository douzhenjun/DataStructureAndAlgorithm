package 动态规划.计算柱子之间的盛水量;

/**
 * 我们的目的在于计算蓄水量. 利用双指针, left和right一开始分别指向0位置. i遍历left+1到(数组长度-1)之间. 为了确定right
 * 的位置, 首先需要使得right要与left至少间隔一个柱子, 另外这个right所指的柱子要高于它左边和右边的柱子(
 * 如果有的话), 这时候计算left和right之间的柱子所存的水量.
 *
 * 计算存水量的方式如下:
 * j遍历left和right之间. 规定三个求和量,分别是water_left, water_right和water_total. 其中water_total作为
 * 最终返回的数字, water_left和water_right作为一个临时的存水量, 一个假设左边的柱子更短, 增加左边柱子和中间
 * 柱子的高度差; 一个假设右边的柱子更短, 增加右边柱子和中间柱子的高度差. 将water_left和water_right的最小值
 * 作为最终的存水量加入到总的存水量中.
 */
public class CalculateWaterVolume2 {

    public int calculate(int[] arr) {
        //左指针,右指针,总存水量
        int left = 0;
        int right = 0;
        int water_total = 0;

        //遍历数组的中间部分
        for(int i = 1; i < arr.length; i++){
            //如果出现中间柱子的高度大于其相邻的左边柱子的高度,则让这个柱子作为左边柱子
            if(i == left+1 && arr[left] <= arr[i]){
                left = i;
                continue;
            }

            //如果这个柱子高于他左边的柱子也高于它右边的柱子,此时这个柱子作为右边的柱子
            if(i > left+1){
                if(i < arr.length-1 && arr[i] > arr[i-1] && arr[i] > arr[i+1]
                    ||  arr[i] > arr[i-1] && i == arr.length-1)
                {
                    right = i;
                    int water_left = 0;
                    int water_right = 0;
                    for(int j = left+1; j < right; j++){
                        water_left += arr[left]-arr[j];
                        water_right += arr[right]-arr[j];
                    }
                    water_total += Math.min(water_left, water_right);
                    left = right;
                }
            }
        }
        return water_total;
    }

    public static void main(String[] args) {
        CalculateWaterVolume2 cwv2 = new CalculateWaterVolume2();

        int[] height1 = {3, 2, 5, 7, 4, 6, 8, 3};

        int water_total = cwv2.calculate(height1);

        System.out.println("height1对应的柱子的接水容量为:"+water_total);

        System.out.println("------------------------------------------");

        int[] height2 = {0,1,0,2,1,0,1,3,2,1,2,1};

        water_total = cwv2.calculate(height2);

        System.out.println("height2对应的柱子的接水容量为:"+water_total);


        System.out.println("------------------------------------------");

        int[] height3 = {0, 2, 3, 4, 5, 6, 7};

        water_total = cwv2.calculate(height3);

        System.out.println("height3对应的柱子的接水容量为:"+water_total);

        System.out.println("------------------------------------------");

        int[] height4 = {7, 6, 5, 4, 3, 2, 1};

        water_total = cwv2.calculate(height4);

        System.out.println("height4对应的柱子的接水容量为:"+water_total);

        System.out.println("------------------------------------------");

        int[] height5 = {7, 6};

        water_total = cwv2.calculate(height5);

        System.out.println("height5对应的柱子的接水容量为:"+water_total);

        System.out.println("------------------------------------------");

        int[] height6 = {5, 4, 3, 4, 5, 6};

        water_total = cwv2.calculate(height6);

        System.out.println("height6对应的柱子的接水容量为:"+water_total);

        System.out.println("------------------------------------------");

        int[] height7 = {6, 5, 4, 3, 4, 5};

        water_total = cwv2.calculate(height6);

        System.out.println("height7对应的柱子的接水容量为:"+water_total);


    }
}
