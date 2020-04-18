class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        count = 0
        tasks_processed = 0
        priority_queue = []
        task_queue = collections.deque()
        
        # Put elements into priotity queue
        frequency = collections.Counter(tasks)
        for key in frequency:
            heapq.heappush(priority_queue, (-frequency[key], key))            
        # Process the tasks
        while(tasks_processed != len(tasks)):
            top = heapq.heappop(priority_queue) if len(priority_queue) > 0 else "idle"
            count += 1
            if(top != "idle"):
                tasks_processed += 1
            task_queue.append(top)
            if(len(task_queue) == n + 1):
                elem = task_queue.popleft()
                if(elem != "idle" and elem[0] < -1):
                       heapq.heappush(priority_queue, (elem[0] + 1, elem[1]))
        return count