package od真题.总览._46求幸存者之和;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-03-25
 **/
import java.util.*;

class Main {
    public static int sumOfLeft(int[] nums, int jump, int left) {
        List<Integer> list = new ArrayList<>();
        // 将nums数组中的元素添加到动态数组中
        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
        }
        int now = 1;
        // 当动态数组的长度大于left时，进行移动和删除操作
        while (list.size() > left) {
            now += jump; // 移动jump步
            now %= list.size(); // 取模确保索引不越界
            list.remove(now); // 删除当前位置的元素
        }
        int sum = 0;
        // 计算剩下元素的和
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i);
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] arr = s.split(",");
        int n = arr.length;
        int[] nums = new int[n];
        int jump = Integer.parseInt(sc.nextLine());
        int left = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(arr[i]);
        }
        // 调用sumOfLeft函数计算结果
        int res = sumOfLeft(nums, jump, left);
        System.out.println(res);
    }
}

