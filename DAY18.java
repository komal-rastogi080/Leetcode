// import java.util.*;

//207 Remove Linked List Elements


public class DAY18 {
      int val;
      DAY18 next;
      DAY18() {}
      DAY18(int val) { this.val = val; }
      DAY18(int val, DAY18 next) { this.val = val; this.next = next; }
}
 
class Solution {
    public DAY18 removeElements(DAY18 head, int val) {
        if(head == null) return head;
        DAY18 temp = head;
        while(temp != null && temp.next!=null){
            if(temp.next.val == val){
                temp.next=temp.next.next;
            }
            else{
                temp = temp.next;
            }
        }
        if(head.val == val) head = head.next;
        return head;
    }
}

//237. Delete Node in a Linked List

class Solution2 {
    public void deleteNode(DAY18 node) {
        DAY18 prev = node ;
        while(node.next != null){
            node.val = node.next.val;
            prev = node;
            node = node.next;
        }
        prev.next=null;
    }
}

//1539. Kth Missing Positive Number (1st approach in O(n))

class Solution3 {
    public int findKthPositive(int[] arr, int k) {
        int n = arr.length;
        int[] freq = new int[arr[n-1]+1];
        for(int ele : arr){
            freq[ele]++;
        }
        for(int i=1; i<freq.length; i++){
            if(freq[i]==0){
                k--;
                if(k==0) return i;
            }
        }
        return arr[n-1]+k;
    }
}

//under o(log n) using binary search


//Here the intuition was to find missing numbers at each index and compare it with k, 
// if missing is less than k then we need to search in right half else in left half. 
// Finally low will be the index where we have k missing numbers before it and we can return low + k as the answer.
class Solution4 {
    public int findKthPositive(int[] arr, int k) {
        int n = arr.length;
        int low=0, high = n-1;
        while(low<=high){
            int mid = (low+high)/2;
            int missing = arr[mid] - (mid+1);
            if(missing<k){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return low + k;
    }
}
