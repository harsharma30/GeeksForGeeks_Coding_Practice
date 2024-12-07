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
            System.out.println(new Solution().inversionCount(arr));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    static int inversionCount(int arr[]) {
        return mergeSort(arr,0,arr.length-1);
    }
    
    private static int mergeSort(int[] arr,int left,int right){
        int count=0;
        if(left<right){
            int mid=left+(right-left)/2;
            count+=mergeSort(arr,left,mid);
            count+=mergeSort(arr,mid+1,right);
            count+=merge(arr,mid,left,right);
        }
        return count;
    }
    private static int merge(int[] arr,int mid,int left,int right){
        int l=left,r=mid+1;
        int count=0;
        ArrayList<Integer> temp=new ArrayList<>();
        while(l<=mid && r<=right){
            if(arr[l]<=arr[r]){
                temp.add(arr[l]);
                l++;
            }else{
                count+=(mid-l+1);
                temp.add(arr[r]);
                r++;
            }
        }
        while(l<=mid){
            temp.add(arr[l]);
            l++;
        }
        while(r<=right){
            temp.add(arr[r]);
            r++;
        }
        for(int i=left;i<=right;i++){
            arr[i]=temp.get(i-left);
        }
        return count;
    }
}   