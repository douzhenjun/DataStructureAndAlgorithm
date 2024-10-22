package 二叉树.字符串是否在二维数组中;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindString {
    
    //判断字符串是否在二维数组中, 采用回溯算法
    public static boolean isInArray(int i, int j, int index, String[][] array, String str){
        if(i < 0 || j < 0 || i >= array.length || j >= array[0].length){
            return false;
        }
        
        if(index == str.length()-1){
            return true;
        }else{
            if(!array[i][j].equals(String.valueOf(str.charAt(index)))){
                return false;
            }
        }
        array[i][j] = "#";
        return isInArray(i+1, j, index+1, array, str) || 
                isInArray(i, j+1, index+1, array, str) ||
                isInArray(i-1, j, index+1, array, str) ||
                isInArray(i, j-1, index+1, array, str);
    }

    public static void main(String[] args) {
        String [][] board = {{"o", "a", "a", "n"}, {"e", "t", "a", "e"}, {"i","h","k","r"}, {"i","f","l","v"}};
        String[] words = {"oath", "pea", "eat", "rain"};
        List<String> results = new ArrayList<>();

        System.out.print("board=[");
        for(String[] bb : board){
            System.out.print(Arrays.toString(bb));
        }
        System.out.println("]");

        System.out.println("words="+Arrays.toString(words));
        
        for(int k = 0; k < words.length; k++){

            boolean find = false;

            for(int i = 0; !find && i < board.length; i++){
                for(int j = 0; !find && j < board[0].length; j++){
                    if(isInArray(i, j, 0, board, words[k])){
                        String result = words[k];
                        results.add(result);
                        find = true;
                    }
                }
            }
        }
        
//        for(int i = 0; i < board.length; i++){
//            for(int j = 0; j < board[0].length; j++){
//                for(int k = 0; k < words.length; k++){
//                    if(isInArray(i, j, 0, board, words[k])){
//                        String result = words[k];
//                        results.add(result);
//                    }
//                }
//            }
//        }
        

        
        System.out.println("results="+results);
    }
}
