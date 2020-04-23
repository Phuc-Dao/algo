# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None
"""
19. Remove Nth Node from the end
use slow and fast pointer to find the nth element from the end
use sentinel node because we need an extre prev pointer
"""
class Solution:
    def removeNthFromEnd(self, head: ListNode, n: int) -> ListNode:
        sent = ListNode(-10)
        sent.next = head
        prev = sent
        slow = head
        fast = head
        for i in range(n):
            fast = fast.next
        while fast:
            fast = fast.next
            slow = slow.next
            prev = prev.next
        prev.next = slow.next
        return sent.next