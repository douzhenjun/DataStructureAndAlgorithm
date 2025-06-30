package od真题.总览._74计算三叉搜索树高度;

import java.util.Scanner;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-03-30
 **/
public class Solution {
    static int ans = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = scanner.nextInt();
        }
        TreeNode root = insert(null, arr[0], 1);//插入第一个数字
        for(int i = 1; i < n; i++){
            insert(root, arr[i], 1);//插入单个数字到三叉树内
        }
        System.out.println(ans);//输出最大的深度
    }

    public static TreeNode insert(TreeNode root, int val, int dep){
        ans = Math.max(ans, dep);//更新最大深度
        if(root == null){
            return new TreeNode(val);
        }
        if(val < root.val - 500){
            root.left = insert(root.left, val, dep + 1);
        }else if(val > root.val + 500){
            root.right = insert(root.right, val, dep + 1);
        }else{
            root.mid = insert(root.mid, val, dep + 1);
        }
        return root;
    }
    
   static class TreeNode {
        int val;
        Integer height;
        TreeNode left;
        TreeNode mid;
        TreeNode right;
        
        public TreeNode(int val){
            this.val = val;
            this.height = null;
            this.left = null;
            this.right = null;
            this.mid = null;
        }
    }
}
