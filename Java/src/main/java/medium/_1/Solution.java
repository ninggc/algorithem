package medium._1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 *
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 *
 *
 * 示例:
 *
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 说明:
 * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }

        List<String> s = Arrays.asList(
                "abc", "def"
                , "ghi", "jkl", "mno"
                , "pqrs", "tuv", "wxyz"
        );

        List<String> s1 = new ArrayList<>(digits.length());
        for (int i = 0; i < digits.toCharArray().length; i++) {
            int number = digits.toCharArray()[i] - '2';
            if (number < 0 || number > s.size()) {
                throw new IllegalArgumentException("输入不合法");
            }
            s1.add(s.get(number));
        }

        List<String> temp = null;
        result = toList(s1.get(0).toCharArray());

        List<String> b = null;
        for (int i = 1; i < s1.size(); i++) {
            temp = new ArrayList<>();
            b = toList(s1.get(i).toCharArray());

            for (String item1 : result) {
                for (String item2 : b) {
                    temp.add(item1 + item2);
                }
            }
            result = temp;
        }

        return result;
    }

    private List<String> toList(char[] chars) {
        List<String> list = new ArrayList<>();
        if (chars == null || chars.length == 0) {
            return list;
        }

        for (char c : chars) {
            list.add(String.valueOf(c));
        }
        return list;
    }
}
