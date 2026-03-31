package 每日温度的解法;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int [] array = {73, 74, 75, 71, 69, 72, 76, 73};
        DailyTemperature dt = new DailyTemperature();
        int [] nextDayList = dt.dailyTemperatures(array);
        System.out.println("需要等待的天数列表为:\n" + Arrays.toString(nextDayList));
    }
}
