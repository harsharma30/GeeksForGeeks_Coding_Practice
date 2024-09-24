//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner scan = new Scanner(System.in);
		int test = scan.nextInt();
		
		while(test > 0){
		    String s = scan.next();
		    String t = scan.next();
		    
		    System.out.println(new Solution().smallestWindow(s, t));
		    test--;
		}
	}
}
// } Driver Code Ends


class Solution
{
    //Function to find the smallest window in the string s consisting
    //of all the characters of string p.
    public static String smallestWindow(String s, String p)
    {
        // Your code here
         if (s.length() < p.length()) return "-1";
        HashMap<Character, Integer> pMap = new HashMap<>();
        for (char c : p.toCharArray()) {
            pMap.put(c, pMap.getOrDefault(c, 0) + 1);
        }

        int start = 0, minStart = 0, minLen = Integer.MAX_VALUE, count = 0;
        HashMap<Character, Integer> sMap = new HashMap<>();

        for (int end = 0; end < s.length(); end++) {
            char endChar = s.charAt(end);
            sMap.put(endChar, sMap.getOrDefault(endChar, 0) + 1);
            if (pMap.containsKey(endChar) && sMap.get(endChar) <= pMap.get(endChar)) {
                count++;
            }
            while (count == p.length()) {
                if (end - start + 1 < minLen) {
                    minLen = end - start + 1;
                    minStart = start;
                }
                char startChar = s.charAt(start);
                sMap.put(startChar, sMap.get(startChar) - 1);
                if (pMap.containsKey(startChar) && sMap.get(startChar) < pMap.get(startChar)) {
                    count--;
                }
                
                start++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "-1" : s.substring(minStart, minStart + minLen);
    }
}