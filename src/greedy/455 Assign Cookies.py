class Solution:
    """
    487 Assign cookies. Greedy approach assign the lowest cookie to the smallest children
    """
    def findContentChildren(self, g: List[int], s: List[int]) -> int:
        count = 0
        sorted_children = sorted(g)
        sorted_cookies = sorted(s)
        i = 0
        j = 0
        while i < len(sorted_children) and j < len(sorted_cookies):
            if sorted_cookies[j] >= sorted_children[i]:
                count += 1
                i += 1
                j += 1
            else:
                j += 1
        return count
        