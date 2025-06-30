package java基础案例.泛型演示.上界下界通配符;

import java.util.ArrayList;
import java.util.List;

public class GenericTest {
    public static void main(String[] args) {
        //1 采用上界泛型通配符?extends
        List<? extends Fruit> list = new ArrayList<>();

        //1.1 用上界通配符修饰的容器对象不能写入,除了null
//        list.add(new Strawberry("red", 0.8, true));

//        list.add(new Banana("yellow", 0.5, true));

        //1.2 也不能修改List的任何元素
//        list.set(0, new Strawberry("red", 0.8, true));

        //1.3 上界通配符的正确用法:读取而非写入
        //1.3.1 声明一个可包含具体类的列表,并写入一些对象
        List<Fruit> ls1 = new ArrayList<>();
        ls1.add(new Strawberry("red", 0.8, true));
        ls1.add(new Banana("yellow", 0.5, true));
        //1.3.2 上面声明的list引用指向这个列表对象
        list = ls1;
        //1.3.3 采用父类的引用指向列表中的元素
        Fruit f1 = list.get(0);
        Fruit f2 = list.get(1);
        System.out.println(f1+" "+f2);
        Plants f3 = list.get(0);
        System.out.println("f3="+f3);
//        Strawberry f4 = list.get(0);//报错,因为编译器不支持向下转型
//        Banana f5 = list.get(1);

        //1.4 contains,indexOf和equals方法不能分辨涉及通配符的参数类型,只看作Object
        Strawberry s1 = (Strawberry)(f1);
        System.out.println(f1.equals(s1));
//        boolean isContain = list.contains(new Strawberry("red", 0.8, true));
        boolean isContain = list.contains(s1);
//        int index = list.indexOf(new Strawberry("red", 0.8, true));
        int index = list.indexOf(s1);
        System.out.println(isContain);
        System.out.println(index);
    }
}
