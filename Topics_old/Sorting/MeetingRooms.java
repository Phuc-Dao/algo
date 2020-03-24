class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        // Add checking for null case
        if(intervals.length == 0 || intervals == null){
            return true;
        }
        
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0],b[0]));
        int firstEnd = intervals[0][1];
        for(int i = 1; i < intervals.length; i++){
            if(intervals[i][0] < firstEnd){
                return false;
            }
            firstEnd = intervals[i][1];
        }
        return true;
    }
}