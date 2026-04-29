// import java.util.*;

//2515. Shortest Distance to Target String in a Circular Array

class Solution {
    public int closestTarget(String[] words, String target, int startIndex) {
        int n=words.length;
        int ans = Integer.MAX_VALUE;
        for(int i=0; i<n; i++){
            if(words[i].equals(target)){
                int dist = Math.abs(i-startIndex);

                int cir = n-dist;
                ans = Math.min(ans, Math.min(dist, cir));
            }
        }

        return (ans==Integer.MAX_VALUE) ? -1 : ans;
    }
}