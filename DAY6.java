import java.util.*;
//3488. Closest Equal Element Queries

class Solution {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        Map<Integer, List<Integer>> hm = new HashMap<>();
        int n = nums.length;
        for(int i=0; i<n; i++){
            hm.computeIfAbsent(nums[i], k-> new ArrayList<>()).add(i);
        }

        List<Integer> res = new ArrayList<>();
        for(int i=0; i<queries.length; i++){
            int val = nums[queries[i]];
            List<Integer> list = hm.get(nums[queries[i]]);
            if(list.size()<=1) {
                res.add(-1);
                continue;
            }
            int pos = Collections.binarySearch(list, queries[i]);
            int k=list.size();
            int left = (pos==0) ? list.get((pos-1+k)%k) : list.get(pos-1);
            int right = (pos==k-1) ? list.get((pos+1-k)%k) : list.get(pos+1);

            int ldist = Math.abs(list.get(pos)-left);
            int d1 = Math.min(ldist, n-ldist);

            int rdist = Math.abs(list.get(pos)-right);
            int d2 = Math.min(rdist, n-rdist);
            res.add(Math.min(d1, d2));
        }
        return res;
    }
}

