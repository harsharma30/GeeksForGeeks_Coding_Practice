//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class Geeks {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int arr[] = new int[str.length];
            for (int i = 0; i < str.length; i++) arr[i] = Integer.parseInt(str[i]);
            System.out.println(new Solution().majorityElement(arr));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    static int majorityElement(int arr[]) {
        // your code here
        
        int halfSize = arr.length/2;
        
        if(arr.length == 1) return arr[0];
        
        Map<Integer,Integer> eleMap = new HashMap<>();
        
        for(int element : arr){
            eleMap.put(element, eleMap.getOrDefault(element, 0) + 1);
            if(eleMap.get(element) > halfSize) return element;
        }
        return -1;
    }
}