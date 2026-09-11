class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left=0, n=nums.length,ans=Integer.MAX_VALUE;
        int currSum=0;
        for(int right=0; right<n; right++){
            currSum+= nums[right];
            while(currSum >= target){
                ans = Math.min(ans, right-left+1);
                currSum -= nums[left];
                left++;
            }
        }
        return ans==Integer.MAX_VALUE?0:ans;
    }
}