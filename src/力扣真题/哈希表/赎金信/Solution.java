package 力扣真题.哈希表.赎金信;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-04-27
 **/
public class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] array = new int[26];//一个用来保存26个字母出现次数的数组
        //排除一些情况
        if(ransomNote.length() > magazine.length()){
            return false;
        }
        //初始化array
        for(int i = 0; i < magazine.length(); i++){
            array[magazine.charAt(i)-'a']++;
        }
        //遍历ransonNote(赎金信),如果ransonNote中出现的字符在magazine中出现过,则对该元素对应位置的值-1,如果出现某个array[i-'a']<0,说明magazine中不存在该元素或该元素存在但存在次数不足以表示ransonNote中的字符
        for(int j = 0; j < ransomNote.length(); j++){
            array[ransomNote.charAt(j)-'a']--;
            if(array[ransomNote.charAt(j)-'a'] < 0){
                return false;
            }
        }
        return true;
    }
}
