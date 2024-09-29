//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends
// User function Template for Java

class Solution {
    int totalCount(int k, int[] arr) {
        int n = arr.length;
        //ArrayList<Integer> ans = new ArrayList<>();
        int cnt=0;

        for (int i = 0; i < n; i++) {
            if (arr[i] <= k) {
                cnt++;
                //ans.add(arr[i]);
            } else {
                int result = arr[i] / k;  // how many full k's
                int rem = arr[i] % k;     // remainder
                cnt+=result;

                
                if (rem > 0) {
                    //ans.add(rem);
                    cnt++;
                }
            }
        }

        return cnt;
        //ans.size()+cnt;
    }
}


//{ Driver Code Starts.

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int k = Integer.parseInt(br.readLine());
            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;
            Solution obj = new Solution();
            int res = obj.totalCount(k, arr);

            System.out.println(res);
        }
    }
}
// } Driver Code Ends