class Solution {
    public long getDescentPeriods(int[] prices) {
        long count=0;
        int n=prices.length;
        int i=0, j=1;
        while(j<n){
            if(prices[j-1]-prices[j] != 1){
                long k = j-i;
                count += k*(k+1)/2;
                i=j;
            }
            j++;
        }
        long k = j-i;
        count += k*(k+1)/2;
        return count;
    }
}