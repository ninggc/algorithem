package medium._794;

import org.junit.Test;


/**
 * @description: TODO
 * @author: ninggc
 * @modified By: ninggc
 * @date: Created in 2021/12/9 0:26
 * @version:v1.0
 */
public class SolutionTest {

    @Test
    public void validTicTacToe() {
        // boolean v1 = new Solution().validTicTacToe(new String[]{"O  ", "   ", "   "});
        // boolean v2 = new Solution().validTicTacToe(new String[]{"XOX", " X ", "   "});
        boolean v3 = new Solution().validTicTacToe(new String[]{"XXX", "   ", "OOO"});
        // boolean v4 = new Solution().validTicTacToe(new String[]{"XOX", "O O", "XOX"});
        // boolean v5 = new Solution().validTicTacToe(new String[]{"XXX", "OOX", "OOX"});
    }
}