package 剑指offer.剑指offer30_包含min函数的栈;

import java.util.ArrayList;

/**
 * @author dou_zhenjun
 * @date 2023/2/25
 */
public class Stack {
    //栈顶指针默认为-1
    private int top = -1;
    //底层数组是ArrayList
    private final ArrayList<Integer> list = new ArrayList<>();
    //辅助栈
    private final ArrayList<Integer> helpStack = new ArrayList<>();
    //当前栈中的最小值, 默认为Integer.MAX_VALUE, 注意这个值并不能用来作为最终栈中最小元素的判断依据
    private int min = Integer.MAX_VALUE;
    
    
    /**
      * @Description 元素入栈的方法
      * @param obj:入栈元素
      * @return 
      */
    public void push(Integer obj){
        list.add(obj);
        if(obj < min){
            min = obj;
        }
        helpStack.add(min);
        top++;
    }
    
    /**
      * @Description 元素出栈, 以出栈元素作为返回值
      * @param 
      * @return 返回移出元素的值
      */
    public Integer pop(){
        if(!isEmpty()){
            Integer o = list.get(top);
            list.remove(top);
            helpStack.remove(top);
            top--;
            return o;
        }
        System.out.println("栈中没有元素了!");
        return null;
        
    }

    /**
      * @Description 判断栈是否为空
      * @param 
      * @return boolean值
      */
    public boolean isEmpty() {
        return top == -1;
    }
    
    /**
      * @Description 获得栈顶的元素
      * @param 
      * @return 返回栈顶元素的值
      */
    public Integer peek(){
        if(!isEmpty()){
            return list.get(top);
        }
        System.out.println("栈中没有元素了!");
        return null;
    }
    
    /**
      * @Description 获得栈中的最小元素, 相当于获得辅助栈的栈顶元素
      * @param 
      * @return 返回最小的元素
      */
    public Integer min(){
        if(!isEmpty()){
            return helpStack.get(helpStack.size()-1);
        }
        System.out.println("栈中没有元素了!");
        return null;
    }

}
