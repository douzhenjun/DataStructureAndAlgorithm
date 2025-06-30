package 力扣真题.二叉树.二叉搜索树中的众数.根据二叉搜索树特性的解法;

import 力扣真题.二叉树.真题二叉树结点类.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 根据二叉搜索树特性的解法(这个方法是错误的,理由是将pre,count等参数传入到函数中,
 * 由于java采用的是值传递,内部维护的实际上是传入参数的拷贝,所以对内部的数据修改并不能让外部函数获得,
 * 所以是错误的,看Solution3把这些变量设置为全局唯一的).
 * @Author douzhenjun
 * @DATE 2024-02-21
 **/
public class Solution2 {

    public int[] findMode(TreeNode root){
        TreeNode pre = null;
        int count = 0;
        int maxCount = 0;
        List<Integer> resList = new ArrayList<>();
        searchBST(root, pre, count, maxCount, resList);
        int[] result = new int[resList.size()];
        for(int i = 0; i < resList.size(); i++){
            result[i] = resList.get(i);
        }
        return result;
    }

    private void searchBST(TreeNode root, TreeNode pre, int count, int maxCount, List<Integer> resList){
        if(root == null){
            return;
        }
        searchBST(root.left, pre, count, maxCount, resList);
        if(pre == null || root.val != pre.val){
            count = 1;
        }else{
            count++;
        }
        if(count > maxCount){
            resList.clear();
            resList.add(root.val);
            maxCount = count;
        }else if(count == maxCount){
            resList.add(root.val);
        }
        pre = root;
        searchBST(root.right, pre, count, maxCount, resList);
    }
}
