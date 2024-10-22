package od真题.总览._103加密算法;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-04-08
 **/
public class Solution {
    static int[] a;
    static int[][] mp;
    static int n, m;
    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, -1, 1, 0};
    
    static boolean dfs(int x, int y, int pos, List<Integer> ans){
        ans.add(x);
        ans.add(y);
        int gg = mp[x][y];
        mp[x][y] = -1;
        if(pos == n - 1){
            return true;
        }
        for(int i = 0; i < dx.length; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 0 && nx < m && ny >= 0 && ny < m && mp[nx][ny] == a[pos + 1]){
                if(dfs(nx, ny, pos + 1, ans)){
                    return true;
                }
            }
        }
        mp[x][y] = gg;
        for(int i = 0; i < 2; i++){
            ans.remove(ans.size() - 1);
        }
        return false;
    }
    
    public static void readIn(){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        a = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = sc.nextInt();
        }
        m = sc.nextInt();
        mp = new int[m][m];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < m; j++){
                mp[i][j] = sc.nextInt();
            }
        }
    }
    
    public static void outPutList(List<Integer> arr){
        for(int k = 0; k < arr.size(); k++){
            System.out.print(arr.get(k));
            if(k != arr.size() - 1){
                System.out.print(" ");
            }
        }
        return;
    }

    public static void main(String[] args) {
        readIn();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < m; j++){
                List<Integer> ans = new ArrayList<>();
                if(mp[i][j] == a[0] && dfs(i, j, 0, ans)){
                    outPutList(ans);
                    return;
                }
            }
        }
        System.out.println("error");
    }
}
