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
        byte space = 0;
        for (byte i = 0; i < 3; i++) {
            for (byte j = 0; j < 3; j++) {
                char c = board[i].charAt(j);
                if (c == 'X') {
                    ++x;
                } else if (c == 'O') {
                    ++o;
                } else {
                    ++space;
                }
            }
        }
        if ((x - o) != 0 && (x - o) != 1) {
            return false;
        }

        // 2. 统计游戏结束的数量，小于等于1
        byte xWin = 0;
        byte oWin = 0;
        char c;
        for (byte i = 0; i < 3; i++) {
            c = row(board, i);
            if (c == 'X') {
                ++xWin;
            } else if (c == 'O') {
                ++oWin;
            }
            c = col(board, i);
            if (c == 'X') {
                ++xWin;
            } else if (c == 'O') {
                ++oWin;
            }
        }

        if ((c = board[0].charAt(0)) != ' ' && c == board[1].charAt(1) && c == board[2].charAt(2)) {
            if (c == 'X') {
                ++xWin;
            } else if (c == 'O') {
                ++oWin;
            }
        }
        if ((c = board[2].charAt(0)) != ' ' && c == board[1].charAt(1) && c == board[0].charAt(2)) {
            if (c == 'X') {
                ++xWin;
            } else if (c == 'O') {
                ++oWin;
            }
        }

        if (xWin == 0 && oWin == 0) {
            return true;
        } else if (xWin > 2 || oWin > 2) {
            return false;
        } else if (xWin > 0 && oWin > 0) {
            return false;
        } else {
           return space == 0;
        }

    }

    char row(String[] board, byte i) {
        char s = board[i].charAt(0);
        if (s == ' ' || s != board[i].charAt(1) || s != board[i].charAt(2)) {
            return ' ';
        }

        return s;
    }

    char col(String[] board, byte i) {
        char s = board[0].charAt(i);
        if (s == ' ' || s != board[1].charAt(i) || s != board[2].charAt(i)) {
            return ' ';
        }

        return s;
    }

}
