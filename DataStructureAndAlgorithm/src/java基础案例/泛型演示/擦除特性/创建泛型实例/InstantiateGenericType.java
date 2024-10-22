package java基础案例.泛型演示.擦除特性.创建泛型实例;

//虽然会在运行期间抛出异常,但是编译期间无法捕获
public class InstantiateGenericType {
    public static void main(String[] args) {
        ClassAsFactory<Employee> fe = new ClassAsFactory<>(Employee.class);
        System.out.println("ClassAsFactory<Employee> succeeded");
        try{
            ClassAsFactory<Integer> fi = new ClassAsFactory<>(Integer.class);
        }catch(Exception e){
            System.out.println("ClassAsFactory<Integer> failed");
        }
    }
}

class ClassAsFactory<T>{
    T x;
    public ClassAsFactory(Class<T> kind){
        try{
            x = kind.newInstance();//用来创建一个T类型对象
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }
}

class Employee{}