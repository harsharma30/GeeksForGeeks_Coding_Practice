//{ Driver Code Starts
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


// } Driver Code Ends

class Solution {
    public List<Integer> rearrange(List<Integer> arr) {
       int n = arr.size();  
        int[] ans = new int[n];
        for(int i=0;i<n;i++)
        {
            ans[i]=-1;
        }
        for (int i = 0; i < n; i++) {
            if (arr.get(i) >= 0 && arr.get(i) < n) { 
                ans[arr.get(i)] = arr.get(i);
            }
        }
        List<Integer> result = new ArrayList<>();
        for(int i=0;i<ans.length;i++) {
            result.add(ans[i]);
        }
        return result;
    }
}

//{ Driver Code Starts.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        Solution solution = new Solution();

        while (t-- > 0) {
            String input = scanner.nextLine();
            String[] inputArr = input.split("\\s+");
            List<Integer> arr = new ArrayList<>();
            for (String s : inputArr) {
                arr.add(Integer.parseInt(s));
            }

            List<Integer> ans = solution.rearrange(arr);

            for (int num : ans) {
                System.out.print(num + " ");
            }
            System.out.println();
        }

        scanner.close();
    }
}
// } Driver Code Ends