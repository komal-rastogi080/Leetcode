class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int sum=0, n=cardPoints.length;
        for(int i=0; i<k; i++){
            sum += cardPoints[i];
        }
        int ans = sum;
        int end = n-1;
        for(int i=k-1; i>=0; i--){
            sum = sum + cardPoints[end] - cardPoints[i];
            ans = Math.max(ans, sum);
            end--;
        }
        return ans;
    }
}