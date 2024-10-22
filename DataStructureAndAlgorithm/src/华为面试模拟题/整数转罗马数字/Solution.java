package 华为面试模拟题.整数转罗马数字;

/**
 * @Description
 * 分别获得十进制数字和对应的罗马字符的数组values, symbols,按照自然顺序倒序排列
 * 对于一个十进制数字num.遍历values数组,判断当前获得的value和num哪个更大,以num>=value作为while的终止条件
 * 然后每一次num-value,roman.append(symbol)
 * @Author douzhenjun
 * @DATE 2024-04-24
 **/
class Solution {
    int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    public String intToRoman(int num) {
        StringBuffer roman = new StringBuffer();
        for (int i = 0; i < values.length; ++i) {
            int value = values[i];
            String symbol = symbols[i];
            while (num >= value) {
                num -= value;
                roman.append(symbol);
            }
            if (num == 0) {
                break;
            }
        }
        return roman.toString();
    }
}