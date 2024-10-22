package NumberCal;

public class NumberCalculate {
    public static void numCal(int index, int[] arr, int times) {
        if (index >= arr.length){
            System.out.print("第" + times + "次输出:");
            for(int k = 0; k < arr.length; k++){
                System.out.print(arr[k]);
            }
            System.out.println();
//            times += 1;
        }
        else{
            for (int j = 0; j < 10; j++) {
                int i = index;
                if (i == 0) {
                    arr[i] = j;
                    i += 1;
                    numCal(i, arr, times);
                    times++;
                }
                else if (i > 0 && j != arr[i - 1]) {
                    arr[i] = j;
                    i += 1;
                    numCal(i, arr, times);
                    times++;
                }
            }
        }
    }
}