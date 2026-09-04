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
        println(totalNodes)
        var nodes = totalNodes - n
        curr = head
        var tempHead = head
        while(nodes>1){
            curr = curr?.next
            nodes--
        }
        if(totalNodes-n>0){
            val temp = curr?.next
            curr?.next = temp?.next
            temp?.next = null
        }else{
            val temp = tempHead
            tempHead = tempHead?.next
            temp?.next = null
        }

        return tempHead


    }
}
