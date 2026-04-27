import java.util.*;
//334. Increasing Triplet Subsequence

class Solution{
    public boolean increasingTriplet(int[] nums){
        int n = nums.length;
        int num1, num2;
        num1 = num2 = Integer.MAX_VALUE;
        for(int i=0; i<n; i++){
            if(nums[i]<=num1)  num1 = nums[i];
            else if(nums[i]<=num2) num2 = nums[i];
            else return true;
        }

        return false;
    }
}

//976. Largest Perimeter Triangle

class Solution2{
    public int largestPerimeter(int[] nums){
        Arrays.sort(nums);
        for(int i=nums.length-1; i>=2; i--){
            int a = nums[i];
            int b= nums[i-1];
            int c = nums[i-2];
            if(a < b+c){
                return a+b+c;
            }
        }

        return 0;
    }
}

//219. Contains Duplicate II
class Solution3{
    public boolean containsNearbyDuplicate(int[] nums, int k){
        Map<Integer, Integer> hm = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            if(hm.containsKey(nums[i]) && (i-hm.get(nums[i])<=k)){
                return true;
            }else{
                hm.put(nums[i], i);
            }
        }
        return false;
    }
}

//645. Set Mismatch

class Solution4 {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n+1];
        for(int i=0; i<n; i++){
            arr[nums[i]]++;
        }
        int[] ans = new int[2];
        for(int i=1; i<n+1; i++){
            if(arr[i]>1) ans[0]=i;
            if(arr[i]==0) ans[1]=i;
        }
        return ans;
    }
}