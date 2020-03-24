#Hacker rank journey to the moonn
#approach: Since we are looking for relationsips ( in our case we want to find if the astronauts are from the same country)
#We will create a graph, where the node are the astronaut and they are connected if they are from the same country
#Find all the connected components and use to calculate the number of pairs where the astronauts are from different country
def journeyToMoon(n, astronaut):
    
    if len(astronaut) == 0:
        return 0

    #Generate an empty graph where the key are the astronauts and the value are empty lists
    #We will fill this out later
    graph = {k : [] for k in range(0, n)}
    
    #Every pair signifies two astronaut from the same country, so just
    #look for pair[0] which is the key, and append pair[1] which is the neighbor
    for pair in astronaut:
        graph[pair[0]].append(pair[1]) 

    #used to count the number of nodes per disconnected component
    #for example if there are two disconneceted graphs with thre nodes each,
    # then the list will be [2,2,2]
    disconnected = []

    #perform bfs to find all the nodes that are connected
    queue = deque()
    visited = set()
    #Iterate through every node in the graph, and ignore all the ones we have already seen
    for ids in range(0, n):
        if ids not in visited:
            queue.append(ids)
            nodeCount = 0
            while queue:
                currNode = queue.popleft()
                for neighbor in graph[currNode]:
                    if neighbor not in visited:
                        queue.append(neighbor)
                #MARK every reachable node in the connected component as visisted, so we 
                #dont revisit it when we are iterating through all the nodes
                visited.add(currNode)
                #increment the node count of the connected component
                nodeCount += 1  
            disconnected.append(nodeCount) 

    #Get the number of combinations. Not to sure about this but it works sometimes
    sum = 0;
    result = 0;
    for size in disconnected:
        result += sum*size;
        sum += size;    
    return result;