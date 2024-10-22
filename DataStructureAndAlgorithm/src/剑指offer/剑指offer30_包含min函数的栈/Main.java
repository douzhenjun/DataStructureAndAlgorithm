package 剑指offer.剑指offer30_包含min函数的栈;

/**
 * 主方法
 * @author dou_zhenjun
 * @date 2023/2/25
 */
public class Main {
    public static void main(String[] args) {
        //1.先测试基本功能是否满足要求
        Stack stack1 = new Stack();
        stack1.push(1);
        stack1.push(2);
        System.out.println("栈中最小元素为: "+stack1.min());
        System.out.println("删除栈顶元素: "+stack1.pop());
        System.out.println("栈顶元素: "+stack1.peek());
        stack1.push(-1);
        System.out.println("栈中最小元素为: "+stack1.min());
        stack1.pop();
        System.out.println("栈为空?"+stack1.isEmpty());
        stack1.pop();
        System.out.println("栈为空?"+stack1.isEmpty());
        stack1.pop();

        System.out.println("-------------------------------------");
        //2. 测试新入栈的元素比之前的最小值大
        Stack stack2 = new Stack();
        stack2.push(111);
        stack2.push(123);
        System.out.println(stack2.min());//111
        System.out.println(stack2.peek());//123
        System.out.println(stack2.pop());//123
        System.out.println(stack2.min());//111
        System.out.println("-------------------------------------------");
        //3. 新入栈的元素比之前的最小值要小
        Stack stack3 = new Stack();
        System.out.println(stack3.min());
        stack3.push(11);
        System.out.println(stack3.min());
        stack3.push(40);
        System.out.println(stack3.min());
        stack3.push(-7);
        System.out.println(stack3.min());
        stack3.push(-20);
        System.out.println(stack3.min());
        stack3.pop();
        System.out.println(stack3.min());
        stack3.pop();
        System.out.println(stack3.min());
        stack3.pop();
        System.out.println(stack3.min());
        stack3.pop();
        System.out.println(stack3.min());
    }
}
