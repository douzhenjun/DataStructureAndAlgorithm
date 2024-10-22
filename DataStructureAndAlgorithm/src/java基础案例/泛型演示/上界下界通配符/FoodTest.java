package java基础案例.泛型演示.上界下界通配符;

public class FoodTest<T extends Fruits>{
    private T obj;
    public FoodTest(T x){this.obj = x;}
    public void getColor(){
        obj.getColor();
    }

    public static void main(String[] args) {
        Fruits f1 = new Apple("red");
        Fruits f2 = new Orange("orange");
        Fruits f3 = new Bananaa("yellow");

        FoodTest ft = new FoodTest(f1);
        ft.getColor();
        ft = new FoodTest(f2);
        ft.getColor();
        ft = new FoodTest(f3);
        ft.getColor();
    }
}

class Fruits{
    private String color;

    public Fruits(String color) {
        this.color = color;
    }

    public void getColor(){
        System.out.println("水果的颜色是"+color);
    };
}

class Apple extends Fruits{
    public Apple(String color){
        super(color);
    }
}

class Bananaa extends Fruits{
    public Bananaa(String color){
        super(color);
    }
}

class Orange extends Fruits{
    public Orange(String color){
        super(color);
    }
}