package od真题.总览._47手机App防沉迷系统.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-04-01
 **/
public class Solution {
    static int convertToMinutea(String time) {
        String[] timeStr = time.split(":");
        int hour = Integer.parseInt(timeStr[0]);
        int minute = Integer.parseInt(timeStr[1]);
        return hour * 60 + minute;
    }


    static class App {
        String name;
        int priority;//app优先级
        int startTime;//起始时间(包含)
        int endTime;//结束时间(不包含)

        public App(String name, int priority, int startTime, int endTime) {
            this.name = name;
            this.priority = priority;
            this.startTime = startTime;
            this.endTime = endTime;
        }

        boolean isOverlap(App other) {
            return this.startTime < other.endTime || other.startTime < this.endTime;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        App[] apps = new App[n];
        int ignoreApps = 0;
        for (int i = 0; i < n; i++) {
            String name = scanner.next();
            int priority = scanner.nextInt();
            String startTimeStr = scanner.next();
            String endTimeStr = scanner.next();
            int startTime = convertToMinutea(startTimeStr);
            int endTime = convertToMinutea(endTimeStr);
            if (startTime >= endTime) {
                ignoreApps++;
                continue;
            }
            App app = new App(name, priority, startTime, endTime);
            apps[i - ignoreApps] = app;
        }
        n -= ignoreApps;

        //定义最终的数组
        List<App> resultList = new ArrayList<>();
        resultList.add(apps[0]);
        for (int i = 1; i < n; i++) {
            int size = resultList.size();
            boolean isOverLap = false;
            for(int j = 0; j < size; j++){
                if(apps[i].isOverlap(resultList.get(j))){
                    isOverLap = true;
                    if(apps[i].priority > resultList.get(j).priority){
                        resultList.add(j, apps[i]);
                        resultList.remove(j + 1);
                        break;
                    }
                }
            }
            if(!isOverLap){
                resultList.add(apps[i]);
            }
        }
        
        String lastInput = scanner.next();
        int time = convertToMinutea(lastInput);
        String output = "NA";
        for(App app : resultList){
            if(app.startTime <= time && time < app.endTime){
                output = app.name;
                break;
            }
        }
        System.out.println(output);
    }
}
