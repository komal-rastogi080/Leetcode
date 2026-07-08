class Solution {
    public int findPeakElement(int[] nums) {
        int start = 0, end = nums.length-1;
        int n = nums.length;
        if(n==1) return 0;
        if(n==2){
            if(nums[0]>nums[1]) return 0;
            else return 1;
        }
        while(start<end){
            int mid = start+(end-start)/2;
            if(nums[mid]>nums[mid+1]) end = mid;
            else start = mid+1;
        }

        return start;
    }
}