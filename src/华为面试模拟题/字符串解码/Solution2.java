package 华为面试模拟题.字符串解码;

import java.util.Stack;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-04-24
 **/
public class Solution2 {
    public String decodeString(String s){
        StringBuilder res = new StringBuilder();
        int multi = 0;
        Stack<Integer> multiStack = new Stack<>();
        Stack<String> resStack = new Stack<>();
        char[] array = s.toCharArray();
        for(int i = 0; i < array.length; i++){
            //表示数字可以压入到栈中了,然后接下来遇到的字符串全部是待输出的,需要定义一个sb对象
            if(array[i] == '['){
                multiStack.push(multi);
                resStack.push(res.toString());
                multi = 0;
                res = new StringBuilder();
            //字符串输出的终点,这里后面又会是数字了,确定了输出的内容和输出的次数,做一下处理
            }else if(array[i] == ']'){
                StringBuilder tmp = new StringBuilder();
                int curMulti = multiStack.pop();
                for(int j = 0; j < curMulti; j++){
                    tmp.append(res);
                }
                res = new StringBuilder(resStack.pop() + tmp);
            //如果是数字字符串,转换成数字
            }else if(Character.isDigit(array[i])){
                multi = multi * 10 + (array[i] - '0');
            //将[]内部的字符串添加到sb对象中
            }else{
                res.append(array[i]);
            }
        }
        return res.toString();
    }
}
