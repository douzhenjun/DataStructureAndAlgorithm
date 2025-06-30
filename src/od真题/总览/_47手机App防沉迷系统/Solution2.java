package od真题.总览._47手机App防沉迷系统;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Description 
 * 数组中不能包含冲突的时间段的App,如果有,则去掉优先级较低的那个,如果优先级相同,则去掉后出现的那个
 * @Author douzhenjun
 * @DATE 2024-03-26
 **/
public class Solution2 {
    static class App {
        String name;
        int priority;
        int startTime;
        int endTime;

        public App(String name, int priority, int startTime, int endTime) {
            this.name = name;
            this.priority = priority;
            this.startTime = startTime;
            this.endTime = endTime;
        }

        // 判断当前应用程序与另一个应用程序是否有时间重叠
        public boolean hasOverlap(App other) {
            return this.startTime < other.endTime && other.startTime < this.endTime;
        }


        @Override
        public String toString() {
            return "App{" +
                    "name='" + name + '\'' +
                    ", priority=" + priority +
                    ", startTime=" + startTime +
                    ", endTime=" + endTime +
                    '}';
        }
    }

    // 将时间字符串转换为分钟表示的整数
    public static int convertToMinutes(String time) {
        String[] arr = time.split(":");
        int hour = Integer.parseInt(arr[0]);
        int minute = Integer.parseInt(arr[1]);
        return hour * 60 + minute;
    }

    // 将输入字符串转换为应用程序对象
    public static App convertToApp(String input) {
        String[] arr = input.split(" ");
        String name = arr[0];
        int priority = Integer.parseInt(arr[1]);
        int startTime = convertToMinutes(arr[2]);
        int endTime = convertToMinutes(arr[3]);
        return new App(name, priority, startTime, endTime);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numApps = scanner.nextInt();
        scanner.nextLine();

        App[] apps = new App[numApps];
        int ignoredApps = 0;

        for (int i = 0; i < numApps; i++) {
            String input = scanner.nextLine();
            App tempApp = convertToApp(input);
            if (tempApp.startTime >= tempApp.endTime) {
                ignoredApps++;
                continue;
            }
            apps[i - ignoredApps] = tempApp;
        }
        numApps -= ignoredApps;//有效App数组位
        //用来保存有效的App数组,去掉产生时间冲突的app对象
        List<App> resultApps = new ArrayList<>();
        resultApps.add(apps[0]);
        for(int i = 1; i < numApps; i++){
            boolean isOverlap = false;
            for(int j = 0; j < resultApps.size(); j++){
                if(apps[i].hasOverlap(resultApps.get(j))){
                    isOverlap = true;
                    if(apps[i].priority > resultApps.get(j).priority){
                        resultApps.add(j, apps[i]);
                        resultApps.remove(j+1);
                        break;
                    }
                }
                if(!isOverlap){
                    resultApps.add(apps[i]);
                }
            }
        }

        resultApps.stream().forEach(System.out::println);

        int givenTime = convertToMinutes(scanner.nextLine());  // 给定时间
        String answer = "NA";

        // 遍历结果列表，找到包含给定时间的应用程序
        for (App app : resultApps) {
            if (app.startTime <= givenTime && givenTime < app.endTime) {
                answer = app.name;
                break;
            }
        }

        System.out.println(answer);  // 输出结果

    }
}
