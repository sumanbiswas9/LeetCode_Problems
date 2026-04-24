// ============================================================
// Problem    : 37. Sudoku Solver
// Difficulty : Hard
// URL        : https://leetcode.com/problems/sudoku-solver/
// Language   : Java
// Date       : 2026-04-24
// ============================================================
class Solution {
    // Check if placing 'num' at board[row][col] is valid
    boolean isValid(char[][] board, int row, int col, char num) {
        // Check row
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == num) return false;
        }

        // Check column
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == num) return false;
        }

        // Check 3x3 subgrid
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[i][j] == num) return false;
            }
        }

        return true;
    }

    // Recursive backtracking solver
    boolean solve(char[][] board) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                // Find an empty cell
                if (board[row][col] == '.') {
                    // Try digits 1 to 9
                    for (char num = '1'; num <= '9'; num++) {
                        if (isValid(board, row, col, num)) {
                            board[row][col] = num; // place number
                            
                            // Recurse; if solved, return true
                            if (solve(board)) return true;

                            // Otherwise backtrack
                            board[row][col] = '.';
                        }
                    }
                    // If no number fits, trigger backtracking
                    return false;
                }
            }
        }
        // If no empty cell left, board is solved
        return true;
    }

    public void solveSudoku(char[][] board) {
        solve(board);
    }
}