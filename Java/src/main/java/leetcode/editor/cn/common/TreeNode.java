package leetcode.editor.cn.common;

import java.util.*;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static TreeNode init(Integer val) {
        if (val == null) {
            return null;
        } else {
            return new TreeNode(val);
        }
    }

    public static TreeNode init(Integer[] arr) {
        if (arr.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode();
        List<TreeNode> nodes = new ArrayList<>();
        nodes.add(root);

        for (int i = 0; i < nodes.size(); i++) {
            TreeNode node = nodes.get(i);
            if (node == null) {
                continue;
            }
            node.val = arr[i];
            int leftIndex = (i << 1) + 1;
            if (leftIndex >= arr.length) {
                break;
            }
            node.left = TreeNode.init(arr[leftIndex]);
            nodes.add(node.left);

            int rightIndex = leftIndex + 1;
            if (rightIndex >= arr.length) {
                break;
            }
            node.right = TreeNode.init(arr[rightIndex]);
            nodes.add(node.right);
        }

        return root;
    }

    public static void main(String[] args) {
        Integer[] arr = {1, 3, 2, 5, 3, null, 9};
        TreeNode root = TreeNode.init(arr);
        System.out.println("");
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                '}';
    }
}
