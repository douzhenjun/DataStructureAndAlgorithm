package huawei;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-05-23
 **/
public class Test2 {
    public static void main(String[] args) {
        String s1 = "()";
        String s2 = "()[]{}";
        String s3 = "([)]";
        String s4 = "{[]}";
        String s6 = "(]";
        String s5 = "";
        System.out.println(Solution2.func(s1));
        System.out.println(Solution2.func(s2));
        System.out.println(Solution2.func(s3));
        System.out.println(Solution2.func(s4));
        System.out.println(Solution2.func(s5));
        System.out.println(Solution2.func(s6));
    }
}
