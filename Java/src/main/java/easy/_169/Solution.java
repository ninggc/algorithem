package easy._169;

import java.util.Arrays;

class Solution {
    public int majorityElement(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        Arrays.sort(nums);

        int currentCount = 1;
        int currentValue = nums[0];

        int maxCount = currentCount;
        int maxValue = currentValue;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == currentValue) {
                ++currentCount;
            } else {
                if (currentCount > maxCount) {
                    maxCount = currentCount;
                    maxValue = currentValue;
                }

                currentCount = 1;
                currentValue = nums[i];
            }
        }

        return currentCount > maxCount ? currentValue : maxValue;
    }

    public static void main(String[] args) {
        int element = new Solution().majorityElement(new int[]{3, 3, 4});
        System.out.println(element);
    }
}