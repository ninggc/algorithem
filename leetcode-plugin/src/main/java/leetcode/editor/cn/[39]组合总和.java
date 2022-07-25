//给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使数字和为目标数 target 的
// 所有 不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。 
//
// candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。 
//
// 对于给定的输入，保证和为 target 的不同组合数少于 150 个。 
//
// 
//
// 示例 1： 
//
// 
//输入：candidates = [2,3,6,7], target = 7
//输出：[[2,2,3],[7]]
//解释：
//2 和 3 可以形成一组候选，2 + 2 + 3 = 7 。注意 2 可以使用多次。
//7 也是一个候选， 7 = 7 。
//仅有这两种组合。 
//
// 示例 2： 
//
// 
//输入: candidates = [2,3,5], target = 8
//输出: [[2,2,2,2],[2,3,3],[3,5]] 
//
// 示例 3： 
//
// 
//输入: candidates = [2], target = 1
//输出: []
// 
//
// 
//
// 提示： 
//
// 
// 1 <= candidates.length <= 30 
// 1 <= candidates[i] <= 200 
// candidate 中的每个元素都 互不相同 
// 1 <= target <= 500 
// 
//
// Related Topics 数组 回溯 👍 2073 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

//    public List<List<Integer>> combinationSum(int[] candidates, int target) {
//
//        Arrays.sort(candidates);
//        int divide = target / candidates[candidates.length - 1];
//
//        return fun(candidates, target, candidates.length - 1);
//    }
//
//    private List<List<Integer>> fun(int[] candidates, int target, int index) {
//        List<List<Integer>> ans = new ArrayList<>();
//        if (target == 0) {
//            ans.add(new ArrayList<>());
//            return ans;
//        } else if (target < 0 || index == -1) {
//            return ans;
//        }
//
//        if (index < candidates.length - 1 && candidates[index] == candidates[index + 1]) {
//            return fun(candidates, target, index - 1);
//        }
//
//        int divide = target / candidates[index];
//        for (int j = 0; j < divide + 1; j++) {
//            List<List<Integer>> ans1 = fun(candidates, target - (j) * candidates[index], index - 1);
//
//            for (int k = 0; k < j; k++) {
//                for (List<Integer> ans2 : ans1) {
//                    ans2.add(candidates[index]);
//                }
//            }
//            ans.addAll(ans1);
//        }
//
//        return ans;
//    }

    public List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        dfs(candidates, target, new ArrayList<>(), 0);
        return ans;
    }

    private void dfs(int[] candidates, int target, List<Integer> combine, int index) {

        if (index == candidates.length) {
            return;
        }

        if (target == 0) {
            ans.add(new ArrayList<>(combine));
            return;
        }

        dfs(candidates, target, combine, index + 1);

        if (target - candidates[index] >= 0) {

            combine.add(candidates[index]);
            dfs(candidates, target - candidates[index], combine, index);
            combine.remove(combine.size() - 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
