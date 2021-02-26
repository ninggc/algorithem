package easy._169;

import java.util.Arrays;

class Solution {
    public int majorityElement(int[] nums) {
        Integer[] battleField = new Integer[nums.length];
        int battleFieldLength = 1;

        battleField[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int v = nums[i];
            for (int j = 0; j <= battleFieldLength; j++) {
                if (j == battleFieldLength) {
                    battleField[j] = v;
                    ++battleFieldLength;
                    break;
                }

                if (battleField[j] != v) {
                    battleField[j] = battleField[battleFieldLength - 1];
                    battleField[battleFieldLength - 1] = null;
                    --battleFieldLength;
                    break;
                }

            }
        }

        for (int i = 0; i < battleField.length; i++) {
            if (battleField[i] != null) {
                return battleField[i];
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        int element = new Solution().majorityElement(new int[]{6,6,6, 6,6,7,7});
        System.out.println(element);
    }
}