/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun hasCycle(head: ListNode?): Boolean {
        if(head == null || head.next==null) return false

        var slow = head
        var fast = head.next
        while (fast != null && fast.next != null) {
            slow = slow?.next
            fast = fast?.next?.next

            if (slow === fast) {
                return true
            }
        }

        return false

    }
}
