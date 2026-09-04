/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        if(head==null) return null
        var totalNodes = 0
        var curr = head
        while(curr!=null){
            totalNodes++
            curr = curr?.next
        }

        if(totalNodes == n){
            return head?.next
        }

        var steps = totalNodes - n - 1
        curr = head
        while(steps>0){
            curr = curr?.next
            steps--
        }
        
        curr?.next = curr?.next?.next

        return head


    }
}
