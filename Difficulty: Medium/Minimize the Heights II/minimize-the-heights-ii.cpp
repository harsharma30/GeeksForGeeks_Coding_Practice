//{ Driver Code Starts
// Initial template for C++

#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
// User function template for C++

class Solution {
public:
    int getMinDiff(vector<int>& arr, int k) {
        int n = arr.size();
        if (n == 1) return 0;  // If there's only one tower, no difference to minimize.
        
        // Sort the array to handle the smallest and largest elements easily.
        sort(arr.begin(), arr.end());

        // Initial difference between the largest and smallest heights.

                int ans = arr[n-1] - arr[0];
        // Iterate through the array and adjust the minimum and maximum possible heights.
        for (int i = 1; i < n; i++) {
            // The minimum height should either be arr[0] + k or arr[i] - k (whichever is smaller)
            int minval = min(arr[0] + k, arr[i] - k);
            
            // The maximum height should either be arr[n-1] - k or arr[i-1] + k (whichever is larger)
            int maxval = max(arr[n-1] - k, arr[i-1] + k);

            // Only update the answer if the new minimum value is non-negative
            if (minval >= 0) {
                ans = min(ans, maxval - minval);
            }
        }

        return ans;
    }
};

//{ Driver Code Starts.
int main() {
    int t;
    cin >> t;
    cin.ignore();
    while (t--) {
        int n, k;
        cin >> k;
        cin.ignore();
        vector<int> a, b, c, d;
        string input;
        getline(cin, input);
        stringstream ss(input);
        int num;
        while (ss >> num)
            a.push_back(num);

        Solution ob;
        auto ans = ob.getMinDiff(a, k);
        cout << ans << "\n";
    }
    return 0;
}
// } Driver Code Ends