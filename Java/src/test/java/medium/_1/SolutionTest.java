package medium._1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class SolutionTest {

    @Test
    public void letterCombinations() {
        Solution solution = new Solution();
        String[] strings = new String[]{"23"};

        List<List<String>> result = new ArrayList<>();
        for (String s : strings) {
            result.add(solution.letterCombinations(s));
        }

        System.out.println("end");

    }
}