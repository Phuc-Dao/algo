"""
642. Design Search Autocomplete
Use a trie to store all the words. Use backtracking to find all words that start with a certain prefix
"""
from collections import defaultdict
class TrieNode:
    def __init__(self):
        self.children = defaultdict(TrieNode)
        self.is_leaf = False

class Trie:
    def __init__(self):
        self.root = TrieNode()

    def insert(self, word):
        curr = self.root
        for char in word:
            curr = curr.children[char]
        curr.is_leaf = True

    # Uses backtracking to find all the words that start with a prefix
    def getPrefix(self, prefix):
        res = set()
        curr = self.root
        for char in prefix:
            if char in curr.children:
                curr = curr.children[char]
            else:
                return res
        if curr.is_leaf:
            res.add(prefix)

        for key in curr.children:
            self.backtrack([], res, curr, prefix)
        return list(res)

    def backtrack(self, curr, res, curr_node, prefix):
        if curr_node.is_leaf:
            res.add(prefix + "".join(curr))
        for char in curr_node.children:
            curr.append(char)
            self.backtrack(curr, res, curr_node.children[char], prefix)
            curr.pop()
            
class AutocompleteSystem:
    def __init__(self, sentences, times):
        self.freq = defaultdict(int)
        self.trie = Trie()
        self.curr_word = ""     
        for i in range(len(sentences)):
            self.freq[sentences[i]] = times[i]
            self.trie.insert(sentences[i])

    def input(self, c):
        if(c == "#"):
            self.trie.insert(self.curr_word)
            self.curr_word = ""
            return []
        self.curr_word = self.curr_word + c
        words = self.trie.getPrefix(self.curr_word)
	words.sort(key=lambda x:[-self.freq[x], x])
	if(len(words) <= 3):
	    return words
	else:
	    return words[:3]

