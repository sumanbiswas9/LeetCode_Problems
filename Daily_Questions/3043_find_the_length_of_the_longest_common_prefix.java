// ============================================================
// Problem    : 3043. Find the Length of the Longest Common Prefix
// Difficulty : Medium
// URL        : https://leetcode.com/problems/find-the-length-of-the-longest-common-prefix/
// Language   : Java
// Date       : 2026-05-21
// ============================================================
class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        HashSet<String> set = new HashSet<>();
        for(int n : arr1){
            String num = String.valueOf(n);
            for(int i=0;i<num.length();i++){
                set.add(num.substring(0,num.length()-i));
            }
        }
        int len = 0;
        for(int n : arr2){
            String num = String.valueOf(n);
            for(int i=0;i<num.length();i++){
                if(set.contains(num.substring(0,num.length()-i))) len = Math.max(len,num.length()-i);
                if(num.length()-i<=len) break;
            }
        }
        return len;
    }
}