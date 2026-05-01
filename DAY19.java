//396. Rotate Function

class Solution {
    public int maxRotateFunction(int[] nums) {
        int n = nums.length;
        if(n==1) return 0;
        int sum = 0;
        int f=0;
        for(int i=0; i<n; i++){
            sum += nums[i];
            f += i*nums[i];
        }
        int ans = f;
        for(int i=0; i<n; i++){
            int curr = f + sum - (n*nums[n-1-i]);
            ans = Math.max(ans, curr);
            f = curr;
        }
        return ans;
    }
}