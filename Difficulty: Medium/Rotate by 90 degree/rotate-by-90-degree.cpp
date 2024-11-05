//{ Driver Code Starts
// Initial template for C++

#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
// User function template for C++

/* matrix : given input matrix, you are require
 to change it in place without using extra space */
void rotate(vector<vector<int> >& a) {
    // Your code goes here
    int n=a.size();
    for(int i=0; i<n; i++)
    {
        for(int j=i+1; j<n; j++)
        {
            int t=a[i][j];
            a[i][j]=a[j][i];
            a[j][i]=t;
        }
    }
    
    for(int i=0; i<n; i++)
    {
        int j=0;
        int k=n-1;
        while(j<k)
        {
           int t=a[i][j];
           a[i][j]=a[i][k];
           a[i][k]=t;
           j++;
           k--;
        }
    }
}

//{ Driver Code Starts.

int main() {
    int t;
    cin >> t;
    while (t--) {
        int n;
        cin >> n;
        vector<vector<int> > matrix(n);
        for (int i = 0; i < n; i++) {
            matrix[i].resize(n);
            for (int j = 0; j < n; j++)
                cin >> matrix[i][j];
        }
        rotate(matrix);
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; j++)
                cout << matrix[i][j] << " ";
            cout << "\n";
        }

        cout << "~"
             << "\n";
    }
    return 0;
}

// } Driver Code Ends