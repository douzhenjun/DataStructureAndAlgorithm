package 测试题;

import java.util.Scanner;

/*动态规划*/
public class Test03 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String zb = in.nextLine();
        String[] strs = zb.split(";");
        //横纵坐标
        int x = 0;
        int y = 0;
        for(String str : strs){
            Integer num = Integer.valueOf(str.substring(1));
            if(num >= 0 && num <= 99){
                if(str.charAt(0)=='A'){
                    x-=num;
                }else if(str.charAt(0)=='S'){
                    y-=num;
                }else if(str.charAt(0)=='D'){
                    x+=num;
                }else if(str.charAt(0)=='W'){
                    y+=num;
                }else{
                    continue;
                }
            }else{
                continue;
            }
        }
        System.out.println(x+","+y);
    }
}


