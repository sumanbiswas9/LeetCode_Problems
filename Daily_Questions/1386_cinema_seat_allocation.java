// ============================================================
// Problem    : 1386. Cinema Seat Allocation
// Difficulty : Medium
// URL        : https://leetcode.com/problems/cinema-seat-allocation/
// Language   : Java
// Date       : 2026-08-19
// ============================================================
class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {

        // Store only rows that actually have reserved seats
        Map<Integer, Set<Integer>> map = new HashMap<>();

        for (int[] seat : reservedSeats) {
            map.computeIfAbsent(seat[0], k -> new HashSet<>())
               .add(seat[1]);
        }

        // Rows without any reserved seats can fit 2 families
        int count = (n - map.size()) * 2;

        for (Map.Entry<Integer, Set<Integer>> entry : map.entrySet()) {

            Set<Integer> reserved = entry.getValue();

            boolean left = true;    // 2-5
            boolean middle = true;  // 4-7
            boolean right = true;   // 6-9

            for (int seat = 2; seat <= 5; seat++) {
                if (reserved.contains(seat)) {
                    left = false;
                    break;
                }
            }

            for (int seat = 4; seat <= 7; seat++) {
                if (reserved.contains(seat)) {
                    middle = false;
                    break;
                }
            }

            for (int seat = 6; seat <= 9; seat++) {
                if (reserved.contains(seat)) {
                    right = false;
                    break;
                }
            }

            if (left && right) {
                count += 2;
            } else if (left || middle || right) {
                count += 1;
            }
        }

        return count;
    }
}