package 力扣真题.回溯.给表达式添加运算符;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-07-25
 **/
public class Solution {
    public List<String> addOperators(String num, int target){
        List<String> res = new ArrayList<>();
        dfs(res, num, target, 0, 0, 0, "");
        return res;
    }
    
    /**
     * res 返回的结果
     * num 字符串num
     * target 目标值target
     * index 访问到字符串的第几个字符
     * preNum 前面的连续乘积
     * sum 表达式前面计算得到的和
     * path 算术表达式,可以看到n叉树的路径
     */
    
    private void dfs(List<String> res, String num, int target, int index, long preNum, long sum, String path){
        if(index >= num.length()){
            if(sum == target){
                res.add(path);
            }
            return;
        }
        for(int i = index; i < num.length(); i++){
            //前导是0的过滤掉
            if(i != index && num.charAt(index) == '0'){
                break;
            }
            //截取字符串,转化为数字
            long number = Long.parseLong(num.substring(index, i + 1));
            if(index == 0){
                //因为第一个数字是没有符号的,所以要单独处理
                dfs(res, num, target, i + 1, number, number, ""+number);
            }else{
                dfs(res, num, target, i + 1, number, sum + number, path + "+" + number);
                dfs(res, num, target, i + 1, -number, sum - number, path + "-" + number);
                dfs(res, num, target, i + 1, preNum * number, sum + preNum * number - preNum, path + "*" + "number");
            }
        }
    }
}
