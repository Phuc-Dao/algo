"""
1086 High Five. This one is pretty straight forward. Maintain a heap of size 5
and take the average of every heap at the end
"""
class Solution:
    def highFive(self, items: List[List[int]]) -> List[List[int]]:
        scores = collections.defaultdict(list)
        res = []
        for elems in items:
            sid = elems[0]
            test_score = elems[1]
            heapq.heappush(scores[sid], test_score)
            if len(scores[sid]) > 5:
                heapq.heappop(scores[sid])
        for sid in scores:
            res.append([sid, sum(scores[sid]) // len(scores[sid])])
        return res