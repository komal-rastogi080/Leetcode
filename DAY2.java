import java.util.*;
//1320. Minimum Distance to Type a Word Using Two Fingers

class Solution {
    int cal(int a, int b) {
        return Math.abs(a / 6 - b / 6) + Math.abs(a % 6 - b % 6);
    }

    public int minimumDistance(String word) {
        int n = word.length();
        int[][][] dp = new int[n + 1][26][26];

        for (int i = 0; i < n; i++) {
            int t = word.charAt(i) - 'A';

            for (int j = 0; j < 26; j++) {
                for (int k = 0; k < 26; k++) {
                    dp[i + 1][j][k] = 1000000;
                }
            }

            for (int j = 0; j < 26; j++) {
                for (int k = 0; k < 26; k++) {
                    dp[i + 1][j][t] = Math.min(dp[i + 1][j][t], dp[i][j][k] + cal(k, t));
                    dp[i + 1][t][k] = Math.min(dp[i + 1][t][k], dp[i][j][k] + cal(j, t));
                }
            }
        }

        int ans = 1000000;
        for (int j = 0; j < 26; j++) {
            for (int k = 0; k < 26; k++) {
                ans = Math.min(ans, dp[n][j][k]);
            }
        }

        return ans;
    }
}

//15. 3Sum

class Solution2 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0; i<n-2; i++){
            if(i!=0 && nums[i]==nums[i-1]) continue;
            int target = nums[i];
            int j=i+1, k=n-1;
            while(j<k){

                if(nums[j]+nums[k] > -(target)){
                    k--;
                }else if(nums[j]+nums[k]<-target){
                    j++;
                }else{
                    while(j<k && nums[j]==nums[j+1]) j++;
                while(j<k && nums[k]==nums[k-1]) k--;
                    ans.add(new ArrayList<>(Arrays.asList(target, nums[j], nums[k])));
                    j++;
                    k--;
                }
            }
        }
        return ans;
    }
}

//3741. Minimum Distance Between Three Equal Elements II

class Solution3 {
    public int minimumDistance(int[] nums) {
         int dist = Integer.MAX_VALUE;
        boolean f = false;
        HashMap<Integer, List<Integer>> hm = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            hm.computeIfAbsent(nums[i], key -> new ArrayList<>()).add(i);
        }
        for(List<Integer> l : hm.values()){
            if(l.size() < 3)
                continue;
            for(int i=0; i+2<l.size(); i++){
                int a = l.get(i);
                int c = l.get(i+2);

                dist = Math.min(dist, Math.abs(c-a)*2);
                f = true;
            }
        }

        return f? dist : -1;
    }
}