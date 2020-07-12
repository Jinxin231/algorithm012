/*
 * @lc app=leetcode.cn id=21 lang=java
 *
 * [21] 合并两个有序链表
 */

// @lc code=start
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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        ListNode curr = dummy;
        while (l1 != null && l2 != null){
            if (l1.val <= l2.val){
                curr.next = l1; 
                curr = l1;
                l1 = l1.next;
            }
            else {
                curr.next = l2;
                curr = l2;
                l2 = l2.next;
            }
        }
        if ( l1 != null){
            curr.next = l1;
        }
        else {
            curr.next = l2;
        }
        return dummy.next;
    }
    
}
// @lc code=end

