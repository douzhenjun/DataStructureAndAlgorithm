package java基础案例.泛型演示.擦除特性.创建泛型实例;

public class FactoryConstraint {
    public static void main(String[] args) {
        new Foo2<Integer>(new IntegerFactory());
        new Foo2<Widget>(new Widget.Factory());
//        new Foo2<String>(new StringFactory());//编译器不通过,因为类型不对
    }
}

    interface FactoryI<T>{
        T create();
    }

    class Foo2<T>{
        private T x;
        public <F extends FactoryI<T>> Foo2(F factory){
            x = factory.create();
        }
    }

    class IntegerFactory implements FactoryI<Integer>{
        public Integer create(){
            return new Integer(0);
        }
    }

    class StringFactory{
    public String create(){
        return new String("douge");
    }
    }

    class Widget{
        public static class Factory implements FactoryI<Widget>{
            public Widget create(){
                return new Widget();
            }
        }
    }

