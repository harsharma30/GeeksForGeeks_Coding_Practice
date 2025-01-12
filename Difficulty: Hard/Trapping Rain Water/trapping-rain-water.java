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
            System.out.println(new Solution().maxWater(arr));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public int maxWater(int arr[]) {
        // code here
        int[] leftMax=new int[arr.length];
        int[] rightMax=new int[arr.length];
        leftMax[0]=arr[0];
        for(int i=1;i<arr.length;i++)
        {
            leftMax[i]=Math.max(leftMax[i-1], arr[i]);
        }
        rightMax[arr.length-1]=arr[arr.length-1];
        for(int i=arr.length-2;i>=0;i--)
        {
            rightMax[i]=Math.max(rightMax[i+1], arr[i]);
        }
        int ans=0;
        for(int i=0;i<arr.length;i++)
        {
            ans+=Math.min(leftMax[i], rightMax[i])-arr[i];
        }
        return ans;
    }
}