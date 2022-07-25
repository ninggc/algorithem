//给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。 
//
// 子数组 是数组中的一个连续部分。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
//输出：6
//解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1]
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：nums = [5,4,-1,7,8]
//输出：23
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// 
//
// 
//
// 进阶：如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的 分治法 求解。 
//
// Related Topics 数组 分治 动态规划 👍 5136 👎 0


package leetcode.editor.cn;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
//    无效实现 n^2超时了
//    public int maxSubArray(int[] nums) {
//        int n = nums.length;
//        int[][] dp = new int[n][n];
//
//        int max = Integer.MIN_VALUE;
//        for (int i = 0; i < n; i++) {
//            dp[i][i] = nums[i];
//            max = Math.max(max, dp[i][i]);
//            for (int j = i + 1; j < n; j++) {
//                dp[i][j] = dp[i][j - 1] + nums[j];
//                max = Math.max(max, dp[i][j]);
//            }
//        }
//
//        return max;
//    }

    // 动态规划
//    public int maxSubArray(int[] nums) {
//        int n = nums.length;
//        int[] dp = new int[n];
//
//        int max = dp[0] = nums[0];
//        for (int i = 1; i < n; i++) {
//            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
//            max = Math.max(max, dp[i]);
//        }
//
//        return max;
//    }

    // 贪心算法
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            max = Math.max(sum, max);

            if (sum < 0) {
                sum = 0;
            }
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
