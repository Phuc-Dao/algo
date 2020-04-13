"""
721 Accounts Merge.
Connect related emails to each other and find the connected components
Use a bi-directional graph because we need to be able to reach every connected
component from any node. For every account connect every email to the first email.
Note: When I first did this problem I got stuck on trying to connect the 
emails together because I wastrying to make it complicated using a parent pointer 
etc. No need for this, just connect every email to the first email in the list
"""
class Solution:   
    def dfs(self, current, visited, graph, result):
        if current in visited:
            return
        result.append(current)
        visited.add(current)
        for elem in graph[current]:
            self.dfs(elem, visited, graph, result)
    
    def accountsMerge(self, accounts: List[List[str]]) -> List[List[str]]:
        graph = collections.defaultdict(set)
        # Connect emails together
        for acc in accounts:
            email = acc[1]
            for i in range(2, len(acc)):
                # If the node doesnt exist, defaultdict will create one,
                # Otherwise if it does exist already then the nodes will be connected
                graph[email].add(acc[i])
                graph[acc[i]].add(email)
                           
        result = []
        visited = set()  
        # Perform dfs
        for acc in accounts:
            combined = []
            self.dfs(acc[1], visited, graph, combined)
            # If No elements then all the emails were merged
            # under another name
            if len(combined) != 0:
                combined.sort()
                res = [acc[0]]
                res.extend(combined)
                result.append(res)
        return result