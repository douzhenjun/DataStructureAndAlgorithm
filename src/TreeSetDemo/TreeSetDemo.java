package TreeSetDemo;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetDemo {
    public static void main(String[] args) {
       Set<Person> all = new TreeSet<>();
       all.add(new Person("张三", 15));
       all.add(new Person("李四", 24));
       all.add(new Person("赵六", 24));
       all.add(new Person("王五", 12));


       System.out.println(all);
    }
}
