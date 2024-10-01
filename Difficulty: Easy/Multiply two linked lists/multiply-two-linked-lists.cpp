//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;

/* Linked list Node */
struct Node {
    int data;
    struct Node *next;

    Node(int x) {
        data = x;
        next = NULL;
    }
};

/* Function to create a new Node with given data */
struct Node *newNode(int data) {
    struct Node *new_Node = new Node(data);

    return new_Node;
}

Node *reverse(Node **r) {
    Node *prev = NULL;
    Node *cur = *r;
    Node *nxt;
    while (cur != NULL) {
        nxt = cur->next;
        cur->next = prev;
        prev = cur;
        cur = nxt;
    }
    *r = prev;
}

/* Function to insert a Node at the beginning of the Doubly Linked List */
void push(struct Node **head_ref, int new_data) {
    /* allocate Node */
    struct Node *new_Node = newNode(new_data);

    /* link the old list off the new Node */
    new_Node->next = (*head_ref);

    /* move the head to point to the new Node */
    (*head_ref) = new_Node;
}

void freeList(struct Node *Node) {
    struct Node *temp;
    while (Node != NULL) {

        temp = Node;
        Node = Node->next;
        free(temp);
    }
}


// } Driver Code Ends
/* Linked list node structure
struct Node
{
    int data;
    Node* next;

    Node(int x){
        data = x;
        next = NULL;
    }

};*/

/*The method multiplies
two  linked lists l1 and l2
and returns their product*/

/* Multiply contents of two linked lists */
class solution {
public:
    // Helper function to multiply two arrays
    long long multiplyTwoArray(vector<long long>& arr1, vector<long long>& arr2) {
        int n = arr1.size();
        int m = arr2.size();
        
        vector<long long> ans(n + m, 0); // Result array
        
        // Perform the multiplication
        for (int i = n - 1; i >= 0; i--) {
            long long carry = 0; // Reset carry for each digit of arr1
            for (int j = m - 1; j >= 0; j--) {
                long long mul = arr1[i] * arr2[j] + ans[i + j + 1] + carry; // Multiply and add carry and current ans
                
                ans[i + j + 1] = mul % 10; // Store the current digit
                carry = mul / 10;           // Update carry
            }
            ans[i] += carry; 
        }

        // Convert the resulting array into a single number
        long long result = 0;
        long long power = 1;

        // Skip leading zeros
        int i = 0;
        while (i < ans.size() && ans[i] == 0) i++;
        
        // Convert the result vector into a number
        for (; i < ans.size(); i++) {
            result = result * 10 + ans[i];
        }
        
        return result;
    }

    // Function to multiply two linked lists
    long long multiplyTwoLists(Node *first, Node *second) {
        vector<long long> arr1, arr2;
        
        // Convert the first linked list to a vector
        Node* temp = first;
        while (temp) {
            arr1.push_back(temp->data);
            temp = temp->next;
        }
        
        // Convert the second linked list to a vector
        temp = second;
        while (temp) {
            arr2.push_back(temp->data);
            temp = temp->next;
        }
        
        // Multiply the two arrays
        return multiplyTwoArray(arr1, arr2)%1000000007;
    }
};

//{ Driver Code Starts.

// A utility function to print a linked list
void printList(struct Node *Node) {
    while (Node != NULL) {
        printf("%d ", Node->data);
        Node = Node->next;
    }
    printf("\n");
}

/* Driver program to test above function */
int main(void) {

    int t;
    cin >> t;
    cin.ignore();
    while (t--) {

        struct Node *first = NULL;
        struct Node *second = NULL;
        vector<int> arr;
        string input;
        getline(cin, input);
        stringstream ss(input);
        int number;

        while (ss >> number) {
            arr.push_back(number);
        }
        for (int i = 0; i < arr.size(); i++) {
            push(&first, arr[i]);
        }
        vector<int> brr;
        string input2;
        getline(cin, input2);
        stringstream ss2(input2);
        int number1;
        while (ss2 >> number1) {
            brr.push_back(number1);
        }
        for (int i = 0; i < brr.size(); i++) {
            push(&second, brr[i]);
        }
        reverse(&first);
        reverse(&second);
        solution ob;
        long long res = ob.multiplyTwoLists(first, second);
        cout << res << endl;
        freeList(first);
        freeList(second);
    }
    return 0;
}

// } Driver Code Ends