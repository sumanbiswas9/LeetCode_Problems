// ============================================================
// Problem    : 2657. Find the Prefix Common Array of Two Arrays
// Difficulty : Medium
// URL        : https://leetcode.com/problems/find-the-prefix-common-array-of-two-arrays/
// Language   : Java
// Date       : 2026-05-20
// ============================================================
class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int C[] = new int[A.length];
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        for(int i=0;i<A.length;i++){
            if(A[i]==B[i]){
                C[i]=1;
                if(i>0) C[i]+=C[i-1];
            }else{
                set1.add(A[i]);
                set2.add(B[i]);
                if(set2.contains(A[i])) C[i]++;
                if(set1.contains(B[i])) C[i]++;
                if(i>0)C[i]+=C[i-1];
            }
        }
        return C;
    }
}