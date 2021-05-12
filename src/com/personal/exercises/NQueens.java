package com.personal.exercises;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/problems/n-queens/
 */
public class NQueens {
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        List<List<String>> solutions = new ArrayList<>();

        for (int i = 0 ; i < n; i++) {
            for (int j = 0 ; j < n; j++) {
                board[i][j] = '.';
            }
        }

        Set<Integer> rows = new HashSet<>();
        position(n,  0, rows, board, solutions);

        return solutions;
    }

    private void position(int n, int currentRow, Set<Integer> cols, char[][] board,  List<List<String>> solutions ) {
        if (currentRow == n) {
            List<String> currSolution = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                currSolution.add(new String(board[i]));
            }
            solutions.add(currSolution);
        } else {
            for (int j = 0; j < n; j++) {
                if (!cols.contains(j) && !diagonalOccupied(n, currentRow, j, board)) {
                    board[currentRow][j] = 'Q';
                    cols.add(j);
                    position(n, currentRow + 1, cols, board, solutions);
                    cols.remove(j);
                    board[currentRow][j] = '.';
                }
            }
        }
    }

    private boolean diagonalOccupied(int n, int currentRow, int currentCol, char[][] board) {
        int c = currentCol;
        int r = currentRow;

        while (c>=0 && r >=0) {
            if (board[r][c] == 'Q') {
                return true;
            }
            c--;
            r--;
        }

        c = currentCol;
        r = currentRow;
        while (c < n && r >= 0) {
            if (board[r][c] == 'Q') {
                return true;
            }
            c++;
            r--;
        }

        return false;
    }
}
