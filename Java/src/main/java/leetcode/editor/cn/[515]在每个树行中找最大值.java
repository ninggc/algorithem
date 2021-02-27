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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
        if (root == null) {
            return Collections.emptyList();
        }
        List<Integer> result = new ArrayList<>();

        // 需要处理的行的节点
        List<TreeNode> currentNodes = new ArrayList<>();
        currentNodes.add(root);
        result.add(root.val);

        search(result, currentNodes);
        return result;
    }

    private void search(List<Integer> result, List<TreeNode> currentNodes) {
        List<TreeNode> childNodes = new ArrayList<>();

        TreeNode childNode = null;
        while (!currentNodes.isEmpty()) {
            Integer max = null;
            for (TreeNode node : currentNodes) {
                childNode = node.left;
                if (childNode != null) {
                    if (max == null || childNode.val > max) {
                        max = childNode.val;
                    }
                    childNodes.add(childNode);
                }
                childNode = node.right;
                if (childNode != null) {
                    if (max == null || childNode.val > max) {
                        max = childNode.val;
                    }
                    childNodes.add(childNode);
                }
            }
            if (max != null) {
                result.add(max);
            }

            List<TreeNode> tmp = currentNodes;
            currentNodes = childNodes;
            childNodes = tmp;
            childNodes.clear();
        }

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