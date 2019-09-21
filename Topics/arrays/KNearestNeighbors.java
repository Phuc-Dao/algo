// Using sorting
class Solution {
    public int[][] kClosest(int[][] points, int K) {
        Arrays.sort(points, (a,b) -> Integer.compare(a[0]*a[0] + a[1]*a[1], b[0]*b[0] + b[1]*b[1]) );
        int[][] res = new int[K][2];
        for(int i = 0; i < K; i++){
            res[i] = points[i];
        }
        return res;
    }
}

// Using a priority Queue
class Solution {
    public int[][] kClosest(int[][] points, int K) {
        // Prioroty Queue 
        PriorityQueue<int[]> q = new PriorityQueue<>(K, (a,b) -> Integer.compare(a[0]*a[0] + a[1]*a[1], b[0]*b[0] + b[1]*b[1]));
        int[][] res = new int[K][2];
        for(int i = 0; i < points.length; i++){
            q.offer(points[i]);
        }
        
        for(int i = 0; i < K; i++){
            res[i] = q.poll();
        }
        return res;
    }
}