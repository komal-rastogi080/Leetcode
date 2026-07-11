class Solution {
    public int minOperations(int n) {
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = (2*i)+1;
        }
        int sum=0;
        for(int ele : arr){
            sum+=ele;
        }
        int target=sum/n;
        int ans = 0;
        for(int i=0; i<n/2; i++){
            ans+= target-(arr[i]);
        }
        return ans;
    }
}