package od真题.分类.排序._65测试用例执行计划;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-03-27
 **/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);  // 创建Scanner对象用于接收输入
        int n = sc.nextInt();  // 读取输入的整数n
        int m = sc.nextInt();  // 读取输入的整数m
        int[] a = new int[n + 1];  // 创建整数数组a，长度为n+1
        for (int i = 1; i <= n; i++)
            a[i] = sc.nextInt();  // 读取n个整数并存入数组a
        List<Integer>[] list = new ArrayList[m];  // 创建整数列表的数组list，长度为m
        for (int i = 0; i < m; i++)
            list[i] = new ArrayList<>();  // 初始化数组list的每个元素为一个空的整数列表
        sc.nextLine();  // 读取换行符，准备读取下一行输入
        for (int i = 0; i < m; i++) {
            String s = sc.nextLine();  // 读取一行字符串
            int[] arr = Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();  // 将字符串按空格分割并转为整数数组
            for (int j = 0; j < arr.length; j++)
                arr[j] = a[arr[j]];  // 将整数数组arr中的每个元素替换为数组a中对应索引的值
            int sum = Arrays.stream(arr).sum();  // 计算整数数组arr的和
            list[i].add(sum);  // 将和添加到数组list的第i个元素中
            list[i].add(i + 1);  // 将i+1添加到数组list的第i个元素中
        }
        Arrays.sort(list, (o1, o2) -> {  // 对数组list进行排序
            if (o1.get(0) != o2.get(0))
                return o2.get(0) - o1.get(0);
            return o1.get(1) - o2.get(1);
        });
        for (int i = 0; i < m; i++)
            System.out.println(list[i].get(list[i].size() - 1));  // 输出数组list的第i个元素的最后一个值
    }
}

