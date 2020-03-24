# Greedy

## Merge Intervals
Merge interval is a greedy, because these problems typically process the intervals in-order of start time. 
- Merge interval
- Insert interval
- Employee Free time
- Range Module **

```Python
 def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        if len(intervals) == 0:
            return []
        # Sort it by start and then end time
        intervals.sort(key = lambda x : [x[0],x[1]])
        res = []
        # Current interval being processesed
        prev = [intervals[0][0], intervals[0][1]]
        for i in intervals[1:]:
            if (i[0] <= prev[1] and i[1] > prev[1]):
                prev[1] = i[1]
            elif i[0] > prev[1]:
                res.append(prev)
                prev = [i[0],i[1]]
        res.append(prev)
        return res
```