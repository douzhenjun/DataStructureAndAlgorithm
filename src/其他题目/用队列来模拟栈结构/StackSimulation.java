package 用队列来模拟栈结构;

import java.util.LinkedList;

/**
 * 用队列来模拟一个栈的结构.实现栈的压栈和弹栈操作.
 */
public class StackSimulation {
    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push("i");
        stack.push("love");
        stack.push("china");
        System.out.println(stack.peek());//"china"

        stack.pop();
        System.out.println(stack.peek());//"love"
        stack.pop();
        System.out.println(stack.peek());//"i"
        stack.pop();
        System.out.println(stack.peek());//null
    }


}

class Stack{
     public static LinkedList<String> queue1 = new LinkedList<>();
     public static LinkedList<String> queue2 = new LinkedList<>();

    /**
     * 压栈操作
     * @param ele
     */
     public void push(String ele){
         if(isEmpty(queue1) && isEmpty(queue2)){
             queue1.add(ele);
         }else if(!isEmpty(queue1)){
             queue1.add(ele);
         }else if(!isEmpty(queue2)){
             queue2.add(ele);
         }
     }

    /**
     * 弹栈操作
     * @return
     */
     public String pop(){

         String ele = null;

         if(isEmpty(queue1) && isEmpty(queue2)){
             System.out.println("栈为空!");
         } else if(!isEmpty(queue1)){
             while(queue1.size()>1){
                 String s = queue1.removeFirst();
                 queue2.add(s);
             }
              ele = queue1.removeFirst();
         }else if(!isEmpty(queue2)){
             while(queue2.size()>1){
                 String s = queue2.removeFirst();
                 queue1.add(s);
             }
              ele = queue2.removeFirst();
         }
         return ele;
     }

    /**
     * 查询栈顶元素
     * @return
     */
    public String peek(){
        String ele = null;
        if(isEmpty(queue1) && isEmpty(queue2)){
             System.out.println("这个栈为空!");
        }else if(!isEmpty(queue1)){
            for(int i = 0; i < queue1.size(); i++){
                if(i == queue1.size()-1){
                    ele = queue1.get(i);
                }
            }
        }else if(!isEmpty(queue2)){
            for(int i = 0; i < queue2.size(); i++){
                if(i == queue2.size()-1){
                    ele = queue2.get(i);
                }
            }
        }
        return ele;
     }

    /**
     * 判断栈是否为空
     * @param queue
     * @return
     */
    private boolean isEmpty(LinkedList queue) {
         if(queue==null || queue.size() == 0){
             return true;
         }
         return false;
    }
}
