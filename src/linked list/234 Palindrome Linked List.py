# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None
"""
234 Palindrome linked list
Trivial solution is to copy it to an array and check if the array is a palindrome
Another solution would be to reverse it at the halfway point using fast and slow pointer, and check the palindrome that way
"""
class Solution:
    def isPalindrome(self, head: ListNode) -> bool:
        end_node = self.reverse(self.getHalfNode(head))
        head_node = head
        while end_node and head_node:
            if end_node.val != head_node.val:
                return False
            end_node, head_node = end_node.next, head_node.next
        return True
    
    def reverse(self, head):
        prev = None
        curr = head
        while curr:
            next_node = curr.next
            curr.next = prev
            prev = curr
            curr = next_node
        return prev
       
    def getHalfNode(self, head):
        slow = head
        fast = head
        while fast and fast.next:
            slow = slow.next
            fast = fast.next
            if fast:
                fast = fast.next
        return slow

"""
Use recursion to process the end nodes first, and at the same time move a second pointer 
outside of the recursive call
"""
class Solution:
    def isPalindrome(self, head):
        self.front_pointer = head
        return self.helper(head)
    
    def helper(self, curr):
        if not curr:
            return True
        # The recursive method has to be called first before the value check,
        # because we wan't the recursion to go all the way to the end first
        if self.helper(curr.next) and curr.val == self.front_pointer.val:
            self.front_pointer = self.front_pointer.next
            return True
        else:
            return False
        
        
    