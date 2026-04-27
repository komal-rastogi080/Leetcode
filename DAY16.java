import java.util.*;

//27. Remove Element
class Solution{
    public int removeElement(int[] nums, int val) {
        int k=0;
        for(int i=0; i<nums.length; i++){
            if(nums[i]!=val){
                nums[k]=nums[i];
                k++;
            }
        }
        return k;
    }
}

//121. Best Time to Buy and Sell Stock

class Solution2 {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int min = Integer.MAX_VALUE;
        for(int i=0; i<prices.length; i++){
            if(prices[i] < min){
                min = prices[i];
            }
            if(prices[i]-min > profit){
                profit = prices[i] - min;
            }
        }

        return profit;
    }
}