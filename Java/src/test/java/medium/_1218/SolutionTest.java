package medium._1218;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


/**
 * @description: TODO
 * @author: ninggc
 * @modified By: ninggc
 * @date: Created in 2021/11/5 20:53:05
 * @version:v1.0
 */
public class SolutionTest {

    @Test
    public void longestSubsequence() {
        Solution solution = new Solution();

        // assertEquals(4, solution.longestSubsequence(new int[]{1, 2, 3, 4}, 1));
        // assertEquals(1, solution.longestSubsequence(new int[]{1, 3, 5, 7}, 1));
        assertEquals(2, solution.longestSubsequence(new int[]{3, 4, -3, -2, -4}, -5));
        // assertEquals(2, solution.longestSubsequence(new int[]{2, -6, -3, -6, 2, 0}, -2));
        assertEquals(2, solution.longestSubsequence(new int[]{3, 0, -3, 4, -4, 7, 6}, 3));
        assertEquals(4, solution.longestSubsequence(new int[]{1, 5, 7, 8, 5, 3, 4, 2, 1}, -2));
        assertEquals(2, solution.longestSubsequence(new int[]{4, 12, 10, 0, -2, 7, -8, 9, -9, -12, -12, 8, 8}, 0));
        assertEquals(3, solution.longestSubsequence(new int[]{16, -4, -6, -11, -8, -9, 4, -11, 15, 15, -9, 11, 7, -7, 10, -16, 4}, 3));


    }
}