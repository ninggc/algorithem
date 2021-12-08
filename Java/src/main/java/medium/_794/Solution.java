package medium._794;

/**
 * @description: TODO
 * @author: ninggc
 * @modified By: ninggc
 * @date: Created in 2021/12/9 0:05
 * @version:v1.0
 */
public class Solution {

    public boolean validTicTacToe(String[] board) {
        // 1. X的数量减去O的数量 = (X+O)%2
        byte x = 0;
        byte o = 0;
        for (byte i = 0; i < 3; i++) {
            for (byte j = 0; j < 3; j++) {
                char c = board[i].charAt(j);
                if (c == 'X') {
                    ++x;
                } else if (c == 'O') {
                    ++o;
                }
            }
        }
        if ((x - o) != 0 && (x - o) != 1) {
            return false;
        }

        // 2. 统计游戏结束的数量，小于等于1
        byte endSize = 0;
        for (byte i = 0; i < 3; i++) {
            endSize += row(board, (byte) i);
            endSize += col(board, (byte) i);
        }

        char c;
        if ((c = board[0].charAt(0)) != ' ' && c == board[1].charAt(1) && c == board[2].charAt(2)) {
            endSize++;
        }
        if ((c = board[2].charAt(0)) != ' ' && c == board[1].charAt(1) && c == board[0].charAt(2)) {
            endSize++;
        }

        if (endSize == 0 || endSize == 1) {
            return true;
        }
        if (endSize == 2) {
            int[][] coors = new int[][]{{0, 0}, {1, 1}, {2, 2}, {0, 2}, {2, 0}};
            byte xSize = 0;
            for (int[] coor : coors) {
                if (board[coor[0]].charAt(coor[1]) == 'X') {
                    // isX
                    ++xSize;
                }
                if (board[coor[0]].charAt(coor[1]) == ' ') {
                    return false;
                }
            }
            return xSize >= 3;
        }

        return false;

    }

    byte row(String[] board, byte i) {
        char s = board[i].charAt(0);
        if (s == ' ' || s != board[i].charAt(1) || s != board[i].charAt(2)) {
            return 0;
        }

        return 1;
    }

    byte col(String[] board, byte i) {
        char s = board[0].charAt(i);
        if (s == ' ' || s != board[1].charAt(i) || s != board[2].charAt(i)) {
            return 0;
        }

        return 1;
    }

}
