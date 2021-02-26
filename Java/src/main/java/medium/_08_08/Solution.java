package medium._08_08;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/permutation-ii-lcci/
 *
 * Write a method to compute all permutations of a string whose characters are not necessarily unique. The list of permutations should not have duplicates.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutation-ii-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    String[] result = null;
    int resultIndex = 0;

    /**
     * 1. 使用uniqueChar这个数组来保存字符集，偶数位是字符，奇数位是数量
     * 深度优先遍历，每一层使用的字符数量减一，最内一层将结果保存
     * 2. 这里每一个位置的可能性都是uniqueLength，所以结果集最大为uniqueLength的n次幂
     *
     *
     * @param S
     * @return
     */
    public String[] permutation(String S) {
        Character[] uniqueChar = new Character[S.length() * 2];

        // 对S去重
        int uniqueLength = 0;
        for (char c : S.toCharArray()) {
            for (int i = 0; i < uniqueChar.length; ) {
                if (uniqueChar[i] == null) {
                    uniqueChar[i] = c;
                    uniqueChar[i + 1] = '1';
                    ++uniqueLength;
                    break;
                } else if (uniqueChar[i] == c) {
                    uniqueChar[i + 1]++;
                    break;
                }
                i += 2;
            }
        }


        int maxCount = 1;
        for (int i = 0; i < S.length(); i++) {
            maxCount *= uniqueLength;
        }
        result = new String[maxCount];
        calculateRemanent(uniqueChar, result, new char[S.length()], 0);
        String[] trimResult = new String[resultIndex];
        for (int i = 0; i < trimResult.length; i++) {
            trimResult[i] = result[i];
        }

        return trimResult;
    }

    private void calculateRemanent(Character[] uniqueChar, String[] result, char[] partResult, int index) {
        for (int i = 0; i < uniqueChar.length; i += 2) {
            if (uniqueChar[i +1] == null || uniqueChar[i + 1] == '0') {
                continue;
            }

            --uniqueChar[i + 1];
            partResult[index] = uniqueChar[i];
            if (index + 1 == partResult.length) {
                result[resultIndex++] = new String(partResult);
            } else {
                calculateRemanent(uniqueChar, result, partResult, index + 1);
            }
            ++uniqueChar[i + 1];
        }
    }

    public static void main(String[] args) {
        new Solution().permutation("LDirNn");
    }
}
