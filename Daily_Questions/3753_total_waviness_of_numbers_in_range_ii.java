// ============================================================
// Problem    : 3753. Total Waviness of Numbers in Range II
// Difficulty : Hard
// URL        : https://leetcode.com/problems/total-waviness-of-numbers-in-range-ii/
// Language   : Java
// Date       : 2026-06-05
// ============================================================
class Solution {
    static class Node {
        long cnt;
        long sum;
        Node(long cnt, long sum) {
            this.cnt = cnt;
            this.sum = sum;
        }
    }

    char[] s;
    Node[][][][] memo;

    private Node dfs(int pos, int lenState, int last2, int last1, boolean tight) {
        if (pos == s.length) {
            return new Node(1, 0);
        }

        if (!tight && memo[pos][lenState][last2 + 1][last1 + 1] != null) {
            return memo[pos][lenState][last2 + 1][last1 + 1];
        }

        int limit = tight ? s[pos] - '0' : 9;
        long cnt = 0;
        long sum = 0;

        for (int d = 0; d <= limit; d++) {
            boolean nt = tight && d == limit;

            if (lenState == 0) {
                if (d == 0) {
                    Node nxt = dfs(pos + 1, 0, -1, -1, nt);
                    cnt += nxt.cnt;
                    sum += nxt.sum;
                } else {
                    Node nxt = dfs(pos + 1, 1, -1, d, nt);
                    cnt += nxt.cnt;
                    sum += nxt.sum;
                }
            } else if (lenState == 1) {
                Node nxt = dfs(pos + 1, 2, last1, d, nt);
                cnt += nxt.cnt;
                sum += nxt.sum;
            } else {
                int add = ((last1 > last2 && last1 > d) || (last1 < last2 && last1 < d)) ? 1 : 0;
                Node nxt = dfs(pos + 1, 2, last1, d, nt);
                cnt += nxt.cnt;
                sum += nxt.sum + nxt.cnt * add;
            }
        }

        Node res = new Node(cnt, sum);
        if (!tight) {
            memo[pos][lenState][last2 + 1][last1 + 1] = res;
        }
        return res;
    }

    private long solve(long n) {
        if (n < 0) return 0;

        s = Long.toString(n).toCharArray();
        memo = new Node[s.length][3][11][11];
        return dfs(0, 0, -1, -1, true).sum;
    }

    public long totalWaviness(long num1, long num2) {
        return solve(num2) - solve(num1 - 1);
    }
}