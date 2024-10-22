package 力扣真题.回溯.黄金矿工;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-09-01
 **/
class Solution {
    public int getMaximumGold(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                res = Math.max(res, dfs(grid, i, j));
            }
        }
        return res;
    }

    public int dfs(int[][] grid, int x, int y) {
        // 边界条件
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == 0) {
            return 0;
        }
        int temp = grid[x][y];
        grid[x][y] = 0;
        int up = dfs(grid, x, y - 1);
        int down = dfs(grid, x, y + 1);
        int left = dfs(grid, x - 1, y);
        int right = dfs(grid, x + 1, y);
        // 这里只要4个方向的最大值即可
        int max = Math.max(left, Math.max(right, Math.max(up, down)));
        // 然后再把当前位置的值还原
        grid[x][y] = temp;
        return grid[x][y] + max;
    }
}