class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sum = 0;
        for(int i=0; i<gas.length; i++){
            sum += (gas[i]-cost[i]);
        }
        if(sum < 0) return -1;
        int cf  = 0;
        int st = 0;
        for(int i=0; i<gas.length; i++){
            cf += gas[i] - cost[i];
            if(cf<0){
                st = i+1;
                cf = 0 ;
            }
        }
        return st;
    }
}