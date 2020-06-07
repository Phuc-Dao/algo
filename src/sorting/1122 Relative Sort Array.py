class Solution:

    """
    Simpler solution. Count the number of elements and append to res
    """
    def relativeSortArray(self, arr1: List[int], arr2: List[int]) -> List[int]:
        counter = collections.Counter(arr1)
        res = []
        for elem in arr2:
            count = counter[elem]
            for i in range(count):
                res.append(elem)
            del counter[elem]
    
        for key in sorted(counter):
            for i in range(counter[key]):
                res.append(key)
        return res
    
    def relativeSortArray(self, arr1: List[int], arr2: List[int]) -> List[int]:
        """
        My terrible solution 
        idea was to partition each region and place the elements in the correct position 
        result of trying to recall a similar problem from memory and trying to shoehortn
        the solution to fit that one 
        
        heap = []
        count = {}
        regions = {}
        for elem in arr2:
            count[elem] = 0
    
        for elem in arr1:
            if elem in count:
                count[elem] += 1
            
        regions[arr2[0]] = 0
        res = [0 for i in range(len(arr1))]
        for i in range(1, len(arr2)):
            regions[arr2[i]] = regions[arr2[i - 1]] + count[arr2[i - 1]]
        for i in range(len(arr1)):
            if arr1[i] not in regions:
                heapq.heappush(heap, arr1[i])
            else:
                res[regions[arr1[i]]] = arr1[i]
                regions[arr1[i]] += 1
                
        while heap:
            idx = len(arr1) - len(heap)
            res[idx] = heapq.heappop(heap)
        
        return res
        """