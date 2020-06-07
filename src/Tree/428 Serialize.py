class Node:
    def __init__(self, val):
        self.val = val
        self.children = []

def serialize(root):
    if root is None:
        return ""
    res = str(root.val)
    res += "["
    for child in root.children:
        res += serialize(child)
    res += ']'
    return res

def deserialize(root):
    stack = collections.deque()


n1 = Node(1)
n2 = Node(2)
n3 = Node(3)
n4 = Node(4)
n1.children.append(n2)
n1.children.append(n3)
n1.children.append(n4)
n3.children.append(Node(5))
n3.children.append(Node(6))

print(serialize(n1))

