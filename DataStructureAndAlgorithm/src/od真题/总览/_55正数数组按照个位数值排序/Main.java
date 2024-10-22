package od真题.总览._55正数数组按照个位数值排序;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-03-26
 **/
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        //保存元素及其对应的位置
        List<Pair<String, Integer>> w = new ArrayList<>();
        String[] strings = input.split(",");
        for(int i = 0; i < strings.length; i++){
            Pair<String, Integer> pr = new Pair<>(strings[i], i);
            w.add(pr);
        }
        w.sort((a, b) -> {
            if (a.getFirst().charAt(a.getFirst().length() - 1) != b.getFirst().charAt(b.getFirst().length() - 1))
                return a.getFirst().charAt(a.getFirst().length() - 1) - b.getFirst().charAt(b.getFirst().length() - 1);
            return a.getSecond() - b.getSecond();
        });

        for (int i = 0; i < w.size(); i++) {
            System.out.print(w.get(i).getFirst());
            if (i != w.size() - 1) {
                System.out.print(",");
            }
        }
    }

    static class Pair<T1, T2> {
        private T1 first;
        private T2 second;

        public Pair(T1 first, T2 second) {
            this.first = first;
            this.second = second;
        }

        public T1 getFirst() {
            return first;
        }

        public T2 getSecond() {
            return second;
        }
    }
}
