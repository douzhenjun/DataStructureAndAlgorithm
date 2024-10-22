package 华为面试模拟题.Z字形变换;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-04-28
 **/
public class TestDemos {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "PAYPALISHIRING";
        int numRows = 4;
        System.out.println(solution.convert(s, numRows));
    }
}
