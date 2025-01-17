//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t > 0) {
            String inputLine[] = br.readLine().trim().split(" ");
            int n = inputLine.length;
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            Solution ob = new Solution();
            int[] ans = new int[n];
            ans = ob.productExceptSelf(arr);

            for (int i = 0; i < n; i++) {
                System.out.print(ans[i] + " ");
            }
            System.out.println();
            System.out.println("~");
            t--;
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    public static int[] productExceptSelf(int arr[]) 
    {
        int p=1;
        int c=0;
        for(int i:arr){
            if(i!=0) p*=i;
            else c++;
        }
        int res[]=new int[arr.length];
        if(c>=2) return res;
        for(int i=0;i<arr.length;i++){
            if(arr[i]!=0 && c==0) res[i]=p/arr[i];
            else if(arr[i]!=0 && c>0) res[i]=0;
            else res[i]=p;
        }
        return res;
    }
}
