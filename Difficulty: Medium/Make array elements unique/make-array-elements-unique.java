//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String arr[] = br.readLine().split(" ");
            int a[] = new int[arr.length];

            for (int i = 0; i < arr.length; i++) {
                a[i] = Integer.parseInt(arr[i]);
            }
            Solution obj = new Solution();
            int f = 0;
            int A = obj.minIncrements(a);
            System.out.println(A);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int minIncrements(int[] arr) {
        int n=arr.length;
        int cnt=0;
        Arrays.sort(arr);
        for(int i=1;i<n;i++){
            if(arr[i-1]>=arr[i]){
                int temp=(arr[i-1]-arr[i])+1;
                cnt+=temp;
                arr[i]=arr[i]+temp;
            }
        }
        return cnt;
        
    }
}