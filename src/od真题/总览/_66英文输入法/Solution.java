package od真题.总览._66英文输入法;

import java.util.*;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-03-28
 **/
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String t = sc.nextLine();
        
        //使用正则表达式分割字符串s，得到s1数组
        String[] s1 = s.split("[^a-zA-Z]");
        //利用Set对s1数组进行去重
        List<String> s2 = new ArrayList<String>(new HashSet<String>(Arrays.asList(s1)));
        s2.sort(null);
        //移除不以t开头的字符串
        s2.removeIf(x -> !x.startsWith(t));
        //判断是否有匹配结果
        if(s2.size() > 0){
            System.out.println(String.join(" ", s2));
        }else{
            System.out.println(t);
        }
    }
}
