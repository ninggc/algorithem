//给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。 
//
// 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0]
//输出：[[],[0]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10 
// -10 <= nums[i] <= 10 
// nums 中的所有元素 互不相同 
// 
//
// Related Topics 位运算 数组 回溯 👍 1719 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

//    public List<List<Integer>> subsets(int[] nums) {
//        List<List<Integer>> ans = new ArrayList<>();
//
//        backTrack(nums, ans, 0);
//        ans.add(new ArrayList<>());
//        return ans;
//    }
//
//    private List<List<Integer>> backTrack(int[] nums, List<List<Integer>> ans, int index) {
//        List<List<Integer>> a1 = new ArrayList<>();
//        if (index == nums.length) {
//            return a1;
//        }
//
//        List<List<Integer>> a2 = backTrack(nums, ans, index + 1);
//
//        for (List<Integer> item : a2) {
//            List<Integer> l = new ArrayList<>(item);
//            l.add(nums[index]);
//            a1.add(l);
//        }
//
//        a1.add(Arrays.asList(nums[index]));
//        ans.addAll(a1);
//
//        return ans;
//    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i <= Integer.MAX_VALUE >> (31 - nums.length); i++) {
            for (int j = 0; j < nums.length; j++) {
                if ((i & (1 << j)) != 0) {
                    list.add(nums[j]);
                }
            }

            ans.add(new ArrayList<>(list));
            list.clear();
        }

        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
