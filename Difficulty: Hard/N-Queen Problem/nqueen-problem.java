//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(in.readLine());

            Solution ob = new Solution();
            ArrayList<ArrayList<Integer>> ans = ob.nQueen(n);
            if (ans.size() == 0)
                System.out.println("-1");
            else {
                ans.sort((list1, list2) -> {
                    int size = Math.min(list1.size(), list2.size());
                    for (int i = 0; i < size; i++) {
                        if (!list1.get(i).equals(list2.get(i))) {
                            return list1.get(i) - list2.get(i);
                        }
                    }
                    return list1.size() - list2.size();
                });

                for (int i = 0; i < ans.size(); i++) {
                    System.out.print("[");
                    for (int j = 0; j < ans.get(i).size(); j++)
                        System.out.print(ans.get(i).get(j) + " ");
                    System.out.print("] ");
                }
                System.out.println();
            }

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public ArrayList<ArrayList<Integer>> nQueen(int n) {
        ArrayList<ArrayList<Integer>>ans = new ArrayList<>();
        ArrayList<Integer>temp = new ArrayList<>();
        int pRow[] = new int[n];
        int diaL[] = new int[2*n-1];
        int diaU[] = new int[2*n-1];
        int col = 0;
        solve(ans, temp, pRow, diaL, diaU, col, n);
        return ans;
    }
    public void solve(ArrayList<ArrayList<Integer>>ans, ArrayList<Integer>temp,
    int pRow[], int diaL[], int diaU[], int col, int n){
        if(col == n){
            ans.add(new ArrayList<>(temp));
            return;
        }
        for(int row=0;row<n;row++){
            if(pRow[row] == 0 && diaU[n-1+col-row] == 0 && diaL[row+col] == 0){
                pRow[row] = 1;
                diaU[n-1+col-row] = 1;
                diaL[row+col] = 1;
                temp.add(row+1);
                solve(ans, temp, pRow, diaL, diaU, col+1, n);
                temp.remove(temp.size()-1);
                pRow[row] = 0;
                diaU[n-1+col-row] = 0;
                diaL[row+col] = 0;
            }
        }
    }
}