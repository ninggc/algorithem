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
// Related Topics 栈 字符串 👍 3025 👎 0


package leetcode.editor.cn._20;

import java.util.Deque;
import java.util.LinkedList;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isValid(String s) {
        Deque<Character> deque = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (!deque.isEmpty() && deque.peekLast().equals(match(c))) {
                deque.removeLast();
            } else {
                deque.add(c);
            }
        }
        return deque.isEmpty();
    }

    private char match(char c) {
        switch (c) {
            case ')': return '(';
            case ']': return '[';
            case '}': return '{';
        }

        return '.';
    }

    public static void main(String[] args) {
//        new Solution().isValid("()");
        System.out.println(new Solution().isValid("(([]))"));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
