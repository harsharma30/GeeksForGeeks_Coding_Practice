//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
class Solution {
  public:
    // Function to find a continuous sub-array which adds up to a given number.
     vector<int> subarraySum(vector<int> arr, int n, long long s) {
    // Handle the special case where the target sum `s` is 0
    if (s == 0) {
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                return {i + 1, i + 1}; // Return 1-based index of the zero element
            }
        }
        return {-1}; // If no zero is found, return -1
    }

    // Regular case where sum `s` is not 0
    int i = 0, j = 0;
    long long sum = 0;
    vector<int> ans;

    while (j <= n) {
        // If sum exceeds the target, shrink the window from the left.
        while (sum > s && i < j) {
            sum -= arr[i];
            i++;
        }

        // If sum equals the target, return the 1-based index.
        if (sum == s) {
            ans.push_back(i + 1);
            ans.push_back(j); // `j` is one past the correct element
            return ans;
        }

        // Expand the window by adding the next element to the sum.
        if (j < n) {
            sum += arr[j];
        }
        j++;
    }

    // If no subarray found, return -1.
    return {-1};
}


};


//{ Driver Code Starts.

int main() {
    int t;
    cin >> t;
    while (t--) {
        int n;
        long long s;
        cin >> n >> s;
        vector<int> arr(n);
        // int arr[n];
        const int mx = 1e9;
        for (int i = 0; i < n; i++) {
            cin >> arr[i];
        }
        Solution ob;
        vector<int> res;
        res = ob.subarraySum(arr, n, s);

        for (int i = 0; i < res.size(); i++)
            cout << res[i] << " ";
        cout << endl;
    }
    return 0;
}
// } Driver Code Ends