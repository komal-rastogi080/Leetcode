class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int j=0;
        int[] lastSeen = {-1,-1,-1};
        int count = 0;
        while(j<n){
            lastSeen[s.charAt(j)-'a'] = j;
            count += Math.min(lastSeen[0], Math.min(lastSeen[1], lastSeen[2]))+1;
            j++;
        }
        return count;
    }
}