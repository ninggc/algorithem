//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "()"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "()[]{}"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：s = "(]"
//输出：false
// 
//
// 示例 4： 
//
// 
//输入：s = "([)]"
//输出：false
// 
//
// 示例 5： 
//
// 
//输入：s = "{[]}"
//输出：true 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁴ 
// s 仅由括号 '()[]{}' 组成 
// 
//
// Related Topics 栈 字符串 👍 3403 👎 0


package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Objects;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public boolean isValid(String s) {

        LinkedList<Character> deque = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == ')') {
                if (!Objects.equals('(', deque.pollLast())) {
                    return false;
                }
            } else if (c == ']') {
                if (!Objects.equals('[', deque.pollLast())) {
                    return false;
                }
            } else if (c == '}') {
                if (!Objects.equals('{', deque.pollLast())) {
                    return false;
                }
            } else {
                deque.addLast(c);
            }

        }

        return deque.isEmpty();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
