package 测试题;

import java.util.*;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2023/8/29
 **/
public class Meetings {

    public static final int MORNING_LIMIT = 180;//上午最长时间
    public static final int AFTERNOON_LEFT = 180;//下午最短时间
    public static final int AFTERNOON_RIGHT = 240;//下午最长时间
    public static final String MORINING = "上午";
    public static final String AFTERNOON = "下午";

    public static void assign(Integer[] minutes, int days) {
        Map<String, List<Integer>> assignments = new LinkedHashMap<>();
        List<Integer> minutesList = Arrays.asList(minutes);
        minutesList.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        int sum = 0;
        int i = 0;
        int j = minutesList.size() - 1;

        int nowDay = 1;//第几天
        while (i < j) {
            List<Integer> assignMorning = new ArrayList<>();
            while (sum + minutesList.get(i) <= MORNING_LIMIT && i < j) {
                assignMorning.add(minutesList.get(i));
                sum += minutesList.get(i);
                i++;
            }
            while (sum + minutesList.get(j) <= MORNING_LIMIT && i < j) {
                assignMorning.add(minutesList.get(j));
                sum += minutesList.get(j);
                j--;
            }
            assignments.put("第" + nowDay + "天" + MORINING, assignMorning);
            sum = 0;
            List<Integer> assignAfternoon = new ArrayList<>();
            while (sum + minutesList.get(i) <= AFTERNOON_RIGHT && i < j) {
                assignAfternoon.add(minutesList.get(i));
                sum += minutesList.get(i);
                i++;
            }
            while (sum + minutesList.get(j) <= AFTERNOON_RIGHT && i < j) {
                assignAfternoon.add(minutesList.get(j));
                sum += minutesList.get(j);
                j--;
            }
            if(sum < AFTERNOON_LEFT){
                break;
            }
            assignments.put("第" + nowDay + "天" + AFTERNOON, assignAfternoon);
            nowDay++;
            sum = 0;
        }
        if (nowDay > days+1 || i < j) {
            System.out.println("无法在" + days + "天内安排如此多的会议!");
        } else {
            System.out.println("本次会议行程为" + assignments);
        }
    }

    public static void main(String[] args) {
        Integer[] minutes = new Integer[]{60, 45, 30, 45, 45, 5, 60, 45, 30, 30, 45, 60, 60, 45, 30, 30, 60, 30, 30};
        assign(minutes, 2);
    }

}
