package easy._538;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        if (root != null) {
            convertBST(root.right);
            root.val = (sum += root.val);
            convertBST(root.left);
        }

        return root;
    }


    static TreeNode superRoot = new TreeNode(2);

    public static void main(String[] args) {
        superRoot.left = new TreeNode(0);
        superRoot.left.left = new TreeNode(-4);
        superRoot.left.right = new TreeNode(1);
        superRoot.right = new TreeNode(3);
        TreeNode treeNode = new Solution().convertBST(superRoot);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
