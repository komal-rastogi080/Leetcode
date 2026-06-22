class Solution {
    public int maxNumberOfBalloons(String text) {
        int[] freq = new int[26];
        for(char ch : text.toCharArray()){
            freq[ch-'a']++;
        }
        int b = freq[1];
        int a = freq[0];
        int l = freq['l'-'a'];
        int o = freq['o'-'a'];
        int n = freq['n'-'a'];

        return Math.min(o/2,Math.min(l/2,Math.min(n,Math.min(b,a))));
    }
}