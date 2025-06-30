package 力扣真题.回溯.回溯算法解活字印刷;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2024-08-27
 **/
public class Solution2 {
    public int numTilePossibilities(String tiles) {
        char[] chars = tiles.toCharArray();
        int[] count = new int[26];
        for (char c : chars) {
            count[c - 'A']++;
        }
        int[] res = new int[1];
        backtrack(res, count);
        return res[0];
    }

    private void backtrack(int[] res, int[] arr) {
        for (int i = 0; i < 26; i++) {
            if (arr[i] == 0) {
                continue;
            }
            arr[i]--;
            res[0]++;
            backtrack(res, arr);
            arr[i]++;
        }
    }
}
