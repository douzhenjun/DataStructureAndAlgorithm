package 测试题;

import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

public class Test01 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        TreeSet<Integer> set = new TreeSet<>();
        // TreeSet set = new TreeSet();
        for(int i=0;i<N;i++){
            Integer num = in.nextInt();
            set.add(num);
        }
        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }
}
