class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long ans = 0, con=0;
        for(int i=0; i<nums.length; i++){
            if(nums[i]==0){
                con++;
                ans += con;
            }else{
                con = 0;
            }
        }

        return ans;
    }
}