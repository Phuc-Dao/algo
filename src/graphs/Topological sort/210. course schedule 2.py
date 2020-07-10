class Solution:
    def findOrder(self, numCourses: int, prerequisites: List[List[int]]) -> List[int]:
        graph = self.initGraph(prerequisites)
        ordering = []
        visited = set()
        rec = set()
        for i in range(numCourses):
            hasCycle = self.topoSort(i, graph, visited, ordering, rec)
            if hasCycle:
                return []
        ordering.reverse()
        return ordering
             
    def initGraph(self, prerequisites):
        graph = defaultdict(list)
        for classes in prerequisites:
            graph[classes[1]].append(classes[0])
        return graph 
    
    # rec is the set of nodes we are currently visiting, if we visit a node before we have visited all
    # of its children we have a cycle
    def topoSort(self, currClass, graph, visited, ordering, rec):
        if currClass in rec:
            return True
        if currClass in visited:
            return False
        visited.add(currClass)
        rec.add(currClass)
        for elem in graph[currClass]:
            cycle = self.topoSort(elem, graph, visited, ordering, rec)
            if cycle:
                return True
        # ordering is a stack used to keep the topological ordering
        ordering.append(currClass)
        # done visiting a node
        rec.remove(currClass)
        return False
        