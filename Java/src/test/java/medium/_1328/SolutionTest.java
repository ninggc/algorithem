package medium._1328;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void letterCombinations() {

        Solution solution = new Solution();

        assertEquals("ab", solution.breakPalindrome("aa"));
        assertEquals("abb", solution.breakPalindrome("aba"));
        // 右边一般要替换最右边的
        assertEquals("aabab", solution.breakPalindrome("aabaa"));

    }
}