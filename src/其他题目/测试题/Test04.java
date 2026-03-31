package 测试题;
/*密码校验合格程序*/


import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * 一个合格的密码应该是:
 * 1.长度超过8位
 * 2.包括大小写字母,数字,其他符号,以上四种至少三种(其他符号不包含空格和换行)
 * 3.不能有长度大于2的包含公共元素的子串重复
 * <p>
 * 每行输入一个字符串,校验是否为合格的密码,如果是,打印一行"OK",否则打印一行"NG".
 */


public class Test04 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String str = sc.nextLine();
            if (checkLength(str) && matchPattern(str) && noContainsCommonSubString(str, 0, 3)) {
                System.out.println("OK");
            } else {
                System.out.println("NG");
            }
        }

    }

    //校验长度
    public static boolean checkLength(String str) {
        if (str.length() <= 8) {
            return false;
        }
        return true;
    }

    //校验输入字符是否满足条件2
    public static boolean matchPattern(String str) {
        //记录满足的条件数,大于等于3才行
        int count = 0;
//        String p1 = "[A-Z]";
//        if (Pattern.matches(p1, str)) {
//            count++;
//        }

        Pattern p1 = Pattern.compile("[A-Z]");
        if (p1.matcher(str).find()) {
            count++;
        }

        Pattern p2 = Pattern.compile("[a-z]");
        //等价与Pattern.matches(p1,str)
        if (p2.matcher(str).find()) {
            count++;
        }
        Pattern p3 = Pattern.compile("[0-9]");
        if (p3.matcher(str).find()) {
            count++;
        }
        Pattern p4 = Pattern.compile("[^a-zA-Z0-9]");
        if (p4.matcher(str).find()) {
            count++;
        }
        if (count >= 3) {
            return true;
        } else {
            return false;
        }
    }

    //判断是否有两个长度超过2的元素相同的子串, r-l=3
    public static boolean noContainsCommonSubString(String str, int l, int r) {
        if (r >= str.length()) {
            return true;
        }
        if (str.substring(r).contains(str.substring(l, r))) {
            return false;
        } else {
            return noContainsCommonSubString(str, l + 1, r + 1);
        }
    }
}
