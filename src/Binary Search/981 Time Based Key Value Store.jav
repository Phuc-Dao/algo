/*
 * The crux of this problem is when you have to search for a timestamp. 
 * Since the timestams are in sorted order we can use binary search and 
 * return the last element that is less than or equal to the timestamp 
 * we are searching for.
 *
 * Example: [1,5,9,12]
 * If we are searching for the number 6, it should return 5 since it is the last 
 * number that is less than or equal to 6
 * 
 * We use the fact that each iteration fo binary search will bring us closer to the search value. 
 * So Every mid value that we look at, if its less than or equal to target time stamp we record it
 *  and with each step we get closer to our target timestamp.
 *
 */
class TimeMap {
    class Pair{
        int timestamp;
        String value;
        Pair(String k, int v){
            this.timestamp = v;
            this.value = k;
        }
    }
    
    HashMap<String, List<Pair>> map;
    
    /** Initialize your data structure here. */
    public TimeMap() {
        this.map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key, new ArrayList());
        map.get(key).add(new Pair(value, timestamp));
    }
    
    // Use binary search to look for timestamp. Store mid in prev in case we overshoot it 
    public String get(String key, int timestamp) {
        // Perform binay search
        List<Pair> nodes = map.get(key);
        if (nodes == null) return "";
        int prev = -1;
        int left = 0, right = nodes.size() - 1;
        while (left <= right) {
            int mid = (left +right) / 2;
            Pair node = nodes.get(mid);
            if (node.timestamp == timestamp) {
                return node.value;
            } else if (node.timestamp < timestamp) {
                prev = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if(prev == -1) return "";
        return nodes.get(prev).value;     
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */