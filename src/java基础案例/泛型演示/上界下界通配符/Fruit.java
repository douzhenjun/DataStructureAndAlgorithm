package java基础案例.泛型演示.上界下界通配符;


//声明一个水果类,以及它的一些子类
public class Fruit extends Plants{
    private String color;

    private double sweetness;

    private boolean isSmooth;

    public Fruit(String color, double sweetness, boolean isSmooth) {
        this.color = color;
        this.sweetness = sweetness;
        this.isSmooth = isSmooth;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getSweetness() {
        return sweetness;
    }

    public void setSweetness(double sweetness) {
        this.sweetness = sweetness;
    }

    public boolean isSmooth() {
        return isSmooth;
    }

    public void setSmooth(boolean smooth) {
        isSmooth = smooth;
    }
}


class Strawberry extends Fruit{
    public Strawberry(String color, double sweetness, boolean isSmooth) {
        super(color, sweetness, isSmooth);
    }
}

class Banana extends Fruit{
    public Banana(String color, double sweetness, boolean isSmooth) {
        super(color, sweetness, isSmooth);
    }
}

class NorthBanana extends Banana{
    public NorthBanana(String color, double sweetness, boolean isSmooth) {
        super(color, sweetness, isSmooth);
    }
}

class SouthBanana extends Banana{
    public SouthBanana(String color, double sweetness, boolean isSmooth){super(color, sweetness, isSmooth);}
}

class XinjiangBanana extends NorthBanana{
    public XinjiangBanana(String color, double sweetness, boolean isSmooth) {
        super(color, sweetness, isSmooth);
    }
}

class HainanBanana extends SouthBanana{
    public HainanBanana(String color, double sweetness, boolean isSmooth) {
        super(color, sweetness, isSmooth);
    }
}