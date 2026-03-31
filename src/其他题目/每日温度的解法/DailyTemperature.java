package 每日温度的解法;

public class DailyTemperature {
    public int[] dailyTemperatures(int[] T){
        int[] res = new int[T.length];
        for(int i = res.length - 1; i >= 0; i--){
            int j = i + 1;
            while (j < res.length) {
                if (T[j] > T[i]) {
                    res[i] = j - i;
                    break;
                } else if (res[j] == 0) {
                    break;
                } else {
                    j += res[j];
                }
            }
        }
        return res;
    }
}

