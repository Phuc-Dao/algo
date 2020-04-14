"""
636 exclusive time functions:
"""
class Solution:
    def exclusiveTime(self, n: int, logs: List[str]) -> List[int]:
        stack = []
        res = [0 for i in range(n)]
        for log in logs:
            substring = log.split(":")  
            curr_id, event_type, curr_ts = int(substring[0]), substring[1], int(substring[2])
            if(event_type == "start"):
                stack.append([curr_id, curr_ts])
            elif event_type == "end":
                top_id, top_ts = stack.pop()
                duration = curr_ts - top_ts + 1
                res[top_id] += duration
                if stack:
                    next_id, next_ts = stack[-1]
                    res[next_id] -= duration
        return res