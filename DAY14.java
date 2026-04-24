//26. Remove Duplicates from Sorted Array

class Solution {
    public int removeDuplicates(int[] nums) {
        int n=nums.length;
        int k=1;
        for(int i=1; i<n; i++){
            if(nums[i] != nums[k-1]){
                nums[k++] = nums[i];
            }
        }

        return k;
    }
}

//80. Remove Duplicates from Sorted Array II

class Solution2{
    public int removeDuplicates_2(int[] nums) {
        int k = 2;
        for(int i=2; i<nums.length; i++){
            if(nums[i] != nums[k-2]){
                nums[k]=nums[i];
                k++;
            }
        }

        return k;
    }
}


//2833. Furthest point fom origin
class Solution3 {
    public int furthestDistanceFromOrigin(String moves) {
        int n = moves.length();
        int lcount=0,rcount=0;
        for(char c : moves.toCharArray()){
            if(c == 'L') lcount++;
            if(c == 'R') rcount++;
        }
        int underScores = n-(lcount+rcount);

        return Math.abs(lcount-rcount) + underScores;
    }
}