// package leetcode.editor.cn;
//
// //给定一个整数数组 nums 和一个正整数 k，找出是否有可能把这个数组分成 k 个非空子集，其总和都相等。
// //
// // 示例 1：
// //
// // 输入： nums = [4, 3, 2, 3, 5, 2, 1], k = 4
// //输出： True
// //说明： 有可能将其分成 4 个子集（5），（1,4），（2,3），（2,3）等于总和。
// //
// //
// //
// // 提示：
// //
// //
// // 1 <= k <= len(nums) <= 16
// // 0 < nums[i] < 10000
// //
// // Related Topics 递归 动态规划
// // 👍 314 👎 0
//
//
// import com.sun.deploy.util.StringUtils;
//
// import java.util.Arrays;
//
// //leetcode submit region begin(Prohibit modification and deletion)
// class Solution {
//     public boolean canPartitionKSubsets(int[] nums, int k) {
//         int sum = Arrays.stream(nums).sum();
//         if (sum % k != 0) return false;
//
//
//         return false;
//     }
// }
// //leetcode submit region end(Prohibit modification and deletion)
