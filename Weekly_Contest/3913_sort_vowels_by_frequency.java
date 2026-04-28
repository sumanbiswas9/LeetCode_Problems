// ============================================================
// Problem    : 3913. Sort Vowels by Frequency
// Difficulty : Medium
// URL        : https://leetcode.com/problems/sort-vowels-by-frequency/
// Language   : Java
// Date       : 2026-04-28
// ============================================================
class Solution {

    class Pair {
        char ch;
        int count;
        int firstIndex;

        Pair(char ch) {
            this.ch = ch;
            this.count = 0;
            this.firstIndex = Integer.MAX_VALUE;
        }
    }

    public String sortVowels(String s) {

        List<Pair> ls = new ArrayList<>();
        ls.add(new Pair('a'));
        ls.add(new Pair('e'));
        ls.add(new Pair('i'));
        ls.add(new Pair('o'));
        ls.add(new Pair('u'));

        // Step 1: count + first occurrence
        for (int idx = 0; idx < s.length(); idx++) {
            char ch = s.charAt(idx);

            if (ch == 'a') {
                ls.get(0).count++;
                ls.get(0).firstIndex = Math.min(ls.get(0).firstIndex, idx);
            } else if (ch == 'e') {
                ls.get(1).count++;
                ls.get(1).firstIndex = Math.min(ls.get(1).firstIndex, idx);
            } else if (ch == 'i') {
                ls.get(2).count++;
                ls.get(2).firstIndex = Math.min(ls.get(2).firstIndex, idx);
            } else if (ch == 'o') {
                ls.get(3).count++;
                ls.get(3).firstIndex = Math.min(ls.get(3).firstIndex, idx);
            } else if (ch == 'u') {
                ls.get(4).count++;
                ls.get(4).firstIndex = Math.min(ls.get(4).firstIndex, idx);
            }
        }

        // Step 2: sort properly
        ls.sort((p1, p2) -> {
            if (p2.count != p1.count) {
                return p2.count - p1.count; // higher freq first
            }
            return p1.firstIndex - p2.firstIndex; // earlier first
        });

        // Step 3: rebuild string
        StringBuilder sb = new StringBuilder();
        int i = 0;

        for (char ch : s.toCharArray()) {
            if (isVowel(ch)) {
                while (i < 5 && ls.get(i).count == 0) i++;
                sb.append(ls.get(i).ch);
                ls.get(i).count--;
            } else {
                sb.append(ch);
            }
        }

        return sb.toString();
    }

    private boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}