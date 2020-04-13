'''
Flatten multi-level linked list. Uses a stack instead of recursion 
'''
   def flatten(self, head: 'Node') -> 'Node':
        stack = collections.deque()
        curr = head
        while curr:
            if curr.next == None and len(stack) != 0:
                curr.next = stack.pop()
                curr.next.prev = curr
                curr = curr.next
            elif curr.child:
                if curr.next != None:
                    stack.append(curr.next)
                curr.next = curr.child
                curr.child = None
                curr.next.prev = curr
                curr = curr.next
            else: 
                curr = curr.next
        return head