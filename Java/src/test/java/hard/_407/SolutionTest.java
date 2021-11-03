package hard._407;

import static org.junit.Assert.*;

import org.junit.Test;

public class SolutionTest {

    @Test
    public void trapRainWater() {
        int[][] heightMap = {{1, 4, 3, 1, 3, 2}, {3, 2, 1, 3, 2, 4}, {2, 3, 3, 2, 3, 1}};

        int water = new Solution().trapRainWater(heightMap);
    }
}