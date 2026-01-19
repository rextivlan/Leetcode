/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        //Reverse the second half
        ListNode prev = null;
        ListNode next = null;
        while(slow != null){
            next = slow.next;
            slow.next = prev;
            prev = slow;
            slow = next;
        }
        //Swap until the pointer meets
        ListNode current = head;
        while(current != prev && current.next != prev){
            ListNode tempLeft = current.next;
            ListNode tempRight = prev.next;
            current.next = prev;
            prev.next = tempLeft;
            prev = tempRight;
            current = tempLeft;
        }
    }
}