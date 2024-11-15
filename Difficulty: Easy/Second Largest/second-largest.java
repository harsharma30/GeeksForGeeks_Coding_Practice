//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            String[] arr1Str = sc.nextLine().split(" ");
            int[] arr = Arrays.stream(arr1Str).mapToInt(Integer::parseInt).toArray();
            Solution ob = new Solution();
            int ans = ob.getSecondLargest(arr);
            System.out.println(ans);

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int getSecondLargest(int[] arr) {
    // Get the length of the array
    int n = arr.length;

    // Initialize variables to track the largest and second largest values
    int largest = 0;
    int secondLargest = 0;

    // First loop: Find the largest element in the array
    for (int it : arr) {
        if (it > largest) {
            largest = it; // Update largest if the current element is greater
        }
    }

    // Second loop: Find the second largest element in the array
    for (int it : arr) {
        if (it == largest) continue; // Skip the largest element
        if (it > secondLargest) {
            secondLargest = it; // Update secondLargest if the current element is greater
        }
    }

    // If secondLargest remains 0, it means no second largest element exists
    // (e.g., when all elements are the same or there's only one element)
    return secondLargest == 0 ? -1 : secondLargest;
}
}