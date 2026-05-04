// ============================================================
// Problem    : 48. Rotate Image
// Difficulty : Medium
// URL        : https://leetcode.com/problems/rotate-image/
// Language   : Java
// Date       : 2026-05-04
// ============================================================
class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int layer = 0; layer < n / 2; layer++) {
            int start = layer;
            int end = n - layer - 1;
            for (int i = 0; i < end - start; i++) {
                int topLeft = matrix[start][start + i];
                int topRight = matrix[start + i][end];
                int bottomRight = matrix[end][end - i];
                int bottomLeft = matrix[end - i][start];
                matrix[start][start + i] = bottomLeft;
                matrix[start + i][end] = topLeft;
                matrix[end][end - i] = topRight;
                matrix[end - i][start] = bottomRight;
            }
        }
    }
}