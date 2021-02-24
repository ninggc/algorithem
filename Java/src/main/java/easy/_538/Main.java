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
    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return root;
        }
        if (root.right != null) {
            root.val = root.val + deepFind(root.right);
        }

        TreeNode leftMaxNode = root.left;
        if (leftMaxNode != null) {
            while (leftMaxNode.right != null) {
                leftMaxNode = leftMaxNode.right;
            }
            leftMaxNode.val = leftMaxNode.val + root.val;
        }


        if (root.left != null) {
            deepFind(root.left);
        }
        return root;
    }

    private int deepFind(TreeNode root) {
        if (root.right != null) {
            root.val = root.val + deepFind(root.right);
        }
        if (root.left != null) {
            root.left.val = deepFind(root.left) + root.val;
            return root.left.val;
        }
        return root.val;
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
