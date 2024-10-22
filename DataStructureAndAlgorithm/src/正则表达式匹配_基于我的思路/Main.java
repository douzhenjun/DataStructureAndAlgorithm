package 正则表达式匹配_基于我的思路;

public class Main {
    public static void main(String[] args) {
        String s1 = "aaa";//匹配串
        //下面全是模式串
        String s2 = "a.a";
        String s3 = "ab*ac*a";
        String s4 = "ab*a";

        boolean isMatch1 = MatchForReg.match(0, 0, s1, s2);
        boolean isMatch2 = MatchForReg.match(0, 0, s1, s3);
        boolean isMatch3 = MatchForReg.match(0, 0, s1, s4);

        System.out.println("s1和s2是否匹配:"+isMatch1);
        System.out.println("s1和s3是否匹配:"+isMatch2);
        System.out.println("s1和s4是否匹配:"+isMatch3);
    }
}
