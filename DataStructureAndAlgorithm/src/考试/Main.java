package 考试;

import java.util.*;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-04-18
 **/
public class Main {
    static StringBuilder res = new StringBuilder();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] putArray = scanner.nextLine().split(",");
        String[] getArray = scanner.nextLine().split(",");
        //判断是否有重复
        HashSet<String> hashSet = new HashSet<>();
        hashSet.addAll(Arrays.asList(putArray));
        if(hashSet.size() < putArray.length){
            System.out.println("NO");
            return;
        }
        HashSet<String> hashSet1 = new HashSet<>();
        hashSet1.addAll(Arrays.asList(getArray));
        if(hashSet1.size() < getArray.length){
            System.out.println("NO");
            return;
        }
        //判断A中的元素在B中是否存在
        for(String x : hashSet){
            if(!hashSet1.contains(x)){
                System.out.println("NO");
                return;
            }
        }
        Deque<String> queue = new LinkedList<>();//辅助队列
        int index = 0;//标记getArray的下标
        for (int i = 0; i < putArray.length; i++) {
            queue.offerLast(putArray[i]);
            while(!queue.isEmpty() && index < putArray.length){
                String left = queue.peekFirst();
                String right = queue.peekLast();
                String target = getArray[index];
                if (left.equals(target) || right.equals(target)) {
                    if (left.equals(right)) {
                        queue.pollFirst();
                        res.append("L");
                    } else if(left.equals(target)) {
                        queue.pollFirst();
                        res.append("L");
                    }else{
                        queue.pollLast();
                        res.append("R");
                    }
                    index += 1;
                }else{
                    break;
                }
            }
        }
        if(!queue.isEmpty()){
            res = new StringBuilder();
            res.append("NO");
        }
        System.out.println(res.toString());
    }
}
