//26. Remove Duplicates from Sorted Array

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

//80. Remove Duplicates from Sorted Array II

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
