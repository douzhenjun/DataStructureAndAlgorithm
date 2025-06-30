package 正则表达式匹配_基于我的思路;

public class MatchForReg {

    public static boolean matchIfESC(int i, int j, String s1, String s2){
        if(s1.charAt(i) == s2.charAt(j)){
            return match(i+1, j+2, s1, s2) || match(i+1, j, s1, s2) || match(i, j+2, s1, s2);
        }else{
            return match(i, j + 2, s1, s2);
        }
    }
    public static boolean match(int i, int j, String s1, String s2) {
        //1.当到达递归边界时,根据情况决定返回值
        if (i >= s1.length() || j >= s2.length()) {
            if (i >= s1.length() && j >= s2.length()) {
                return true;
            } else {
                return false;
            }
            //2.没有到达递归边界时,判断s2[j]是否是特殊字符?
        } else {
            if (s2.charAt(j) == '.') {
                return match(i + 1, j + 1, s1, s2);
            } else {
                //3. 如果s2第j+1个位置元素是'*',返回matchIfESC方法
                if (j+1 < s2.length()-1 && s2.charAt(j + 1) == '*') {
                    return matchIfESC(i, j, s1, s2);
                    //4.如果s2第j+1个位置元素不是'*',判断s1[i]是否和s2[j]相等
                }else{
                    if(s1.charAt(i) == s2.charAt(j)){
                        return match(i+1, j+1, s1, s2);
                    }else{
                        //如果不相等,直接返回false,没必要继续比较下去了
                        return false;
                    }
                }
            }
        }
    }
}
