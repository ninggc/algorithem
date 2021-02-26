package easy._169;

import java.util.Arrays;

class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    public static void main(String[] args) {
        int element = new Solution().majorityElement(new int[]{3, 3, 4});
        System.out.println(element);
    }
}