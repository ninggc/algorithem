//以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返
//回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。 
//
// 
//
// 示例 1： 
//
// 
//输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
//输出：[[1,6],[8,10],[15,18]]
//解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
// 
//
// 示例 2： 
//
// 
//输入：intervals = [[1,4],[4,5]]
//输出：[[1,5]]
//解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。 
//
// 
//
// 提示： 
//
// 
// 1 <= intervals.length <= 10⁴ 
// intervals[i].length == 2 
// 0 <= starti <= endi <= 10⁴ 
// 
//
// Related Topics 数组 排序 👍 1568 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

//    public int[][] merge(int[][] intervals) {
//
//        boolean[] merged = new boolean[intervals.length];
//
//        for (int i = 0; i < intervals.length - 1; i++) {
//            for (int j = i; j < intervals.length - 1; j++) {
//                if (intervals[i][0] > intervals[i + 1][1] || intervals[i][1] < intervals[i + 1][0]) {
//
//                } else {
//                    merged[i] = true;
//                    int l = Math.min(intervals[i][0], intervals[i + 1][0]);
//                    int r = Math.max(intervals[i][1], intervals[i + 1][1]);
//                    intervals[i][0] = l;
//                    intervals[i][1] = r;
//                    intervals[i + 1][1] = l;
//                    intervals[i + 1][1] = r;
//                }
//            }
//        }
//
//
//        int notMerged = 0;
//        for (int i = 0; i < intervals.length; i++) {
//            if (!merged[i]) {
//                ++notMerged;
//            }
//        }
//        int[][] result = new int[notMerged][2];
//        for (int i = 0, j = 0; i < intervals.length; i++) {
//            if (merged[i]) {
//                continue;
//            }
//            result[j++] = intervals[i];
//        }
//
//        return result;
//    }

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (i1, i2) -> {
            return i1[0] - i2[0];
        });

        List<int[]> ans = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            if (i == 0 || ans.get(ans.size() - 1)[1] < intervals[i][0]) {
                ans.add(intervals[i]);
            } else {
                ans.get(ans.size() - 1)[1] = Math.max(ans.get(ans.size() - 1)[1], intervals[i][1]);
            }
        }

        return ans.toArray(new int[ans.size()][]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
