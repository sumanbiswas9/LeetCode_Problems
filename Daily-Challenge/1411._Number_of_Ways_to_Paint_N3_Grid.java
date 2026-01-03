package LeetCode_Problems;

class Number_of_Ways_to_Paint_N3_Grid {
    
    // Modulo value to avoid integer overflow
    private static final int MOD = 1_000_000_007;

    public int numOfWays(int n) {

        /*
         * same  -> number of ways to paint a row where
         *          the first and third cells have the SAME color
         * diff  -> number of ways to paint a row where
         *          the first and third cells have DIFFERENT colors
         *
         * For the first row:
         * - same = 6 (e.g., ABA patterns)
         * - diff = 6 (e.g., ABC patterns)
         */
        long same = 6;
        long diff = 6; 

        // Calculate number of ways for each row from 2 to n
        for (int i = 2; i <= n; i++) {

            /*
             * Transition:
             * - newSame:
             *   Can be formed by:
             *   1) same * 3  -> choosing a color different from adjacent cells
             *   2) diff * 2  -> choosing a valid color pattern from diff
             *
             * - newDiff:
             *   Can be formed by:
             *   1) same * 2
             *   2) diff * 2
             */
            long newSame = (same * 3 + diff * 2) % MOD;
            long newDiff = (same * 2 + diff * 2) % MOD;

            // Update values for next iteration
            same = newSame;
            diff = newDiff;
        }

        // Total ways = same patterns + different patterns
        return (int)((same + diff) % MOD);
    }

    public static void main(String[] args) {
        Number_of_Ways_to_Paint_N3_Grid solver = new Number_of_Ways_to_Paint_N3_Grid();
        int n = 3; // Example input
        int result = solver.numOfWays(n);
        System.out.println("Number of ways to paint a " + n + "x3 grid: " + result);
    }
}
