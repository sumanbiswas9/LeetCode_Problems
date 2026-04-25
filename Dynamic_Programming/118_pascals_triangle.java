// ============================================================
// Problem    : 118. Pascal's Triangle
// Difficulty : Easy
// URL        : https://leetcode.com/problems/pascals-triangle/
// Language   : Java
// Date       : 2026-04-25
// ============================================================
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> curr = null;
        for(int i=0;i<numRows;i++){
            List<Integer> ls = new ArrayList<>();
            if(i>0) curr = list.get(i-1);
            for(int j=0;j<=i;j++){
                if(j==0 || j==i) {
                    ls.add(1);
                }else{
                    int left = curr.get(j-1);
                    int up = curr.get(j);
                    ls.add(left+up);
                }
            }
            list.add(ls);
        }
        return list;
    }
}