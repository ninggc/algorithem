package interview;

public class Target {
    static final int[] nums = {2, 7, 11, 15, 19, 23, 27, 35};
    static final int target = 9;

    public static void main(String[] args) {
        int[] result = findFirstTarget(nums, target);
        System.out.println("[" + result[0] + ", " + result[1] + "]");
    }

    private static int[] findFirstTarget(int[] nums, int target) {
        int[] result = {-1, -1};
        if (nums == null || nums.length < 2 || target < 0) {
            return result;
        }

        int requireMinIndex = 0;
        int requireMaxIndex = nums.length - 1;
        boolean switchDirection = false;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num <= target >> 1) {
                // 找到target/2的位置为max，目标值中较小的值会出现在min-max的范围之间
                requireMaxIndex = i;
                continue;
            }
            if (num > target) {
                break;
            }

            if (switchDirection) {
                // 从max向min逼近，同时max向左缩小范围
                for (int j = requireMaxIndex; j >= requireMinIndex; j--) {
                    int numPlus = num + nums[j];
                    if (numPlus > target) {
                        requireMaxIndex--;
                    } else if (numPlus < target) {
                        break;
                    } else if (numPlus == target) {
                        result[0] = j;
                        result[1] = i;
                        return result;
                    }
                }
            } else {
                // 从min向max逼近，同时min向右缩小范围
                for (int j = requireMinIndex; j <= requireMaxIndex; j++) {
                    int numPlus = num + nums[j];
                    if (numPlus < target) {
                        requireMinIndex++;
                    } else if (numPlus > target) {
                        break;
                    } else if (numPlus == target) {
                        result[0] = j;
                        result[1] = i;
                        return result;
                    }
                }
            }
            switchDirection = !switchDirection;
        }
        return result;
    }
}
