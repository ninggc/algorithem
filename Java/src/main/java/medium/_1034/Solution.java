package medium._1034;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];

        int targetColor = grid[row][col];
        visited[row][col] = true;

        List<int[]> boards = new ArrayList<>();
        dfs(grid, row, col, visited, targetColor, boards);
        for (int[] board : boards) {
            int x = board[0], y = board[1];
            grid[x][y] = color;
        }

        return grid;
    }

    private void dfs(int[][] grid, int row, int col, boolean[][] visited, int targetColor, List<int[]> boards) {
        int m = grid.length, n = grid[0].length;
        int[][] coor = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        boolean isBoard = false;
        for (int i = 0; i < 4; i++) {
            int x = row + coor[i][0], y = col + coor[i][1];
            if (!(x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == targetColor)) {
                isBoard = true;
            } else if (!visited[x][y]) {
                visited[x][y] = true;
                dfs(grid, x, y, visited, targetColor, boards);
            }
        }
        if (isBoard) {
            boards.add(new int[]{row, col});
        }
    }


    public static void main(String[] args) {
        int[][] ints = {{1, 2, 2}, {2, 3, 2}};
        int[][] colorBorder = new Solution().colorBorder(ints, 0, 1, 3);
    }
}
