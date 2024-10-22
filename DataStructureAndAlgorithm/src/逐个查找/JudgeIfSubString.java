package 逐个查找;

public class JudgeIfSubString {
    public boolean isSubsequence(String s, String t){
        int index = -1;
        for(char c : s.toCharArray()){
            //index表示上一次查找的位置(第一次查找的时候为-1
            //所以这里要从t的下标(index+1)开始寻找
            index = t.indexOf(c, index+1);
            //没找到,返回false
            if(index == -1){
                return false;
            }
        }
        return true;
    }
}
