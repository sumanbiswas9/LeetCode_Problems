// ============================================================
// Problem    : 1291. Sequential Digits
// Difficulty : Medium
// URL        : https://leetcode.com/problems/sequential-digits/
// Language   : Java
// Date       : 2026-07-13
// ============================================================
class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> res = new ArrayList<>();
        for(int i=1;i<10;i++){
            int num=0;
            for(int j=i;j<10;j++){
                num = num*10 + j;
                if(num>high) break;
                if(num>=low && num<=high) res.add(num);
            }
        }
        Collections.sort(res);
        return res;
    }
}