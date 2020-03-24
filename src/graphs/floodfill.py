matrix = [
    [1,0,2,2,2],
    [1,0,0,2,2],
    [1,1,1,0,2],
    [1,0,0,0,2],
    [1,0,2,2,2]
]

#recursive floodfill
#matrix = the matrix we are filing
#x, y = integer representing colun and row
#num = the number that we are filling it with
#prev = the first number that we are changing, in our example it is 1, checks if we find something that is not a one
def floodFill(matrix, x, y, num, prev):
    #base case if we reach the edge
    if(x == -1 or y == -1 or x == len(matrix) or y == len(matrix)):
        return
    #other base case if we reach another number
    elif(matrix[x][y] != prev):
        return
    #Traverse top down left right
    matrix[x][y] = num
    floodFill(matrix, x - 1, y, num, prev)
    floodFill(matrix, x + 1, y, num, prev)
    floodFill(matrix, x, y - 1, num, prev)
    floodFill(matrix, x, y + 1, num, prev)
    
floodFill(matrix, 0, 0, 3, matrix[0][0])
print(matrix);
    