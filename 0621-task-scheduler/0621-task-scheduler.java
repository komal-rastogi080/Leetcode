class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for(int i=0; i<tasks.length; i++){
            freq[tasks[i]-'A']++;
        }
        int maxFreq = 0;
        for(int ele : freq){
            maxFreq = Math.max(maxFreq, ele);
        }
        int cnt = 0;
        for(int i=0; i<26; i++){
            if(freq[i]==maxFreq) cnt++;
        }

        return Math.max(tasks.length, (maxFreq -1)*(n+1)+cnt);
    }
}