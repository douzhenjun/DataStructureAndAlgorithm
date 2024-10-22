package java基础案例.stream;


import org.junit.Test;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/** 
 * flatmap
 * @author dou_zhenjun
 * @date 2023/2/15
 */
public class StreamTest{
    
    /*测试flatmap功能*/
    /*flatmap将每个元素转换成流对象,和map不同*/
    @Test
    public void test01(){
        List<String> list = Arrays.asList("m,k,l,a","1,3,5,7");
        List<String> listNew = list.stream().flatMap(s -> {
            // 将每个元素转换成一个stream
            String[] split = s.split(",");
            Stream<String> s2 = Arrays.stream(split);
            return s2;
        }).collect(Collectors.toList());

        System.out.println("处理前的集合：" + list);
        System.out.println("处理后的集合：" + listNew);
    }
    
    /*测试map功能*/
    @Test
    public void test02(){
        String[] strArr = { "abcd", "bcdd", "defde", "fTr" };
        //使用双冒号是为了简化lambda表达式,lambda表达式应当写作map(x->String.toUpperCase(x)),如果表达式只有一条,
        // 并且是调用已经存在的某个方法时, 采用方法引用的方式更为简洁
        List<String> strList = Arrays.stream(strArr).map(String::toUpperCase).collect(Collectors.toList());

        List<Integer> intList = Arrays.asList(1, 3, 5, 7, 9, 11);
        List<Integer> intListNew = intList.stream().map(x -> x + 3).collect(Collectors.toList());
        System.out.println("每个元素大写：" + strList);
        System.out.println("每个元素+3：" + intListNew);
    }
    
    /*forEach功能测试*/
    @Test
    public void test3(){
        List<Integer> list = Arrays.asList(1, 3, 5, 8, 6, 7, 9);
        list.stream().filter(i -> i>5).forEach(System.out::println);
    }
    
    /*流和并行流的使用*/
    /*测试匹配功能findFirst和findAny*/
    @Test
    public void test4(){
        List<Integer> list = Arrays.asList(7, 6, 9, 3, 8, 2, 1);
        // 匹配第一个
        Optional<Integer> findFirst = list.stream().filter(x -> x > 6).findFirst();
        // 匹配任意（适用于并行流）
        Optional<Integer> findAny = list.parallelStream().filter(x -> x > 6).findAny();
        // 是否包含符合特定条件的元素
        boolean anyMatch = list.stream().anyMatch(x -> x > 6);
        System.out.println("匹配第一个值：" + findFirst.get());
        System.out.println("匹配任意一个值：" + findAny.get());
        System.out.println("是否存在大于6的值：" + anyMatch);
    }
    
    /*筛选员工中工资高于8000的人, 并形成新的集合*/
    @Test
    public void test5(){
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("Tom", 8900, 23, "male", "New York"));
        personList.add(new Person("Jack", 7000, 25, "male", "Washington"));
        personList.add(new Person("Lily", 7800, 21, "female", "Washington"));
        personList.add(new Person("Anni", 8200, 24, "female", "New York"));
        personList.add(new Person("Owen", 9500, 25, "male", "New York"));
        personList.add(new Person("Alisa", 7900, 26, "female", "New York"));

        //collect用于将收集到的数据归置到一个容器中, 这是一个Collector对象
        List<String> filterList = personList.stream().filter(x -> x.getSalary() > 8000).map(Person::getName)
                .collect(Collectors.toList());
        System.out.print("高于8000的员工姓名：" + filterList);
    }
    
    /*max功能测试*/
    @Test
    public void test6(){
        List<String> list = Arrays.asList("adnm", "admmt", "pot", "xbangd", "weoujgsd");
        //comparing首先对字符串数组的长度进行排序,参数是一个Function对象,作为排序的区分关键字,然后调用max方法获得最长的那个
        Optional<String> max = list.stream().max(Comparator.comparing(String::length));
        System.out.println("最长的字符串：" + max.get());
    }
    
    
}
