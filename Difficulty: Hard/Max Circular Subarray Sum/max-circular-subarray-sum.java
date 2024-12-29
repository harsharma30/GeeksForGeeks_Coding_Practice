//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Sorting {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int arr[] = new int[str.length];
            for (int i = 0; i < str.length; i++) arr[i] = Integer.parseInt(str[i]);
            System.out.println(new Solution().circularSubarraySum(arr));
            // System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public int circularSubarraySum(int arr[]) {
        int n = arr.length;
        
        int maxSoFar = 0;
        int minSoFar = 0;
        
        int maxSum = Integer.MIN_VALUE;
        int minSum = Integer.MAX_VALUE;
        
        int totalSum=0;
        for(int num: arr){
            totalSum += num;
            
            maxSoFar += num;
            minSoFar += num;
            
            maxSum = Math.max(maxSum , maxSoFar);
            minSum = Math.min(minSum , minSoFar);
            
            if(maxSoFar < 0){
                maxSoFar = 0;
            }
            
            if(minSoFar > 0){
                minSoFar = 0;
            }
        }
        
        return Math.max(maxSum , totalSum - minSum);
    }
}
