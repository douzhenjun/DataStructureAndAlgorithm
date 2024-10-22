package java基础案例.泛型演示.上界下界通配符;

import java.util.ArrayList;
import java.util.List;

public class GenericTest2 {
    public static void main(String[] args) {
        //2 采用下界通配符?super, 表示list中所有的元素都是NorthBanana类或其父类
        List<? super NorthBanana> list = new ArrayList<>();
        
        List<Banana> bananas = new ArrayList<>();
        
        list = bananas;

        //2.1 下界通配符正确用法:可以使用add方法,但要符合泛型规定
        list.add(new XinjiangBanana("green", 0.3, true));

        list.add(new NorthBanana("green", 0.3, true));

        //2.2 下界通配符错误用法:添加XinjiangBanana的父类,无法通过编译
//        list.add(new Banana("green", 0.3, true));

        //2.3 因为不能保证返回的结果是哪一个父类,所以只能向上转型到最高类Object.
//        Fruit f1 = list.get(0);
//
//        NorthBanana nb1 = list.get(0);

        Object o1 = list.get(0);

        Object o2 = list.get(1);

//        o1.getColor();//直接调用肯定不行,因为多态不允许父类对象调用子类特有的方法

        System.out.println(list.get(0).getClass());

        System.out.println(o1.equals(list.get(0)));

        System.out.println(list.get(1).getClass());

        Class cl = list.get(0).getClass();

        System.out.println(o2.equals(list.get(0)));

        XinjiangBanana xb = (XinjiangBanana)o1;
        System.out.println(xb.getColor());
    }
}
