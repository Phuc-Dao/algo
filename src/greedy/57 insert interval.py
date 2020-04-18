lass Solution:
    # Assuming the interval is not in sorted order
    # If the interval is in sorted order we can skip the sort step and do it O(n) time
    def insert(self, intervals: List[List[int]], newInterval: List[int]) -> List[List[int]]:
        intervals.append(newInterval)
        intervals.sort(key = lambda x : [x[0],x[1]])
        pre = [intervals[0][0], intervals[0][1]]
        res = []
        for elems in intervals[1:]:
            if elems[0] <= pre[1] and elems[1] > pre[1]:
                pre[1] = elems[1]
            elif elems[0] > pre[1]:
                res.append([pre[0],pre[1]])
                pre[0], pre[1] = elems[0], elems[1]
        res.append([pre[0], pre[1]])
        return res
    
        