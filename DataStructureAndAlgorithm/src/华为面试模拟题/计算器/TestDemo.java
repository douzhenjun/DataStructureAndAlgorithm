package 华为面试模拟题.计算器;


import org.junit.Test;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-04-24
 **/
public class TestDemo {
    public static void main(String[] args) {
        String ex = "4+2*4";
        Solution solution = new Solution();
        int value = solution.getValue(ex);
        System.out.println(value);
        
    }
    
    @Test
    public void test01(){
        String ex = "1+2+3";
        Solution solution = new Solution();
        int value = solution.getValue(ex);
        System.out.println(value);
    }
}
