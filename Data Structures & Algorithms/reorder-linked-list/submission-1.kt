/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun reorderList(head: ListNode?): Unit {
        if (head?.next == null) return

        var slow: ListNode? = head
        var fast: ListNode? = head

        while (fast?.next != null && fast.next?.next != null) {
            slow = slow?.next
            fast = fast.next?.next
        }

        var second = slow?.next
        slow?.next = null

        var previous: ListNode? = null
        while (second != null) {
            val next = second.next
            second.next = previous
            previous = second
            second = next
        }

        var first: ListNode? = head
        second = previous

        while (second != null) {
            val firstNext = first?.next
            val secondNext = second.next

            first?.next = second
            second.next = firstNext

            first = firstNext
            second = secondNext
        }
    }
}
