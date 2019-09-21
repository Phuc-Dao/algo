class Solution {
    // Time: NlogN
    // Approach: We will use a priority queue to maintain all the rooms. When a room is used up we will pop it 
    // from the pq, if there are no rooms available we will allocate a room
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[1], b[1]));
        
        // Iterate over the list of arrays
        for(int[] times : intervals){
            if(pq.peek() == null){
                pq.offer(times);
            }
            else if(times[0] >= pq.peek()[1]){
                pq.poll();
                pq.offer(times);
            }
            else{
                pq.offer(times);
            }
        }
        return pq.size();
    }
}