// ============================================================
// Problem    : 273. Integer to English Words
// Difficulty : Hard
// URL        : https://leetcode.com/problems/integer-to-english-words/
// Language   : Java
// Date       : 2026-05-13
// ============================================================
import java.util.*;

class Solution {

    String[] belowTen = {
        "", "One", "Two", "Three", "Four",
        "Five", "Six", "Seven", "Eight", "Nine"
    };

    String[] belowTwenty = {
        "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen",
        "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"
    };

    String[] tens = {
        "", "", "Twenty", "Thirty", "Forty",
        "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"
    };

    public String numberToWords(int num) {

        if (num == 0) return "Zero";

        return solve(num).trim();
    }

    private String solve(int num) {

        if (num < 10) {
            return belowTen[num];

        } else if (num < 20) {
            return belowTwenty[num - 10];

        } else if (num < 100) {

            return tens[num / 10] +
                    (num % 10 != 0 ? " " + solve(num % 10) : "");

        } else if (num < 1000) {

            return solve(num / 100) + " Hundred" +
                    (num % 100 != 0 ? " " + solve(num % 100) : "");

        } else if (num < 1_000_000) {

            return solve(num / 1000) + " Thousand" +
                    (num % 1000 != 0 ? " " + solve(num % 1000) : "");

        } else if (num < 1_000_000_000) {

            return solve(num / 1_000_000) + " Million" +
                    (num % 1_000_000 != 0 ? " " + solve(num % 1_000_000) : "");

        }

        return solve(num / 1_000_000_000) + " Billion" +
                (num % 1_000_000_000 != 0
                        ? " " + solve(num % 1_000_000_000)
                        : "");
    }
}