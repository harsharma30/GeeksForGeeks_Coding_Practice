//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends

class Solution {
  public:
    int kthElement(vector<int>& a, vector<int>& b, int k) {
        // code here
        int aSize=a.size();
        int bSize=b.size();
        
        int ans=0,i=0,j=0;
        while(k>0 && i<aSize && j<bSize){
            if(a[i]<b[j]){
                ans=a[i];
                i++;
            }
            else{
                ans=b[j];
                j++;
            }
            k--;
        }
        
        while(k>0 && i<aSize){
            ans=a[i];
            i++;
            k--;
        }
        
        while(k>0 && j<bSize){
            ans=b[j];
            j++;
            k--;
        }
        
        return ans;
        
    }
};


//{ Driver Code Starts.

// Driver code
int main() {
    int t;
    cin >> t;
    cin.ignore();
    while (t--) {
        int n, m, k;
        cin >> k;
        cin.ignore();
        string input;
        int num;
        vector<int> a, b;

        getline(cin, input);
        stringstream s2(input);
        while (s2 >> num) {
            a.push_back(num);
        }

        getline(cin, input);
        stringstream s3(input);
        while (s3 >> num) {
            b.push_back(num);
        }

        Solution ob;
        cout << ob.kthElement(a, b, k) << endl << "~\n";
    }
    return 0;
}
// } Driver Code Ends