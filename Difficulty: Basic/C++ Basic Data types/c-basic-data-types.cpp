//{ Driver Code Starts
// Initial template for C++

#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends
// User functiom template for C++

class Solution {
  public:
     int BasicDataType(string s) {
        int cDot=0;
        int cCh=0;
        int cNum=0;
        int cNumAfterDot=0;
        
        for(auto x:s){
            if(x=='.')
                cDot++;
            else if(x>=48 && x<=57){
                if(cDot==1)
                    cNumAfterDot++;
                cNum++;
                
            }
                // cNum++;
            else
                cCh++;
        }
        if(cCh>0 || cDot>1)
            return(1);
        if(cDot==1 && cNumAfterDot<6)
            return(4);
        if(cDot==1)
            return(8);
        return(4);
        
    }
};

//{ Driver Code Starts.
int main() {
    int t;
    cin >> t;
    while (t--) {
        string S;
        cin >> S;

        Solution ob;
        cout << ob.BasicDataType(S) << endl;
    }
}
// } Driver Code Ends