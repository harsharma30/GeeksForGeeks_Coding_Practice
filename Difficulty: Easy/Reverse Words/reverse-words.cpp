//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends

class Solution {
  public:
    // Function to reverse words in a given string.
    string reverseWords(string str) 
    {
        stack<string>s;
        string newstr="";
        int n=str.size();
        for(int i=0;i<n;i++)
        {
            string word="";
            
            while(i<n && str[i]!='.')
            {
                word+=str[i];
                i++;
            }
            s.push(word);
        }
        
         while(!s.empty()) 
        {
            newstr += s.top();
            s.pop();
            if (!s.empty()) 
            {
                newstr += ".";
            }
        }
        
        return newstr;
    }
};

//{ Driver Code Starts.
int main() {
    int t;
    cin >> t;
    while (t--) {
        string s;
        cin >> s;
        Solution obj;
        cout << obj.reverseWords(s) << endl;
    }
}
// } Driver Code Ends