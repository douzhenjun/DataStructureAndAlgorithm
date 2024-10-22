package od真题.总览._05查询交换功率最优时间段;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入数字，以回车结束：");
        while (scanner.hasNext()) {
            String input = scanner.next();

            // 判断输入是否为数字
            if (input.matches("\\d+")) {
                int number = Integer.parseInt(input);
                System.out.println("输入的数字是：" + number);
            } else {
                System.out.println("输入的不是数字，请重新输入：");
            }
        }
    }
}
