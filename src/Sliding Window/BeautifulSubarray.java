class BeautifulSubarray{

    public int solution(int[] nums, int m){
        int count = 0;
        int left = 0;
        int numSubarray = 0;
        for(int i = 0; i < nums.length; i++){
            int curr = nums[i];
            if(curr % 2 != 0 ) count++;
            while(count == m){
                numSubarray++;
                if(nums[left] % 2 != 0) count--; 
                left++;
            }
        }
        return numSubarray;
    }

    public static void main(String[] args){
        int[] nums = {2, 2, 5, 6, 9, 2, 11};
        BeautifulSubarray s1 = new BeautifulSubarray();
        System.out.println(s1.solution(nums, 2));

    }
}