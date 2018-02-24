package easy.array;


/*
 Example:

 Given nums = [1,1,2],

 Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.
 It doesn't matter what you leave beyond the new length.

 */

/**
 * <a href="https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/">题目链接</>
 * Remove Duplicates from Sorted Array
 * 移除重复的数字后返回不重复的数字个数
 */
class Solution {
    public int removeDuplicates(int[] nums) {
        int j = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[j]) {
                ++j;
                nums[j] = nums[i];
            }
        }

        return nums.length == 0 ? 0 : j + 1;
    }
}