from collections import deque
#graph is a list of integers
#This is the correct implamentation and how it should be done
#queue is allowed duplications but it will never be used more than once
def bfs(graph):
    explore = deque()
    discover = set()
    explore.append(0)
    while (len(explore) != 0): #return true if it is not empty otherwise return false
        toVisit = explore.popleft()
        if(toVisit not in discover): #This part will ignore any duplicates in the queue
            for elem in graph[toVisit]:
                explore.append(elem)
            discover.add(toVisit) 
            print(toVisit)

# recursive dfs traversal
def dfs(graph):
    def traverse_helper(graph, currNode, visited):
        visited.add(currNode)
        print(currNode)
        neighbor = graph[currNode]
        for i in range(0, len(neighbor)):
            if(neighbor[i] not in visited):
                traverse_helper(graph, neighbor[i] , visited)
                
    visited = set()
    traverse_helper(graph, 0, visited)

# iterative implamentation of dfs
def iterative_dfs(graph):
    explore = deque()
    discovered = set()
    explore.append(0)
    while(len(explore) != 0):
        currNode = explore.pop()
        if currNode not in discovered:
            for i in graph[currNode]:
                explore.append(i)
            discovered.add(currNode)
            print(currNode)
        
g = [[1,2,3], [2], [4], [4], []]
#bfs(g)
#iterative_dfs(g)
print("dfs checking within the for loop")
dfs(g)
print("checking dfs outside of the for loo")
dfs2(g)
        

