//给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1]
//输出：[[0,1],[1,0]]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 6 
// -10 <= nums[i] <= 10 
// nums 中的所有整数 互不相同 
// 
//
// Related Topics 数组 回溯 👍 2120 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        exe(nums, ans, new ArrayList<>(), 0);

        return ans;
    }

    private void exe(int[] nums, List<List<Integer>> ans, List<Integer> combine, int index) {
        if (index == nums.length) {
            ans.add(new ArrayList<>(combine));
            return;
        }

        for (int i = index; i < nums.length; i++) {
            combine.add(nums[i]);
            if (i != index) {
                swap(nums, i, index);
            }
            exe(nums, ans, combine, index + 1);
            if (i != index) {
                swap(nums, i, index);
            }
            combine.remove(index);
        }
    }

    private void swap(int[] nums, int left, int right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
