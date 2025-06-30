package od真题.总览._71多段线数据压缩;

import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-03-30
 **/
public class Solution2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] inputList = scanner.nextLine().split(" ");
        List<List<Integer>> indexs = new ArrayList<>();
        int x = Integer.parseInt(inputList[0]);
        int y = Integer.parseInt(inputList[1]);
        List<Integer> tempList = new ArrayList<>();//这个对象只作为临时存储,实际通过拷贝添加到结果数组中
        tempList.add(x);
        tempList.add(y);
        indexs.add(new ArrayList<>(tempList));
        for (int i = 2; i < inputList.length; i += 2) {
            if (i == 2) {
                int x1 = Integer.parseInt(inputList[i]);
                int y1 = Integer.parseInt(inputList[i + 1]);
                tempList = new ArrayList<>();
                tempList.add(x1);
                tempList.add(y1);
                indexs.add(new ArrayList<>(tempList));
            } else {
                int x2 = Integer.parseInt(inputList[i]);
                int y2 = Integer.parseInt(inputList[i + 1]);
                int n = indexs.size();
                //获得数组末尾的两个元素
                int x1 = indexs.get(n - 1).get(0);
                int y1 = indexs.get(n - 1).get(1);
                int x0 = indexs.get(n - 2).get(0);
                int y0 = indexs.get(n - 2).get(1);
                //如果三个点在一个水平线和一个竖直线上,说明最后一个元素不是拐点,那么将数组中的最后一个元素移除
                if (x1 == x2 && x1 == x0 || (y1 == y2 && y1 == y0)) {
                    indexs.remove(n - 1);
                }else{
                    //否则计算斜率,如果斜率相同说明原来数组中的最后一个元素不是拐点
                    int xoffset2 = x2 - x1;
                    int yoffset2 = y2 - y1;
                    int xoffset1 = x1 - x0;
                    int yoffset1 = y1 - y0;
                    //避免除数为0的情况出现,这种情况下一定是拐点
                    if(xoffset2 != 0 && xoffset1 != 0){
                        int slope2 = yoffset2 / xoffset2;
                        int slope1 = yoffset1 / xoffset1;
                        if(slope2 == slope1){
                            indexs.remove(n - 1);
                        }
                    }
                }
                //向数组中添加遍历到的元素
                tempList = new ArrayList<>();
                tempList.add(x2);
                tempList.add(y2);
                indexs.add(new ArrayList<>(tempList));
            }
        }
        for(List<Integer> integerList : indexs){
            System.out.print(integerList.get(0) + " " + integerList.get(1) + " ");
        }
    }


}
