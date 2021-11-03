package hard._407;

import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Queue;

class Solution {

    private class Coords {

        private final int x;
        private final int y;

        public Coords(int i, int j) {
            x = i;
            y = j;
        }
    }

    public int trapRainWater(int[][] heightMap) {
        Queue<Coords> candidate = new LinkedList<>();

        if (heightMap == null || heightMap.length <= 1 || heightMap[0].length <= 1) {
            return 0;
        }
        int row = heightMap.length;
        int column = heightMap[0].length;

        int[][] edge = new int[row][column];
        for (int i = 0; i < row; i++) {
            edge[i][0] = Integer.MIN_VALUE;
            edge[i][column - 1] = Integer.MIN_VALUE;
        }
        for (int i = 0; i < column; i++) {
            edge[0][i] = Integer.MIN_VALUE;
            edge[row - 1][i] = Integer.MIN_VALUE;
        }
        for (int i = 1; i < heightMap.length - 1; i++) {
            for (int j = 1; j < heightMap[i].length - 1; j++) {
                hold(heightMap, i, j, edge, candidate);
            }
        }

        Coords coords = null;
        while ((coords = candidate.poll()) != null) {
            hold(heightMap, coords.x, coords.y, edge, candidate);
        }

        return collect(edge);
    }

    private int collect(int[][] edge) {
        return 0;
    }

    private boolean hold(int[][] heightMap, int i, int j, int[][] edge, Queue<Coords> candidate) {
        int target = heightMap[i][j];
        boolean hold =
            (edge[i][j - 1] == Integer.MAX_VALUE || target < heightMap[i][j - 1])
                && (edge[i][j + 1] == Integer.MAX_VALUE || target < heightMap[i][j + 1])
                && (edge[i - 1][j] == Integer.MAX_VALUE || target < heightMap[i - 1][j])
                && (edge[i + 1][j] == Integer.MAX_VALUE || target < heightMap[i + 1][j]);
        if (hold) {
            edge[i][j] = Integer.MAX_VALUE;
            if (edge[i][j - 1] == 0) {
                candidate.add(new Coords(i, j - 1));
            }
            if (edge[i][j + 1] == 0) {
                candidate.add(new Coords(i, j - 1));
            }
            if (edge[i - 1][j] == 0) {
                candidate.add(new Coords(i, j - 1));
            }
            if (edge[i + 1][j] == 0) {
                candidate.add(new Coords(i, j - 1));
            }
            return true;
        }

        edge[i][j] = Integer.MIN_VALUE;
        return false;

    }
}