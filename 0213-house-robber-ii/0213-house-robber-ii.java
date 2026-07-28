class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1) return nums[0];
        if(n==2) return Math.max(nums[0], nums[1]);
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        int a = solve(nums, dp, 0, n-1);
        Arrays.fill(dp,-1);
        int b = solve(nums, dp,1,n);

        return Math.max(a,b);
    }

    private static int solve(int[] nums, int[] dp, int i, int n){
        if(i>=n) return 0;
        if(dp[i]!=-1) return dp[i];
        int inc = solve(nums, dp, i+2, n) + nums[i];
        int inc2 = solve(nums, dp, i+1, n);

        return dp[i] = Math.max(inc, inc2);
    }
}