package 正则表达式匹配;

public class MathForReg {
    public static boolean match(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        int sIndex = 0;
        int pIndex = 0;
        return matchByRecursion(sIndex, pIndex, s, p);
    }

    public static boolean matchByRecursion(int sIndex, int pIndex, String s, String p) {
        //1.如果两个索引同时超过了索引上界,说明匹配
        if (sIndex >= s.length() && pIndex >= p.length()) {
            return true;
        }
        //2.如果模式串索引越界而主串索引不越界,说明不匹配
        if (pIndex >= p.length() && sIndex < s.length()) {
            return false;
        }

        //3.如果p和s在某一次匹配中不相等,并且p中的匹配的元素也不是'.'的话,需要判断p匹配元素的下一个元素是否存在且是否不为'*'
        //如果是,那么匹配失败
        if (s.charAt(sIndex) != p.charAt(pIndex) && p.charAt(pIndex) != '.') {
            if (pIndex + 1 < p.length() && p.charAt(pIndex+1) != '*') {
                return false;
            //4.如果不是,那么执行sIndex不变,pIndex+=2.
            } else {
                return matchByRecursion(sIndex, pIndex + 2, s, p);
            }

        //5.如果p和s在某一次匹配相等或者p中匹配的元素是'.'的话,需要判断p中的下一个元素是否存在且不是'*'
        //如果是,那么sIndex++和pIndex++
        } else {
            if (pIndex + 1 < p.length() && p.charAt(pIndex + 1) != '*') {
                return matchByRecursion(sIndex + 1, pIndex + 1, s, p);
            //6.如果不是,则分为三种情况,只要满足一种情况为真即可
            } else {
                return matchByRecursion(sIndex + 1, pIndex + 2, s, p)
                        || matchByRecursion(sIndex, pIndex + 2, s, p)
                        || matchByRecursion(sIndex + 1, pIndex, s, p);
            }
        }
    }

    public static void main(String[] args) {
        String s = "abceefg";
        String p = "a*c*b*f";//注意模式串可不能写错了,不能把'*'写在首部,也不能出现两个连续的'*'
        boolean isMatch = match(s, p);
        System.out.println("字符串s和模式串p的匹配情况是" + isMatch);

        System.out.println("---------------------------------------------------------");
        String s1 = "aaa";
        String p1 = "a*";
        isMatch = match(s1, p1);
        System.out.println("字符串s1和模式串p1的匹配情况是" + isMatch);

        System.out.println("----------------------------------------------------------");
        String s2 = "abcaedf";
        String p2 = "abcd*ac*edf";
        isMatch = match(s2, p2);
        System.out.println("字符串s2和模式串p2的匹配情况是" + isMatch);
        System.out.println();
    }
}


