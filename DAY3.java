import java.util.*;

//1848. Minimum Distance to the Target Element

class Solution {
    public int getMinDistance(int[] nums, int target, int start) {
        int n = nums.length;
        int i=0, j=n-1, ans=Integer.MAX_VALUE;
        while(i<=j){
            if(nums[i]==target)
                ans = Math.min(ans, Math.abs(i-start));
            if(nums[j]==target){
                ans = Math.min(ans, Math.abs(j-start));
            }
            i++; j--;
        }
        return ans;
    }
}

