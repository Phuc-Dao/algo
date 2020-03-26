"""
Optimization using an ordered heap and a doubly linked list
We use the heap to keep track of the max value. And the linked list to keep
track of the stack itself
* When we popmax we pop from the heap in logn time and we remove the link from the
doubly linked list

"""
# Use a compare wrapper inside a heapq by overriding the __lt__ method
class CompareWrapper:    
    def __init__(self, val, listnode, added):
        self.val = val
        self.listnode = listnode    
        self.added = added
    def __lt__(self, other):
        if self.val != other.val:
            return self.val < other.val
        else:
            return self.added < other.added

# Linked list node  
class ListNode:
    def __init__(self, value):
        self.val = value
        self.prev = None
        self.next = None

class MaxStack:
    def __init__(self):
        """
        initialize your data structure here.
        """
        self.head = ListNode(-1)
        self.tail = self.head
        self.max_heap = []    
        self.added = 0
        
    # Push an elem onto the stack and add it to the heap
    def push(self, x: int) -> None:
        node = ListNode(x)
        self.tail.next = node
        node.prev = self.tail
        self.tail = node
        heapq.heappush(self.max_heap, CompareWrapper(-x, self.tail, -self.added))
        self.added += 1
    
    # Remove the tail element from the linkedlist. If that element is in the
    # top element of the heap then we need to remove it from the heap as well
    def pop(self) -> int:
        if not self.max_heap:
            return -1   
        top = self.tail
        if(top == self.max_heap[0].listnode):
            heapq.heappop(self.max_heap)
            
        # Rearrange the order of the tail
        self.tail = self.tail.prev
        self.tail.next = None
        return top.val
    
    def top(self) -> int:
        return self.tail.val

    def peekMax(self) -> int:
        if not self.max_heap:
            return -1
        return self.max_heap[0].listnode.val

    def popMax(self) -> int:
        if not self.max_heap:
            return -1
        top = heapq.heappop(self.max_heap).listnode

        if(self.tail == top):
            self.tail = self.tail.prev
            self.tail.next = None
        else:
            if top.prev:
                top.prev.next = top.next
            if top.next:
                top.next.prev = top.prev
        return top.val

"""
716 max stack
"""
class MaxStack:

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.stack = []

    def push(self, x: int) -> None:
        self.stack.append(x)

    def pop(self) -> int:
        value = self.stack.pop()
        return value

    def top(self) -> int:
        return self.stack[-1]

    def peekMax(self) -> int:
        return max(self.stack)

    def popMax(self) -> int:
        maxElement = max(self.stack)
        maxIndex = 0
        for i in range(len(self.stack) - 1, -1, -1):
            if  maxElement== self.stack[i]:
                maxIndex = i
                break
        return self.stack.pop(maxIndex)
# Your MaxStack object will be instantiated and called as such:
# obj = MaxStack()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.top()
# param_4 = obj.peekMax()
# param_5 = obj.popMax()