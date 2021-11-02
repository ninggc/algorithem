// package leetcode.editor.cn;
// // package leetcode.editor.cn.finished._655;
//
// //Print a binary tree in an m*n 2D string array following these rules:
// //
// //
// // The row number m should be equal to the height of the given binary tree.
// // The column number n should always be an odd number.
// // The root node's value (in string format) should be put in the exactly middle
// //of the first row it can be put. The column and the row where the root node belon
// //gs will separate the rest space into two parts (left-bottom part and right-botto
// //m part). You should print the left subtree in the left-bottom part and print the
// // right subtree in the right-bottom part. The left-bottom part and the right-bott
// //om part should have the same size. Even if one subtree is none while the other i
// //s not, you don't need to print anything for the none subtree but still need to l
// //eave the space as large as that for the other subtree. However, if two subtrees
// //are none, then you don't need to leave space for both of them.
// // Each unused space should contain an empty string "".
// // Print the subtrees following the same rules.
// //
// //
// // Example 1:
// //
// //Input:
// //     1
// //    /
// //   2
// //Output:
// //[["", "1", ""],
// // ["2", "", ""]]
// //
// //
// //
// //
// // Example 2:
// //
// //Input:
// //     1
// //    / \
// //   2   3
// //    \
// //     4
// //Output:
// //[["", "", "", "1", "", "", ""],
// // ["", "2", "", "", "", "3", ""],
// // ["", "", "4", "", "", "", ""]]
// //
// //
// //
// // Example 3:
// //
// //Input:
// //      1
// //     / \
// //    2   5
// //   /
// //  3
// // /
// //4
// //Output:
// //
// //[["",  "",  "", "",  "", "", "", "1", "",  "",  "",  "",  "", "", ""]
// // ["",  "",  "", "2", "", "", "", "",  "",  "",  "",  "5", "", "", ""]
// // ["",  "3", "", "",  "", "", "", "",  "",  "",  "",  "",  "", "", ""]
// // ["4", "",  "", "",  "", "", "", "",  "",  "",  "",  "",  "", "", ""]]
// //
// //
// //
// // Note:
// //The height of binary tree is in the range of [1, 10].
// // Related Topics 树
// // 👍 94 👎 0
//
//
// import leetcode.editor.cn.common.TreeNode;
//
// import java.util.ArrayList;
// import java.util.List;
//
// //leetcode submit region begin(Prohibit modification and deletion)
// /**
//  * Definition for a binary tree node.
//  * public class TreeNode {
//  *     int val;
//  *     TreeNode left;
//  *     TreeNode right;
//  *     TreeNode(int x) { val = x; }
//  * }
//  */
// class Solution {
//     public List<List<String>> printTree(TreeNode root) {
//
//         List<Integer> inOrderList = new ArrayList<>();
//         List<Integer> nodeDepth = new ArrayList<>();
//
//         inOrderList.add(null);
//         nodeDepth.add(0);
//         inOrderTraverse(root, inOrderList, nodeDepth, 0);
//         int row = nodeDepth.get(0) + 1;
//         int colume = (1 << row) - 1;
//
//         List<List<String>> result = new ArrayList<>(row);
//         for (int i = 0; i < row; i++) {
//             ArrayList<String> list = new ArrayList<>(colume);
//             for (int i1 = 0; i1 < colume; i1++) {
//                 list.add("");
//             }
//             result.add(list);
//         }
//         for (int i = 1; i < inOrderList.size(); i++) {
//             Integer index = nodeDepth.get(i);
//             if (index != null) {
//                 result.get(index).set(i - 1, String.valueOf(inOrderList.get(i)));
//             }
//         }
//         return result;
//     }
//
//     private void inOrderTraverse(TreeNode node, List<Integer> inOrderList, List<Integer> nodeDepth, int depth) {
//         if (node == null) {
//             inOrderList.add(null);
//             nodeDepth.add(null);
//             return;
//         }
//         inOrderTraverse(node.left, inOrderList, nodeDepth, depth + 1);
//         inOrderList.add(node.val);
//         nodeDepth.add(depth);
//         if (depth > nodeDepth.get(0)) {
//             nodeDepth.set(0, depth);
//         }
//         inOrderTraverse(node.right, inOrderList, nodeDepth, depth + 1);
//     }
// }
// //leetcode submit region end(Prohibit modification and deletion)
//
//
// class Main {
//     public static void main(String[] args) {
//         Integer[] arr = {1,2,3,null,4};
//         TreeNode root = TreeNode.init(arr);
//         new Solution().printTree(root);
//         System.out.println("");
//     }
// }