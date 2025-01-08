//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Geeks {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int arr[] = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }
            System.out.println(new Solution().countTriangles(arr));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    
    static int countTriangles(int arr[]) {
        // code here
        Arrays.sort(arr);
        int ans=0;
        for(int i=arr.length-1;i>=0;i--){
            int st=0, end=i-1;
            while(st<end){
                if(arr[st]+arr[end]>arr[i]){
                    ans+=end-st;
                    end--;
                }
                else {
                    st++;
                }
            }
        }
        return ans;
    }
}
