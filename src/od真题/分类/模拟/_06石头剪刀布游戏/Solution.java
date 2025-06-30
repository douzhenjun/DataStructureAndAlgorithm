package od真题.分类.模拟._06石头剪刀布游戏;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-03-22
 **/
public class Solution {
    public static void main(String[] args) {
        List<String>[] arr = new ArrayList[3];
        for(int i = 0; i < 3; i++){
            arr[i] = new ArrayList<>();
        }
        Scanner sc = new Scanner(System.in);
        
        while(true){
            try {
                //读取两个字符串,将第一个字符串添加到对应的ArrayList中
                String s1 = sc.next();
                String s2 = sc.next();
                arr[s2.charAt(0) - 'A'].add(s1);
            } catch (Exception e) {
                break;
            }
        }
        //如果三个ArrayList都非空,说明三个不同的出拳,是平手
        if(allNonEmpty(arr)){
            System.out.println("NULL");
            return;
        }
        //如果有两个以上的ArrayList为空,说明只有一种出拳,也是平手
        int num = countEmpty(arr);
        if(num >= 2){
            System.out.println("NULL");
            return;
        }
        //对每个ArrayList进行排序A>B>C>A,现在有两个非空的列表,
        //如果是0和1,那么0中的元素是胜者
        //如果是1和2,那么1中的元素是胜者
        //如果是2和0,那么2中的元素是胜者
        for(List<String> lst : arr){
            Collections.sort(lst);
        }
        int tmp = 0;
        if(arr[0].isEmpty()){
            tmp = 1;
        }else if(arr[1].isEmpty()){
            tmp = 2;
        }
        for(String t : arr[tmp]){
            System.out.println(t);
        }
    }
    
    //检查是否所有的arrayList都为空
    private static boolean allNonEmpty(List<String>[] arr){
        for(List<String> lst : arr){
            if(lst.isEmpty()){
                return false;
            }
        }
        return true;
    }
    //计算空ArrayList的数量
    private static int countEmpty(List<String>[] arr){
        int count = 0;
        for(List<String> lst : arr){
            if(lst.isEmpty()){
                count++;
            }
        }
        return count;
    }
}
