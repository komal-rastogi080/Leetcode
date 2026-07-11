class Solution {
    public long makeSimilar(int[] nums, int[] target) {
        Arrays.sort(nums);
        Arrays.sort(target);
        if(Arrays.equals(nums, target)) return 0;
        List<Integer> even = new ArrayList<>();
        List<Integer> odd = new ArrayList<>();
        List<Integer> evenT = new ArrayList<>();
        List<Integer> oddT = new ArrayList<>();

        for(int ele : nums){
            if(ele%2==0) even.add(ele);
            else odd.add(ele);
        }

        for(int ele : target){
            if(ele%2==0) evenT.add(ele);
            else oddT.add(ele);
        }

        long operations = 0;
        for(int i=0; i<even.size(); i++){
            if(even.get(i)>evenT.get(i)){
                operations += (even.get(i)-evenT.get(i))/2;
            }
        }
        for(int i=0; i<odd.size(); i++){
            if(odd.get(i)>oddT.get(i)){
                operations += (odd.get(i)-oddT.get(i))/2;
            }
        }

        return operations;
    }
}