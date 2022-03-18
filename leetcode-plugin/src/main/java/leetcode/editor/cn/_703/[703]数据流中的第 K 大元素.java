//设计一个找到数据流中第 k 大元素的类（class）。注意是排序后的第 k 大元素，不是第 k 个不同的元素。 
//
// 请实现 KthLargest 类： 
//
// 
// KthLargest(int k, int[] nums) 使用整数 k 和整数流 nums 初始化对象。 
// int add(int val) 将 val 插入数据流 nums 后，返回当前数据流中第 k 大的元素。 
// 
//
// 
//
// 示例： 
//
// 
//输入：
//["KthLargest", "add", "add", "add", "add", "add"]
//[[3, [4, 5, 8, 2]], [3], [5], [10], [9], [4]]
//输出：
//[null, 4, 5, 5, 8, 8]
//
//解释：
//KthLargest kthLargest = new KthLargest(3, [4, 5, 8, 2]);
//kthLargest.add(3);   // return 4
//kthLargest.add(5);   // return 5
//kthLargest.add(10);  // return 5
//kthLargest.add(9);   // return 8
//kthLargest.add(4);   // return 8
// 
//
// 
//提示：
//
// 
// 1 <= k <= 10⁴ 
// 0 <= nums.length <= 10⁴ 
// -10⁴ <= nums[i] <= 10⁴ 
// -10⁴ <= val <= 10⁴ 
// 最多调用 add 方法 10⁴ 次 
// 题目数据保证，在查找第 k 大元素时，数组中至少有 k 个元素 
// 
// Related Topics 树 设计 二叉搜索树 二叉树 数据流 堆（优先队列） 👍 329 👎 0


package leetcode.editor.cn._703;

import java.util.PriorityQueue;
import java.util.Queue;

//leetcode submit region begin(Prohibit modification and deletion)
class KthLargest {

    int k;
    Queue<Integer> queue;

    /**
     * 1. 每次都挑选出最大的
     *
     * @param k
     * @param nums
     */
    public KthLargest(int k, int[] nums) {
        this.k = k;
        queue = new PriorityQueue<>(k, Integer::compare);

        int i = 0;
        int n = nums.length;
        for (; i < k && i < n; i++) {
            queue.add(nums[i]);
        }
        for (; i < n; i++) {
            add(nums[i]);
        }
    }

    public int add(int val) {
        int min = queue.isEmpty() ? Integer.MIN_VALUE : queue.peek();
        if (val > min || queue.size() < k) {
            if (!queue.isEmpty() && queue.size() >= k) {
                queue.poll();
            }
            queue.add(val);
        }
        return queue.peek();
    }

    public static void main(String[] args) {
//        PriorityQueue<Integer> q = new PriorityQueue<>(10, Integer::compare);
//        for (int i = 0; i < 10; i++) {
//            q.add(i);
//        }
//
//        System.out.println("end");

//        KthLargest kthLargest = new KthLargest(3, new int[]{4, 5, 8, 2});
//        kthLargest.add(3);
//        kthLargest.add(5);
//        kthLargest.add(10);
//        kthLargest.add(9);
//        kthLargest.add(4);

        KthLargest kthLargest = new KthLargest(2, new int[]{0});
        kthLargest.add(-1);
        kthLargest.add(1);
        kthLargest.add(-2);
        kthLargest.add(-4);
        kthLargest.add(3);
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
//leetcode submit region end(Prohibit modification and deletion)
