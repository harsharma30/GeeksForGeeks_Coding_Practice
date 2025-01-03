//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        while (tc-- > 0) {
            String s[] = br.readLine().split(" ");
            int arr[] = new int[s.length];

            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(s[i]);
            }
            int k = Integer.parseInt(br.readLine());

            Solution obj = new Solution();
            System.out.println(obj.subarrayXor(arr, k));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public long subarrayXor(int[] arr, int k) {
    // Map to store frequency of XOR prefixes
    Map<Integer, Integer> prefixXorCount = new HashMap<>();
    prefixXorCount.put(0, 1); // Base case for XOR
    long count = 0;
    int xor = 0;

    for (int num : arr) {
        xor ^= num; // Update current XOR
        int target = xor ^ k; // XOR condition for required subarray
        
        // Add count of subarrays with XOR equal to target
        count += prefixXorCount.getOrDefault(target, 0);
        
        // Update prefix XOR frequency in the map
        prefixXorCount.put(xor, prefixXorCount.getOrDefault(xor, 0) + 1);
    }
    return count;
}
}