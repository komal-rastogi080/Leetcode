class Solution {
    public long minOperations(int[] nums1, int[] nums2, int k) {
        if(Arrays.equals(nums1, nums2)) return 0;
        else if(k==0) return -1;
        long pdiff=0, ndiff=0;
        for(int i=0; i<nums1.length; i++){
            int diff = nums1[i]-nums2[i];

            if(Math.abs(diff)%k != 0) return -1;

            if(diff>0) pdiff += diff;
            else ndiff += Math.abs(diff);
        }
        if(pdiff==ndiff){
            return pdiff/k;
        }
        return -1;
    }
}