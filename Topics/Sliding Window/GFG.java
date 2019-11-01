import java.util.*; 
  
class GFG 
{ 
  
    // function that returns the count of 
    // subarrays with m odd numbers  
    public static int countSubarrays(int a[], 
                                     int n, int m) 
    { 
        int count = 0; 
        int[] prefix = new int[n]; 
        int odd = 0; 
      
        // traverse in the array 
        for (int i = 0; i < n; i++) 
        { 
            prefix[odd]++; 
      
            // if array element is odd 
            if ((a[i] & 1) == 1) 
                odd++; 
      
            // when number of odd  
            // elements >= M 
            if (odd >= m) 
                count += prefix[odd - m]; 
        } 
      
        return count; 
    } 
      
    // Driver code 
    public static void main (String[] args) 
    { 
        int a[] = { 2, 2, 5, 6, 9, 2, 11 }; 
        int n = a.length; 
        int m = 2; 
          
        System.out.println(countSubarrays(a, n, m)); 
    } 
} 
  
// This code is contributed by akash1295. 