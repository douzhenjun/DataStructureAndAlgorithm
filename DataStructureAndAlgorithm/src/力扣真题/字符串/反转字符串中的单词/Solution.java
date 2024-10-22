package 力扣真题.字符串.反转字符串中的单词;

/**
 * @Description
 * @Author douzhenjun
 * @DATE 2023-10-30
 **/
class Solution {
    public String reverseWords(String s) {
        String newString = eraseBlank(s);
        StringBuilder sb = new StringBuilder(newString);
        reverseString(sb, 0, sb.length()-1);
        for (int i = 0, j = i + 1; i < sb.length(); ) {
            while (j < sb.length() && sb.charAt(j) != ' ') {
                j++;
            }
            reverseString(sb, i, j-1);
            i = j + 1;
            j = i + 1;
        }
        System.out.println(sb);
        return sb.toString();
    }

    //清除原字符串中的多余的空格字符
    private String eraseBlank(String s) {
        StringBuilder sb = new StringBuilder();
        int left = 0;
        while (s.charAt(left) == ' ') {
            left++;
        }
        int right = s.length() - 1;
        while (s.charAt(right) == ' ') {
            right--;
        }
        while (left <= right) {
            if (s.charAt(left) != ' ' ||
                    (s.charAt(left) == ' ' && sb.charAt(sb.length() - 1) != ' ')) {
                sb.append(s.charAt(left));
            }
            left++;
        }
        return sb.toString();
    }

    //反转字符串
    private void reverseString(StringBuilder sb, int left, int right) {
        while (left < right) {
            char temp = sb.charAt(left);
            sb.setCharAt(left, sb.charAt(right));
            sb.setCharAt(right, temp);
            left++;
            right--;
        }
    }
}
