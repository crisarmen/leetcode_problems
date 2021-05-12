package com.personal.exercises;

/**
 * https://leetcode.com/problems/sudoku-solver/
 */
public class SudokuSolver {
    public void solveSudoku(char[][] board) {
        solveSudoku(0, board);
    }

    private boolean solveSudoku(int idx, char[][] board) {
        if(idx >= 81) {
            return true;
        } else {
            int i = idx / 9;
            int j = idx % 9;

            if(board[i][j] == '.') {
                for(int k = 1; k<= 9; k++){
                    board[i][j] = (char)(k + '0');
                    if(isValidSudoku(board)) {
                        if(solveSudoku(idx + 1, board)) {
                            return true;
                        }
                    }
                }
                board[i][j] = '.';
                return false;
            } else {
                return solveSudoku(idx + 1, board);
            }
        }

    }

    public boolean isValidSudoku(char[][] board) {
        for(int i=0; i< board.length; i++) {
            // all rows
            if(!isValid(i, i, 0, 8, board)) {
                return false;
            }

            // and cols
            if(!isValid(0, 8, i, i, board)) {
                return false;
            }
        }

        //squares
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if(!isValid(i * 3, (i+1) * 3 - 1, j*3, (j+1) * 3 - 1, board)) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean isValid(int startRow, int endRow, int startCol, int endCol, char[][]board) {
        boolean[] digits = new boolean[9];    //digits '1' (0) -> '9' (8)
        for(int i = startRow; i <= endRow; i++) {
            for(int j= startCol; j <= endCol; j++) {
                char c = board[i][j];

                if(c != '.') {
                    if (digits[c - '1']) {
                        return false;
                    } else {
                        digits[c - '1'] = true;
                    }
                }
            }
        }
        return true;
    }
}
