package od真题.总览._05查询交换功率最优时间段;

import java.util.Scanner;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-03-22
 **/
public class TestDemos {
    public static void main(String[] args) {
        int sum = calculateInputSum();
        System.out.println("输入的数字之和为: " + sum);
    }

    public static int calculateInputSum() {
        Scanner scanner = new Scanner(System.in);
        int sum = 0;

        System.out.println("请输入整数，以空格分隔，回车表示输入完成:");

        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                sum += scanner.nextInt();
            } else {
                break; // 当输入不是整数时，跳出循环
            }
        }

        scanner.close();
        return sum;
    }
}

    
