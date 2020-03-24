
from collections import deque
maze = [
    [0,0,0],
    [1,1,0],
    [1,1,0]
]


def add_neighbors(maze_map, current_node, queue):
    #add the top node
    if(current_node[0] -1 != -1 and maze_map[current_node[0] -1][current_node[1]] == 0):
        queue.append([current_node[0] - 1, current_node[1]])
    #add the bottom node
    if(current_node[0] + 1 < len(maze_map) and maze_map[current_node[0] +1][current_node[1]] == 0):
        queue.append([current_node[0] + 1, current_node[1]])
    #add the left node
    if(current_node[0] - 1 != -1 and maze_map[current_node[0]][current_node[1] - 1] == 0):
        queue.append([current_node[0],current_node[1] - 1])
    #add the right node
    if(current_node[0] + 1 < len(maze_map) and maze_map[current_node[0]][current_node[1] + 1] == 0):
        queue.append([current_node[0], current_node[1] + 1])
    
def shortest_path(maze_map, src, dest):
    start = maze_map[src[0]][src[1]]
    maze_map[src[0]][src[1]] = -1 #set inital node as visited
    q  = deque() #initialize empty queue
    q.append([src[0], src[1]])
    while q:
        curr = q.pop()
        if (curr[0] == dest[0] and curr[1] == dest[1]):
            return True
        add_neighbors(maze_map, curr, q) #add the neighbors of the node which has not been visisted yet
        maze_map[curr[0]][curr[1]] = -1 #makr the maze as -1 which essentially means its beebin visited
    print(maze_map)
    return False

print(shortest_path(maze, [0,0], [2,2]))