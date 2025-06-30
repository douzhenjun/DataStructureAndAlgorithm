package 剑指offer.剑指offer31_栈的压入弹出序列;

import java.util.Objects;
import java.util.Stack;

/**
 * @author dou_zhenjun
 * @date 2023/2/28
 * 判断一个序列是另一个序列出栈的顺序是否可行
 */
public class StackTest {
    private static Stack<Integer> helpStack = new Stack<>();
    
    /**
      * @Description 判断s2是否是s1的出栈序列, s1是入栈序列, s2是待验证的出栈序列
      * @param
      * @return 
      */
    public static boolean isPopQueue(Integer[] s1, Integer[] s2) {
        //边界条件
        if (s1.length == 0 || s2.length == 0 || s1.length != s2.length) {
            System.out.println("序列不能为空或长度不一致");
            return false;
        }
        //这里如果j遍历完了,i一定遍历完了,反之则未必
        for(int i=0,j=0; j<s2.length;){
            if(!helpStack.isEmpty() && helpStack.peek().equals(s2[j])){
                helpStack.pop();
                j++;
            }else{
                if(i >= s1.length){
                    return false;
                }
                helpStack.push(s1[i]);
                i++;
            }
        }
        return true;
    }
}
        
