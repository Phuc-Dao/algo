class MatrixChain{
    // Tkaes in as input a list of arrays of size 2, 
    public static int getOptimalChain(int[][] m, int i, int j) {
        if(i >= j) return 0;
        int min = Integer.MAX_VALUE;
        for(int k = i; k < j; k++){
            int left = getOptimalChain(m, i, k);
            int right = getOptimalChain(m, k + 1, j);
            min = Math.min(min, left + right + m[i][0] * m[k][1] * m[j][1]);
            System.out.println(k);
        }
        return min;
    }
    public static void main(String[] args){
        int[][] m = new int[][]{{10,20},{20,30},{30,40},{40,30}};
        System.out.println(getOptimalChain(m, 0, m.length - 1));
    }
}

// Its always going to be the leftmost element that gets multiplied
//1x5, 5x6 | 6x5
