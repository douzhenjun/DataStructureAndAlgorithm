package 剑指offer.剑指offer29_顺时针打印矩阵;

public class PrintMatrixInCircle {

    public static void PrintCycles(int m, int n, int[][] array) {
        if (m < 0 || n < 0) {
            return;
        }
        int k = 0;
        //当s=min{m,n}为奇数时,要求2k+1<=s;否则要求2k<=s, k表示最后一圈的起始行/列数
        while (2 * k + 1 <= Math.min(m, n) || 2 * k <= Math.min(m, n)) {
            PrintPerCycle(m, n, k, array);
            k++;
        }
    }

    public static void PrintPerCycle(int m, int n, int k, int[][] array) {
            //如果最后一圈只有一行,那么只打印这一行数据
        if (2 * k == m) {
            for (int col = k; col < n - k + 1; col++) {
                System.out.println(array[k][col]);
            }
            //如果最后一圈至少两行,并且只有一列,那么只打印这一列数据
        } else if (2 * k + 1 <= m && 2 * k == n) {
            for (int row = k; row < m - k + 1; row++) {
                System.out.println(array[row][k]);
            }
            //如果最后一圈只有两行,并且至少有两列以上,那么先打印一行,再打印下一行
        } else if (2 * k + 1 == m && 2 * k + 1 <= n) {
            for (int col = k; col < n - k + 1; col++) {
                System.out.println(array[k][col]);
            }
            for (int col = n - k; col > k - 1; col--) {
                System.out.println(array[k + 1][col]);
            }
            //如果是其他情况,照此打印
        } else {
            for (int col = k; col < n - k + 1; col++) {
                System.out.println(array[k][col]);
            }
            for (int row = k + 1; row < m - k + 1; row++) {
                System.out.println(array[row][n - k]);
            }
            for (int col = n - k - 1; col > k - 1; col--) {
                System.out.println(array[m - k][col]);
            }
            for (int row = m - k - 1; row > k; row--) {
                System.out.println(array[row][k]);
            }
        }
    }

    public static void main(String[] args) {
        int m, n;
        int[][] array2 = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        m = array2.length - 1;
        n = array2[0].length - 1;
        PrintCycles(m, n, array2); //成功

        System.out.println("----------------------------------------------");
        int[][] array3 = {{1, 2, 3, 4}, {5, 6, 7, 8}};
        m = array3.length - 1;
        n = array3[0].length - 1;
        PrintCycles(m, n, array3); //成功

        System.out.println("-----------------------------------------------");
        int[][] array4 = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        m = array4.length - 1;
        n = array4[0].length - 1;
        PrintCycles(m, n, array4);//成功

        System.out.println("-----------------------------------------------");
        int[][] array5 = {{1, 2, 3}, {5, 6, 7}, {9, 10, 11}, {13, 14, 15}};
        m = array5.length - 1;
        n = array5[0].length - 1;
        PrintCycles(m, n, array5);//成功
    }
}
