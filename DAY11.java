import java.util.*;
//985. Sum of Even Numbers After Queries

class Solution {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int  q = queries.length;
        int evenSum=0;
        for(int ele : nums){
            if(ele%2 == 0) evenSum += ele;
        }

        int[] ans = new int[q];
        for(int i=0; i<q; i++){
            int idx = queries[i][1];
            int val = queries[i][0];
            
            if(nums[idx] % 2 == 0) {
                evenSum -= nums[idx];
            }

            nums[idx] += val;
            if(nums[idx] % 2 == 0){
                evenSum += nums[idx];
            }
            ans[i] = evenSum;
        }

        return ans;
    }
}

//2007. Find Original Array From Doubled Array

class Solution2 {
    public int[] findOriginalArray(int[] changed) {
        int n = changed.length;
        if(n%2 != 0) return new int[0];
        int max = 0;
        for(int ele : changed){
            if(ele > max){
                max = ele;
            }
        }

        int[] freq = new int[max*2 + 1];
        for(int ele : changed){
            freq[ele]++;
        }
        int[] ans = new int[n/2];
        int k=0;
        for(int i=0; i<=max; i++){
            if(freq[i]>0){
                freq[i]--;
                int val = 2*i;
                if(freq[val]>0){
                    ans[k++]=i;
                    freq[val]--;
                }else{
                    return new int[0];
                }
                i--;
            }
        }

        return ans;
    }
}

//1722. Minimize Hamming Distance After Swap Operations

class Solution3 {

    private int[] parent;

    private int find(int x){
        if(parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    }

    private void unite(int a, int b){
        parent[find(a)] = find(b);
    }
    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
         int n = source.length;
         parent = new int[n];
         for(int i=0; i<n; i++) parent[i] = i;

         for(int[] swap : allowedSwaps){
            unite(swap[0], swap[1]);
         }
         Map<Integer, Map<Integer, Integer>> groups = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int root = find(i);
            groups.computeIfAbsent(root, k -> new HashMap<>())
                  .merge(source[i], 1, Integer::sum);
        }

        int hammingDist = 0;
        for (int i = 0; i < n; i++) {
            int root = find(i);
            Map<Integer, Integer> freq = groups.get(root);
            if (freq.getOrDefault(target[i], 0) > 0) {
                freq.merge(target[i], -1, Integer::sum);
            } else {
                hammingDist++;
            }
        }

        return hammingDist;
         
    }
}