package 力扣真题.数组.长度最小的子数组;

/**
 * @Description 暴力解法
 * @Author douzhenjun
 * @DATE 2023-10-02
 **/
public class Tests {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 2, 4, 3};
        System.out.println(Solution.minSubArrayLen01(7, nums));//2

        System.out.println(Solution.minSubArrayLen02(7, nums));//2
    }
}
