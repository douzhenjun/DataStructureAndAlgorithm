package 正则表达式匹配;

public class match {
    /**
     * 比如 array={'a', 'a', 'a'}，pattern={'a', '*', 'a'}，
     *     1.     pattern[0]不是'.'或'*', 但是pattern[1]是'*', 发现array[0]=pattern[0]
     *     2.     此时sIndex=0，pIndex=0，通过matchCore(array, sIndex + 1, pattern, pIndex + 2)，
     *            即匹配串向后移动一位，模式串跳过'*'也就是移动2位
     *     2.1.   此时sIndex=1，pIndex=2，模式串已经是最后一个元素，没有下一个元素，所以array[1]=pattern[2]
     *     2.2.   因为匹配串还不确定是否是最后一个元素，此时调用matchCore(array, sIndex + 1, pattern, pIndex + 1)
     *     2.3.   此时sIndex=2，pIndex=3，sIndex < sLen && pIndex >= pLen，所以返回false
     *     3.     因为2没得到true，||的短路作用没有生效，此时sIndex=0，pIndex=0，
     *            继续通过matchCore(array, sIndex + 1, pattern, pIndex)
     *     3.1    此时sIndex=1，pIndex=0，pattern[pIndex + 1]='*'，array[1]=pattern[0],这里就要重复2的所有操作
     *            通过matchCore(array, sIndex + 1, pattern, pIndex + 2)
     *     3.2.1  此时sIndex=2，pIndex=2，模式串已经是最后一个元素，没有下一个元素，所以array[2]=pattern[2]
     *     3.2.2. 因为匹配串还不确定是否是最后一个元素，此时调用matchCore(array, sIndex + 1, pattern, pIndex + 1)
     *     3.2.3. 此时sIndex=3，pIndex=4，sIndex >= sLen && pIndex >= pLen，所以返回true
     *
     *     由于步骤3已经匹配成功，||短路生效，不会再去通过matchCore(array, sIndex, pattern, pIndex + 2)来验证
     *     如果步骤3匹配失败，则会通过matchCore(array, sIndex, pattern, pIndex + 2)来得到匹配结果
     *     此时，匹配串都匹配完了
     * @param array
     * @param sIndex
     * @param pattern
     * @param pIndex
     * @return
     */
    private static boolean matchCore(char[] array, int sIndex, char[] pattern, int pIndex) {
        int sLen = array.length;
        int pLen = pattern.length;
        // 字符串和模式的字符数组都已经完成了最后一个字符的匹配，说明没有出现匹配失败的情况，即匹配成功
        if (sIndex >= sLen && pIndex >= pLen) {
            return true;
        }
        // 如果模式串的每一个字符都已经参与过匹配，而字符串还有字符未匹配到，说明不匹配
        if (sIndex < sLen && pIndex >= pLen) {
            return false;
        }

        // 模式串的下一个字符是'*'，跳过直接选择模式下一个字符，因为'*'表示可以出现任意次
        if ((pIndex + 1) < pLen && pattern[pIndex + 1] == '*') {
            if (sIndex >= sLen) {
                // 如果字符串已经全部匹配过，跳过'*'，看模式串的下一个字符
                return matchCore(array, sIndex, pattern, pIndex + 2);
            } else {
                // 如果字符串还有需要匹配的字符，如果满足以下两个条件其中之一
                //   1. 字符串要匹配的字符和模式串的当前字符相等，说明匹配
                //   2. 模式串当前字符是'.'，和下一个字符'*'组成'.*'，就是任意字符可以出现任意次(包括0次),则考虑三种情况：
                //     1. 匹配串向后移动一位，模式串跳过'*', matchCore(array, sIndex + 1, pattern, pIndex + 2)
                //     2. 匹配串向后移动一位，模式串不动, matchCore(array, sIndex + 1, pattern, pIndex)
                //     3. 匹配串不动，模式串跳过'*', matchCore(array, sIndex, pattern, pIndex + 2)
                if (array[sIndex] == pattern[pIndex] || pattern[pIndex] == '.') {
                    return matchCore(array, sIndex + 1, pattern, pIndex + 2)
                            || matchCore(array, sIndex + 1, pattern, pIndex)
                            || matchCore(array, sIndex, pattern, pIndex + 2);
                } else {
                    return matchCore(array, sIndex, pattern, pIndex + 2);
                }
            }

        }
        // 如果模式串此时是'.'， 就比较好办了，因为'.'表示任意字符，所以都向后移动一位即可
        if (array[sIndex] == pattern[pIndex] || (pIndex < pLen && pattern[pIndex] == '.')) {
            return matchCore(array, sIndex + 1, pattern, pIndex + 1);
        }
        return false;
    }
}
