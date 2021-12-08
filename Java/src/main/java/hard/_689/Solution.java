package hard._689;

/**
 * @description: TODO
 * @author: ninggc
 * @modified By: ninggc
 * @date: Created in 2021/12/8 11:10
 * @version:v1.0
 */
public class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int[] res = new int[3];

        int[] group = new int[nums.length - k + 1];
        // 1. 利用滑动窗口计算前n-1组，每组的和

        for (int i = 0; i < k; i++) {
            int num = nums[i];
            group[0] += num;
        }

        for (int i = k; i < nums.length; i++) {
            int headIndex = i - k;
            int lastIndex = i;
            int groupIndex = i - (k - 1);
            group[groupIndex] = group[groupIndex - 1] + (nums[lastIndex] - nums[headIndex]);
        }

        // 2. 找出和最大的三个组

        // 3. 也要避免有重复值

        // TODO 2021/12/9 未完成
        return res;
    }
}
