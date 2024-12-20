//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int r = sc.nextInt();
            int c = sc.nextInt();

            int matrix[][] = new int[r][c];

            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) matrix[i][j] = sc.nextInt();
            }
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.spirallyTraverse(matrix);
            for (Integer val : ans) System.out.print(val + " ");
            System.out.println();

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public ArrayList<Integer> spirallyTraverse(int mat[][]) {
        int n = mat.length, m = mat[0].length, total = n * m;
        int sr = 0, er = n - 1;
        int sc = 0, ec = m - 1;
        ArrayList<Integer> list = new ArrayList<>();
        
        while (list.size() < total) {
            for (int i = sc; i <= ec && list.size() < total; i++) list.add(mat[sr][i]);
            sr++;
            for (int i = sr; i <= er && list.size() < total; i++) list.add(mat[i][ec]);
            ec--;
            for (int i = ec; i >= sc && list.size() < total; i--) list.add(mat[er][i]);
            er--;
            for (int i = er; i >= sr && list.size() < total; i--) list.add(mat[i][sc]);
            sc++;
        }
        
        return list;
    }
}


