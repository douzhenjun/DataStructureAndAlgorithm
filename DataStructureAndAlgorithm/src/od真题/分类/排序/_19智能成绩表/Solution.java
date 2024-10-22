package od真题.分类.排序._19智能成绩表;

import java.util.*;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-03-23
 **/
public class Solution {
    //静态代码块,用作初始化
    static class Student{
        String name;
        List<Integer> scores;
    }
    static Student[] students = new Student[10004];
    static int keyIndex;//课程名的下标
    
    static Comparator<Student> studentComparator = new Comparator<Student>() {
        @Override
        public int compare(Student o1, Student o2) {
            if(!o1.scores.get(keyIndex).equals(o2.scores.get(keyIndex))){
                return o2.scores.get(keyIndex) - o1.scores.get(keyIndex);
            }
            return o1.name.compareTo(o2.name);
        }
    };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, m;
        n = sc.nextInt();
        m = sc.nextInt();
        //初始化课程名数组
        String[] courseNames = new String[1000];
        for(int i = 0; i < m; i++){
            courseNames[i] = sc.next();
        }
        //初始化学生数组,包括name,scores,其中scores不但要添加每个学科的乘积,最后还要添加上总成绩
        for(int i = 1; i <= n; i++){
            students[i] = new Student();
            students[i].name = sc.next();
            int sum = 0;
            students[i].scores = new ArrayList<>();
            for(int j = 0; j < m; j++){
                int score = sc.nextInt();
                students[i].scores.add(score);
                sum += score;
            }
            students[i].scores.add(sum);
        }
        //获得学科的名称,去对应的课程名数组中拿到下标,如果没有,就默认是最后的位置
        //课程名数组的下标和每个学生的成绩表下标是完全一致的
        String key = sc.next();
        keyIndex = m;
        for(int i = 0; i < m; i++){
            if(courseNames[i].equals(key)){
                keyIndex = i;
                break;
            }
        }
        Arrays.sort(students, 1, n+1, studentComparator);
        for(int i = 1; i <= n; i++){
            System.out.print(students[i].name);
            if(i == n){
                System.out.println();
            }else{
                System.out.print(" ");
            }
        }
    }
    
}
