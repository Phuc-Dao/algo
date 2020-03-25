"""
208 implement trie
time complexity: O(M) where M is the length of the word to be searched/inserted
space complexity: O(N*M) where N is the number of words and M is the length of the longest word
"""
class TrieNode:
    def __init__(self):
        # Defaultdict will create a new object with is_leaf = false and self.children = {} 
        self.children = defaultdict(TrieNode)
        self.is_leaf = False

class Trie:
    def __init__(self):
        self.root = TrieNode()
    
    # Remember to set the is_leaf flag to be true
    def insert(self, word):
        curr = self.root
        for c in word:
            curr = curr.children[c]
        curr.is_leaf = True

    def search(self, word):
        curr = self.root
        for w in word:
            if w not in curr.children:
                return False
            curr = curr.children[w]
        return curr.is_leaf

    def startsWith(self, prefix):
        curr = self.root
        for char in prefix:
            if char not in curr.children:
                return False
            curr = curr.children[char]
        return True

