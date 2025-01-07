//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends
// User function Template for Java

class Solution {

    int countPairs(int arr[], int target) {
        // Complete the function
        int st=0;
        int ed=arr.length-1;
        int count=0;
        while(st<ed){
            int sum=arr[st]+arr[ed];
           if(sum<target){
                st++;
            }
            else if(sum>target){
                ed--;
            }
            else{
               int cnt1=0, cnt2=0;
               int elem1=arr[st], elem2=arr[ed];
               while(st<=ed && arr[st]==elem1){
                   cnt1++;
                   st++;
               }
                while(st<=ed && arr[ed]==elem2){
                   cnt2++;
                   ed--;
               }
               if(elem1==elem2){
                   count+=(cnt1*(cnt1-1))/2;
               }
                   count+=(cnt1*cnt2);
            }
        }
        return count;
    }
}


//{ Driver Code Starts.
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {
            String[] inputLine = br.readLine().trim().split(" ");
            int[] arr = new int[inputLine.length];
            for (int i = 0; i < inputLine.length; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            inputLine = br.readLine().trim().split(" ");
            int target = Integer.parseInt(inputLine[0]);

            Solution obj = new Solution();
            int res = obj.countPairs(arr, target);
            System.out.println(res);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends