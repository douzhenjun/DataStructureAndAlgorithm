package 力扣真题.动态规划.解码方法;

/**
 * @Description 第一个算法会超时,因为包含了大量的重复计算
 * @Author douzhenjun
 * @DATE 2024-07-03
 **/
public class Solution2 {
    public int numDecodings(String s) {
        return binaryTreeTraversal(s.toCharArray(), s.length(), 0);
    }

    private int binaryTreeTraversal(char[] chars, int length, int index) {
        //遍历到二叉树的叶子,说明找到了一个方式(从根到节点的路径),返回1
        if (index >= length) {
            return 1;
        }
        if (chars[index] == '0') {
            return 0;
        }
        //遍历二叉树的两个分支,左边分支每次截取一个,右边分支每次截取两个
        int res = binaryTreeTraversal(chars, length, index + 1);
        //截取两个数字的分支,这两个数字必须要小于等于26才可以截取
        if (index < length - 1 && (chars[index] == '1' || (chars[index] == '2' && chars[index + 1] <= '6'))) {
            res += binaryTreeTraversal(chars, length, index + 2);
        }
        return res;
    }
}
