//给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。 
//
// 数组中的每个元素代表你在该位置可以跳跃的最大长度。 
//
// 判断你是否能够到达最后一个下标。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,3,1,1,4]
//输出：true
//解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,2,1,0,4]
//输出：false
//解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 3 * 10⁴ 
// 0 <= nums[i] <= 10⁵ 
// 
//
// Related Topics 贪心 数组 动态规划 👍 1923 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
//    public boolean canJump(int[] nums) {
//
//        int n = nums.length;
//        if (n == 1) {
//            return true;
//        }
//
//        return backTrack(nums, 0, new Boolean[n]);
//    }
//
//    private boolean backTrack(int[] nums, int index, Boolean[] lot) {
//        if (index == nums.length - 1) {
//            return true;
//        }
//        if (lot[index] != null) {
//            return lot[index];
//        }
//
//        for (int i = index + 1; i <= (index + nums[index]); i++) {
//            if (backTrack(nums, i, lot)) {
//                return true;
//            }
//        }
//
//        lot[index] = false;
//        return false;
//    }

        public boolean canJump(int[] nums) {
//            if (nums.length == 1) {
//                return true;
//            }
//
//            boolean[] booleans = new boolean[nums.length];
//            booleans[0] = true;
//            for (int i = 0; i < nums.length; i++) {
//                if (!booleans[i]) {
//                    continue;
//                }
//
//                for (int j = i + 1; j <= i + nums[i] && j < nums.length; j++) {
//                    if (j == nums.length - 1) {
//                        return true;
//                    }
//                    booleans[j] = true;
//                }
//            }
//
//            return false;
            int k = 0;
            for (int i = 0; i < nums.length; i++) {
                if (i > k) {
                    return false;
                }

                k = Math.max(k, i + nums[i]);
            }

            return true;
        }

}
//leetcode submit region end(Prohibit modification and deletion)
