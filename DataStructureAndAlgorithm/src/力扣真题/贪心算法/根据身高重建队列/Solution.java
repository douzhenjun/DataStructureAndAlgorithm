package 力扣真题.贪心算法.根据身高重建队列;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description
 * 对数组按照身高降序排列,对于身高一样的,对比他高的人数按照升序排列
 * 因为ki表示比pi要高的人数排在前面,只有高于pi的人排在pi前面才会对ki产生影响,比pi矮的人排在pi前面对pi无影响
 * 所以我们先将hi按照降序排序,这样先排pi,下一个排队的人都不会高于上一个人,那么只要按照ki所指示的位置插入,后面插入的
 * 人即使排在pi前面也不会对pi产生影响,除非h(i+1)==h(i).
 * 如果是这种情况我们让身高相同的按照ki的升序排序,这样一来两个身高相同的人,先排队的是ki较小的, 也就是会排在前面,
 * 后排队的是ki较大的,会排在后面,且后排进来的不会影响先排进来的同等身高的ki.
 * 
 * 答案不能通过测试用例,原因未知
 * @Author douzhenjun
 * @DATE 2024-03-12
 **/
public class Solution {
    public int[][] reconstructQueue(int[][] people) {
        List<List<Integer>> peopleList = new ArrayList<>();
        int len = people.length;
        for (int i = 0; i < len; i++) {
            List<Integer> ele = Arrays.stream(people[i]).boxed().collect(Collectors.toList());
            peopleList.add(ele);
        }
        // 对hi按照从大到小的顺序排序
        peopleList.sort((x, y) -> {
            if(x.get(0) == y.get(0)){
                return Integer.compare(x.get(1), y.get(1));
            }
            return Integer.compare(y.get(0), x.get(0));
        });

        // 定义一个新的空数组,遍历peopleList,按照ki的位置插入
        List<List<Integer>> sortedList = new LinkedList<>();
        for (int i = 0; i < len; i++) {
            List<Integer> ele = peopleList.get(i);
            int index = ele.get(1);
            sortedList.add(index, ele);
        }
        // 将sortedList的值一个一个赋值给int[][]people
        for (int i = 0; i < len; i++) {
            int[] array = sortedList.get(i).stream().mapToInt(Integer::intValue).toArray();
            people[i] = array;
        }
        return people;
    }
}
