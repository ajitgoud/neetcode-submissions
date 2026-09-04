/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        var first = l1
        var second = l2
        var carry = 0

        val dummy = ListNode(0)
        var current = dummy

        while (first != null || second != null || carry != 0) {
            val sum = (first?.`val` ?: 0) + (second?.`val` ?: 0) + carry

            carry = sum / 10
            current.next = ListNode(sum % 10)
            current = current.next!!

            first = first?.next
            second = second?.next
        }

        return dummy.next
    }
}
