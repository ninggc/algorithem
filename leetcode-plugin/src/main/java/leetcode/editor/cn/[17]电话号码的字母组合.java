//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。 
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：digits = "23"
//输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
// 
//
// 示例 2： 
//
// 
//输入：digits = ""
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：digits = "2"
//输出：["a","b","c"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= digits.length <= 4 
// digits[i] 是范围 ['2', '9'] 的一个数字。 
// 
//
// Related Topics 哈希表 字符串 回溯 👍 2018 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits == null || "".equals(digits)) {
            return ans;
        }

        List<String> mappingList = new ArrayList<>();
        mappingList.add("");
        mappingList.add("");
        mappingList.add("abc");
        mappingList.add("def");
        mappingList.add("ghi");
        mappingList.add("jkl");
        mappingList.add("mno");
        mappingList.add("pqrs");
        mappingList.add("tuv");
        mappingList.add("wxyz");

        backtrack(mappingList, ans, 0, new StringBuilder(), digits);
        return ans;
    }

    private void backtrack(List<String> mappingList, List<String> ans, int index, StringBuilder stringBuilder, String digits) {
        if (index == digits.length()) {
            ans.add(stringBuilder.toString());
        } else {
            String s = mappingList.get((int) digits.charAt(index) - 48);
            for (char c : s.toCharArray()) {
                stringBuilder.append(c);
                backtrack(mappingList, ans, index + 1, stringBuilder, digits);
                stringBuilder.deleteCharAt(index);
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
