#Initializing dummy nodes in python
class ListNode:
    def __init(self, value):
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
        
    def push(self, x):
        self.tail.next = ListNode(x)
        tail = tail.next
        heapq.heappush(self.max_heap, (-x, tail))
        
    def pop(self):
        top = tail
        if(top == self.max_heap[0][1]):
            heapq.heappop(self.max_heap)
        tail = tail.prev
        tail.next = None
        return top.val
    
    def top(self):
        return tail.val

    def peekMax(self):
        if not self.max_heap:
            return -1
        return heapq[0][0]

    def popMax(self):
        top = heapq.heappop(self.max_heap)[1]
        top.prev.next = top.next
        if top.next:
            top.next.prev = top.prev
        return top.val
        
m = MaxStack()

# Your MaxStack object will be instantiated and called as such:
# obj = MaxStack()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.top()
# param_4 = obj.peekMax()
# param_5 = obj.popMax()
