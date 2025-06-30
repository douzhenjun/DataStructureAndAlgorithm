package HashSetDemo;

import java.util.HashSet;
import java.util.Set;

public class HashSetDemo {
    public static void main(String[] args) {
       Set<Person> all = new HashSet<Person>();
       all.add(new Person("张三", 15));
       all.add(new Person("李四", 24));
       all.add(new Person("李四", 24));
       all.add(new Person("王五", 12));

//       Person p1 = new Person("zhangsan", 12);
//       Person p2 = new Person("zhangsan", 12);
//       System.out.println(p1.equals(p2));

        System.out.println(all);
    }
}
