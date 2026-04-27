// ============================================================
// Problem    : 142. Linked List Cycle II
// Difficulty : Medium
// URL        : https://leetcode.com/problems/linked-list-cycle-ii/
// Language   : Java
// Date       : 2026-04-27
// ============================================================
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return head;
        }
        boolean isCycle=false;
        
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                isCycle= true;
                break;
            }
        }

        if(!isCycle){
            return null;
        }
        
        slow=head;
        while(slow!=fast){
            slow=slow.next;
            fast=fast.next;
        }
        return slow;
    }
}