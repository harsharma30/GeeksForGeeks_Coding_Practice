//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // Consume the newline character

        while (t-- > 0) {
            String s = sc.nextLine();
            String[] parts = s.split(" ");
            List<Integer> nums = new ArrayList<>();
            for (String part : parts) {
                nums.add(Integer.parseInt(part));
            }
            Solution ob = new Solution();
            List<Integer> ans = ob.findMajority(nums);
            for (int num : ans) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
        sc.close();
    }
}
// } Driver Code Ends


class Solution {
    // Function to find the majority elements in the array
    public List<Integer> findMajority(List<Integer> nums) {
        List<Integer> result = new ArrayList<>();
        int n=nums.size();
        int first=-1,second=-1,count1=0,count2=0;
        for(int num : nums){
            if(num==first){
                count1++;
            }
            else if(num==second){
                count2++;
            }
            else if(count1==0){
                count1++;
                first=num;
            }
            else if(count2==0){
                count2++;
                second=num;
            }
            else{
                count1--;
                count2--;
            }
        }
        
        count1=0;
        count2=0;
        
        for(int num : nums){
            if(num==first){
                count1++;
            }
            if(num==second){
                count2++;
            }
        }
        if (count1 > n / 3) result.add(first);
        if (count2 > n / 3) result.add(second);
        
        Collections.sort(result);
        
        if (result.isEmpty()) {
            result.add(-1);
        }
        
        return result;
    }
}