"""
211. Add and saerch word - Data structure design
This is a regular trie but the search should be recursive. Whenever we see a dot we have to 
recurse on every letter in the current node
"""
class TrieNode:
    def __init__(self):
        self.children = defaultdict(TrieNode)
        self.is_leaf = False

class WordDictionary:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.root = TrieNode()

    def addWord(self, word: str) -> None:
        """
        Adds a word into the data structure.
        """
        curr = self.root
        for char in word:
            curr = curr.children[char]
        curr.is_leaf = True
        

    def search(self, word: str) -> bool:
        """
        Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
        """
        return self.searchHelper(word, self.root, 0)
    
    def searchHelper(self, word, curr_node, curr_idx):
        if (curr_idx >= len(word)):
            return curr_node.is_leaf
        elif word[curr_idx] == '.':
            has_word = False
            for key in curr_node.children:
                has_word = has_word or self.searchHelper(word, curr_node.children[key], curr_idx + 1)
            return has_word
        else:
            return self.searchHelper(word, curr_node.children[word[curr_idx]], curr_idx + 1)


# Your WordDictionary object will be instantiated and called as such:
# obj = WordDictionary()
# obj.addWord(word)
# param_2 = obj.search(word)