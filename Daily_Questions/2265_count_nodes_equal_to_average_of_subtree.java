// ============================================================
// Problem    : 2265. Count Nodes Equal to Average of Subtree
// Difficulty : Medium
// URL        : https://leetcode.com/problems/count-nodes-equal-to-average-of-subtree/
// Language   : Java
// Date       : 2026-09-10
// ============================================================
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int[] helper(TreeNode root) {
        if(root==null) return null;
        if(root.left==null && root.right==null) return new int[]{root.val, 1,1};
        int left[] = helper(root.left);
        int right[] = helper(root.right);
        if(left!=null && right !=null){
            int leftSum = left[0];
            int rightSum = right[0];
            int totalNode = left[2]+right[2]+1;
            int totalAvg = (leftSum + rightSum + root.val ) /totalNode;
            int totalCurrentSubTree = left[1] + right[1];
            int totalSum = leftSum + rightSum+root.val;
            if(totalAvg == root.val) totalCurrentSubTree++;
            return new int[]{ totalSum,totalCurrentSubTree,totalNode};
        }else if(left==null && right==null){
            return new int[]{0 ,0 };
        }else if(left==null){
            int rightSum = right[0];
            int totalNode = right[2]+1;
            int totalAvg = (rightSum + root.val ) /totalNode;
            if(totalAvg==root.val) right[1]++;
            return new int[]{rightSum+root.val , right[1],totalNode};
        }else{
            int leftSum = left[0];
            int totalNode = left[2]+1;
            int totalAvg = (leftSum + root.val ) /totalNode;
            if(totalAvg==root.val) left[1]++;
            return new int[]{leftSum + root.val,left[1],totalNode};
        }
    }
    public int averageOfSubtree(TreeNode root) {
        int res[] = helper(root);
        if(res==null) return 0;
        else return res[1];
    }
}