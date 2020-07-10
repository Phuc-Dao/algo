"""
Use a Trie + backtracking
"""
class Trie:
    def __init__(self):
        self.head = TrieNode()
        
    def insert(self, char):
        curr = self.head
        for c in char:
            curr = curr.children[c]
        curr.isLeaf = True
        curr.word = char
            
class TrieNode:
    def __init__(self):
        self.children = defaultdict(TrieNode)
        self.isLeaf = False
    
class Solution:
    # main logic
    def findWords(self, board: List[List[str]], words: List[str]) -> List[str]:
        trie = Trie()
        visited = set()
        found = set()
        for word in words:
            trie.insert(word)
            
        for r in range(len(board)):
            for c in range(len(board[0])):
                if board[r][c] in trie.head.children:
                    self.get_word(trie.head.children[board[r][c]], board, r, c, set(), found)
        return list(found)
    
    # Get the surrounding neighbors
    def get_neighbors(self, board, r, c):
        neighbors = []
        coords = [(-1,0), (1,0), (0,-1), (0,1)]
        for ch in coords:
            new_row = r + ch[0]
            new_col = c + ch[1]
            if new_row >= 0 and new_row < len(board) and new_col >= 0 and new_col < len(board[0]):
                neighbors.append((new_row, new_col))
        return neighbors
    
    # backtrack
    def get_word(self, trie_node, board, r, c, visited, found):
        if (r,c) in visited:
            return 
        # backtrackoing 
        visited.add((r,c))
        if trie_node.isLeaf:
            found.add(trie_node.word)
        neighbors = self.get_neighbors(board, r, c)
        for n in neighbors:
            row = n[0]
            col = n[1]
            next_letter = board[row][col]
            if next_letter in trie_node.children:
                self.get_word(trie_node.children[next_letter], board, row, col, visited, found)
        visited.remove((r,c))
        