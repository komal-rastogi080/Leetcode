import java.util.*;
//3761 Minimum Absolute Distance Between Mirror Pairs

class Solution {
    public int minMirrorPairDistance(int[] nums) {
        Map<Integer, Integer> hm = new HashMap<>();
        int ans = Integer.MAX_VALUE;
        for(int j=0; j<nums.length; j++){
            if(hm.containsKey(nums[j])){
                int dist = j-hm.get(nums[j]);
                ans = Math.min(ans, dist);
            }

            int target = reverse(nums[j]);
            hm.put(target, j);
        }

        return (ans == Integer.MAX_VALUE) ? -1 : ans;
    }

    private int reverse(int n){
        int rem=0;
        while(n>0){
            rem = rem*10 + (n%10);
            n /= 10;
        }
        return rem;
    }
}   

//1329. Sort the Matrix Diagonally

class Solution2 {
    public int[][] diagonalSort(int[][] mat) {
        int m=mat.length, n=mat[0].length;
        Map<Integer, PriorityQueue<Integer>> hm = new HashMap<>();
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                hm.computeIfAbsent(i-j, k-> new PriorityQueue<>()).add(mat[i][j]);
            }
        }

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                mat[i][j] = hm.get(i-j).poll();
            }
        }

        return mat;
    }
}