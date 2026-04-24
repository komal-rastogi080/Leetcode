import java.util.*;
 //2615

  class Solution{
    public long[] distance(int[] nums){
        int n = nums.length;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0; i<n; i++){
            map.computeIfAbsent(nums[i], k-> new ArrayList<Integer>()).add(i);
        }
        long[] ans = new long[n];
        for(int key : map.keySet()){
            List<Integer> list = map.get(key);
            int l = list.size();
            long total = 0;
            for(int ele : list){
                total += ele;
            }
            long pre = 0;
            for(int i=0; i<l; i++){
                int idx = list.get(i);
                long suffix = total - pre - idx;
                ans[idx] = ((long)idx*i - pre) + (suffix - (long)idx*(l-i-1));
                pre += idx;
            }
        }
        return ans;
    }
 }


 //1685 Sum of Absolute Differences in a So
 class Solution2{
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int total = 0;
        for(int ele : nums){
            total += ele;
        }
        int pre = 0, k=0;
        for(int i=0; i<n; i++){
            int suffix = total - pre - nums[i];
            ans[k++] = (nums[i]*i - pre) + (suffix - nums[i]*(n-i-1));
            pre += nums[i];
        }

        return ans;
    }
 }

 
