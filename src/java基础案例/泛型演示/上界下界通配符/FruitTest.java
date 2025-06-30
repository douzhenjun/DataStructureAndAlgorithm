package java基础案例.泛型演示.上界下界通配符;

import java.util.ArrayList;
import java.util.List;

public class FruitTest {
    public static void main(String[] args) {
        List<? super NorthBanana> list = new ArrayList<>();

//        list.add(new Banana("yellow", 0.7, true));

        list.add(new XinjiangBanana("yellow", 0.88, true));

        list.add(new NorthBanana("yellow", 0.78, true));

//        list.add(new Strawberry("red", 0.8, true));

//        Banana ba = list.get(0);
//
//        Banana ba1 = list.get(1);

        Object ba2 = list.get(0);
    }
}
