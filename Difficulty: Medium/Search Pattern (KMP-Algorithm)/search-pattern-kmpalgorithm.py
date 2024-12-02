#User function Template for python3

class Solution:
    def search(self, pat, txt):
        # code here
        size_p = len(pat)
        size_t = len(txt)
        list1 = []
        
        for i in range(0,size_p-1+size_t):
            s = txt[i:i+size_p]
            if s == pat:
                list1.append(i)
        
        return list1 

#{ 
 # Driver Code Starts
#Initial Template for Python 3

if __name__ == '__main__':
    t = int(input())
    for _ in range(t):
        s = input().strip()
        patt = input().strip()
        ob = Solution()
        ans = ob.search(patt, s)
        if len(ans) == 0:
            print("[]", end="")
        for value in ans:
            print(value, end=' ')
        print()

# } Driver Code Ends