//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            String[] inputLine = br.readLine().split(" ");
            int n = inputLine.length;
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            System.out.println(new Solution().maxProduct(arr));
        }
    }
}

// } Driver Code Ends


class Solution {
    int maxProduct(int[] arr) {
        int lr=1;
        int rl=1;
        int n=arr.length;
        int max=Integer.MIN_VALUE;
        
        for(int i=0;i<n;i++){
            lr*=arr[i];
            max=Math.max(max, lr);
            if(arr[i]==0)lr=1;
        }
        
        for(int i=n-1;i>=0;i--){
             rl*=arr[i];
             max=Math.max(max, rl);
             if(arr[i]==0)rl=1;
        }
        
        return max;
    }
}