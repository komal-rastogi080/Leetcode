import java.util.*;
//724. Find Pivot Index

class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int total = 0, leftSum = 0;
        for(int ele : nums){
            total += ele;
        }

        for(int i=0; i<n; i++){
            if(leftSum + nums[i] == total - leftSum) return i;
            leftSum += nums[i];
        }
        return -1;
    }
}

//1896. Redistribute Characters to Make All Strings Equal

class Solution2 {
    public boolean makeEqual(String[] words) {
        int n = words.length;

        int count = 0;
        for(String s : words){
            count += s.length();
        }
        if(count % n != 0) return false;
        int[] freq = new int[26];
        for(String s : words){
            for(char c : s.toCharArray()){
                freq[c-'a']++;
            }
        }

        for(int i=0; i<26; i++){
            if(freq[i] % n != 0) return false;
        }
        return true;
    }
}


//1758. Minimum Changes To Make Alternating Binary String

class Solution3 {
    public int minOperations(String s) {
        int n = s.length();
        int count = 0;
        for(int i=0; i<n; i++){
            count += (s.charAt(i) ^ i) & 1;
        }

        return Math.min(count, n-count);
    }
}

//2966. Divide Array Into Arrays With Max Difference

class Solution4 {
    public int[][] divideArray(int[] nums, int k) {
        int n = nums.length;
        int[][] ans = new int[n/3][3];
        Arrays.sort(nums);
        
        for(int i=0; i<n; i+=3){
            if(nums[i+2] - nums[i] > k){
                return new int[0][0];
            }
            ans[i/3] = new int[]{nums[i], nums[i+1], nums[i+2]};
        }

        return ans;
    }
}

//2078. Two Furthest Houses With Different Colors

class Solution5 {
    public int maxDistance(int[] colors) {
        int n=colors.length;
        int i=0, j=n-1;
        int ans = Integer.MIN_VALUE;
        while(i<j){
            if(colors[i]!=colors[j]){
                ans = j-i;
                break;
            }
            j--;
        }
        j=n-1;
        while(i<j){
            if(colors[i]!=colors[j]){
                ans = Math.max(ans,Math.abs(i-j));
                break;
            }
            i++;
        }

        return ans;
    }
}