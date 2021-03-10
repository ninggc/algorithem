package leetcode.editor.cn;

//您需要在二叉树的每一行中找到最大的值。 
//
// 示例： 
//
// 
//输入: 
//
//          1
//         / \
//        3   2
//       / \   \  
//      5   3   9 
//
//输出: [1, 3, 9]
// 
// Related Topics 树 深度优先搜索 广度优先搜索 
// 👍 125 👎 0


import leetcode.editor.cn.common.TreeNode;

import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> largestValues(TreeNode root) {
        Queue<TreeNode> nodes = new LinkedList<>();
        if (root != null) {
            nodes.add(root);
        }

        return search(nodes);
    }

    private List<Integer> search(Queue<TreeNode> nodes) {
        List<Integer> result = new LinkedList<>();

        while (!nodes.isEmpty()) {
            int max = Integer.MIN_VALUE;
            int size = nodes.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = nodes.poll();
                max = Math.max(max, node.val);
                if (node.left != null) {
                    nodes.add(node.left);
                }
                if (node.right != null) {
                    nodes.add(node.right);
                }
            }
            result.add(max);
        }
        return result;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

class Main {
    public static void main(String[] args) {
//        Integer[] arr = {1, 3, 2, 5, 3, null, 9};
        Integer[] arr = new Integer[]{};
        TreeNode root = TreeNode.init(arr);
        List<Integer> values = new Solution().largestValues(root);
        System.out.println("");
    }
}