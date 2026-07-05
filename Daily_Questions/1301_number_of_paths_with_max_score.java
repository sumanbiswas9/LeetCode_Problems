// ============================================================
// Problem    : 1301. Number of Paths with Max Score
// Difficulty : Hard
// URL        : https://leetcode.com/problems/number-of-paths-with-max-score/
// Language   : Java
// Date       : 2026-07-05
// ============================================================
class Solution {
    int MOD = 1000000007;

    class Pair {
        int sum;
        int path;

        Pair(int sum, int path) {
            this.sum = sum;
            this.path = path;
        }

        int getSum() {
            return sum;
        }

        int getPath() {
            return path;
        }
    }

    public int[] pathsWithMaxScore(List<String> board) {
        int n = board.size();
        Pair[][] dp = new Pair[n][n];

        // Base case: 'S' (bottom-right)
        dp[n - 1][n - 1] = new Pair(0, 1);

        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {

                char ch = board.get(i).charAt(j);
                if (ch == 'X') continue;
                if (i == n - 1 && j == n - 1) continue;

                Pair down = (i + 1 < n) ? dp[i + 1][j] : null;
                Pair right = (j + 1 < n) ? dp[i][j + 1] : null;
                Pair diag = (i + 1 < n && j + 1 < n) ? dp[i + 1][j + 1] : null;

                int max = -1;
                int ways = 0;
                if (down != null) {
                    if (down.getSum() > max) {
                        max = down.getSum();
                        ways = down.getPath();
                    } else if (down.getSum() == max) {
                        ways = (ways + down.getPath()) % MOD;
                    }
                }
                if (right != null) {
                    if (right.getSum() > max) {
                        max = right.getSum();
                        ways = right.getPath();
                    } else if (right.getSum() == max) {
                        ways = (ways + right.getPath()) % MOD;
                    }
                }
                if (diag != null) {
                    if (diag.getSum() > max) {
                        max = diag.getSum();
                        ways = diag.getPath();
                    } else if (diag.getSum() == max) {
                        ways = (ways + diag.getPath()) % MOD;
                    }
                }
                if (max == -1) continue;

                int val = (ch == 'E') ? 0 : (ch - '0');

                dp[i][j] = new Pair(max + val, ways);
            }
        }

        // If unreachable
        if (dp[0][0] == null) return new int[]{0, 0};

        return new int[]{
            dp[0][0].getSum() % MOD,
            dp[0][0].getPath() % MOD
        };
    }
}