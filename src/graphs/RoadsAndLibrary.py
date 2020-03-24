# Roads and Libraries hackerrank
# (int) n = The number of cities 1,2,3 .. n
# (int) c_lib = The cost for a library
# (int) c_road = the cost for a road
# (list[list[int]]) cities = a list of edges for example [[1,2] , [2,4]] is a graph of edges from 1 and 2 and 2 and 3
# approach: if cost of roads is higher than or equal to libraries then we just put a library for every node,
# otherwise we count the number of disconnected components, each component will get one library and get n - 1 roads where n is the 
# amount of nodes in the disconnected components. We will count the number of disconnect4ed components using bfs
def roadsAndLibraries(n, c_lib, c_road, cities):
    if c_road >= c_lib:
        return c_lib * n
    else:
    #First we will Generate the graph as an edjacency list
        graph = {}
        #generate empty graph
        for i in range(1, n + 1):
            graph[i] = []

        #populate the neighbors
        for i in range(0, len(cities)):
            edge = cities[i]
            graph[edge[0]].append(edge[1])
       
        #Array to keep the number of nodes per disconnected components
        disconnected = []
        visited = set()
        queue = deque()

        #count the number of disconnected components
        for i in range(1, n + 1 ):
            if i not in visited:
                #counting the nodes seen
                num_disconnected = 0
                queue.append(i)
                #while the queue is not empty continue popping
                while queue:
                    currNode = queue.popleft()
                    neighbors = graph[currNode]
                    for neigh in neighbors:
                        if neigh not in visited:
                            queue.append(neigh)
                    visited.add(currNode)
                    num_disconnected +=1
                #whenver the queue is empty we know that we have reached one components
                disconnected.append(num_disconnected)
        total = 0
        #Get the total sum
        for i in disconnected:
            total = total + c_lib + (c_road * (i - 1))
        return total