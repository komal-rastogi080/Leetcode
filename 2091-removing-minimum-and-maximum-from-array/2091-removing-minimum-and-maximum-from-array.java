class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;
        if(n==1 || n==2) return n;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int maxi=-1,mini=-1;

        for(int i=0; i<n; i++){
            if(nums[i]>max) {
                max = nums[i];
                maxi=i;
            }
            if(nums[i]<min){
                min = nums[i];
                mini = i;
            }
        }
        int front = Math.max(mini,maxi)+1;
        front = Math.min(front,n-Math.min(maxi, mini));
        front = Math.min(front, (Math.min(maxi, mini)+1+n-Math.max(mini, maxi)));

        return front;
    }
}