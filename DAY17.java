import java.util.*;

//453. Minimum moves to Equal Array Elements

class Solution {
    public int minMoves(int[] nums) {
        int min = Integer.MAX_VALUE;
        for(int i=0; i<nums.length; i++){
            if(nums[i] < min){
                min = nums[i];
            }
        }
        int moves = 0;
        for(int i=0; i<nums.length; i++){
            moves += nums[i] - min;
        }
        return moves;
    }
}

//462. 462. Minimum Moves to Equal Array Elements II
class Solution2 {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int median = nums[nums.length/2];
        int moves = 0;
        for(int i=0; i<nums.length; i++){
            moves += Math.abs(nums[i] - median);
        }
        return moves;
    }
}

//2033. Minimum Operations to Make a Uni-Value Grid

class Solution3 {
    public int minOperations(int[][] grid, int x) {
        List<Integer> list = new ArrayList<>();
        for(int[] arr : grid){
            for(int ele : arr){
                list.add(ele);
            }
        }
        int mod = list.get(0)%x;
        for(int ele : list){
            if(ele % x != mod) return -1;
        }
        Collections.sort(list);
        int ans = 0;
        int mid = list.get(list.size()/2);
        for(int ele : list){
            if(Math.abs(ele-mid)%x == 0)
                ans += Math.abs(ele-mid)/x;
        }

        return ans;
    }
}