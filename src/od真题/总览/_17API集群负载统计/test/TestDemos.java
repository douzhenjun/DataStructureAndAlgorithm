package od真题.总览._17API集群负载统计.test;

import od真题.总览._17API集群负载统计.test.Solution;
import org.junit.Test;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-03-23
 **/
public class TestDemos {
    
   Solution solution = new Solution();
    
    @Test
    public void test01(){
        String[] strings = {"/huawei/computing/no/one", "/huawei/computing", "/huawei", "/huawei/cloud/no/one", "/huawei/wireless/no/one"};
        int depth = 2;
        String key = "computing";
        System.out.println(solution.getKey(strings, key, depth));
    }

    @Test
    public void test02(){
        String[] strings = {"/huawei/computing/no/one", "/huawei/computing", "/huawei", "/huawei/cloud/no/one", "/huawei/wireless/no/one"};
        int depth = 4;
        String key = "two";
        System.out.println(solution.getKey(strings, key, depth));
    }
}
