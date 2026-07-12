// ============================================================
// Problem    : 1331. Rank Transform of an Array
// Difficulty : Easy
// URL        : https://leetcode.com/problems/rank-transform-of-an-array/
// Language   : Java
// Date       : 2026-07-12
// ============================================================
class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int res[] = new int[arr.length];
        // PriorityQueue<int[]> pq = new PriorityQueue<>(Collections.reverseOrder());
        int newArr[][] = new int[arr.length][2];
        for(int i=0;i<arr.length;i++){
            // pq.offer(new int[]{arr[i],i});
            newArr[i][0] = arr[i];
            newArr[i][1] = i;
        }
        Arrays.sort(newArr,(a,b)->Integer.compare(b[0],a[0]));
        int unique=1;
        for(int i=1;i<newArr.length;i++){
            if(newArr[i][0]<newArr[i-1][0]) unique++;
        }
        int prev=Integer.MIN_VALUE;
        int rank=unique+1;
        for(int i=0;i<res.length;i++){
            if(newArr[i][0]!=prev) rank--;
            res[newArr[i][1]] = rank;
            prev = newArr[i][0];
        }
        return res;
    }
}