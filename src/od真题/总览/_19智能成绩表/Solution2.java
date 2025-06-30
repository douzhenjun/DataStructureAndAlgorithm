package od真题.总览._19智能成绩表;

import java.util.*;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-03-31
 **/
public class Solution2 {
    
    static class Student{
        String name;
        Map<String, Integer> scores;
        int sum;//总分
        
        public Student(String name) {
            this.name = name;
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();//学生人数
        int m = scanner.nextInt();//科目数量
        String[] subjects = new String[m];
        for(int i = 0;i < m; i++){
            subjects[i] = scanner.next();
        }
        List<Student> students = new ArrayList<>();
        for(int i = 0; i < n; i++){
            Student student = new Student(scanner.next());
            student.scores = new HashMap<>();
            int j = 0;
            while(j < m){
                int score = scanner.nextInt();
                student.scores.put(subjects[j], score);
                student.sum += score;
                j++;
            }
            students.add(student);
        }
        String key = scanner.next();//最后一行的输入,科目名
        students.sort((x, y) -> {
            if(!x.scores.containsKey(key)){
                if(x.sum != y.sum){
                    return y.sum - x.sum;
                }
            }else{
                if(!Objects.equals(x.scores.get(key), y.scores.get(key))){
                    return y.scores.get(key) - x.scores.get(key);
                }
            }
            return x.name.compareTo(y.name);
        });
        //打印
        for(Student student : students){
            System.out.print(student.name + " ");
        }
    }
}
