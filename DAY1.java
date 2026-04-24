//2864

class Solution {
    public String maximumOddBinaryNumber(String s) {
        int c0=0, c1=-1;
        for(char ch : s.toCharArray()){
            if(ch == '1') c1++;
            else c0++;
        }
        String ans = "1".repeat(c1) + "0".repeat(c0) + "1";
        return ans;
    }
}

//At first, i tried this approach but it ran under 3ms, so i looked up the approaches run in 1ms and it was interesting

//2864 another approach
class Solution{
    public String maximumOddBinaryNumber(String s) {
        int n=s.length();
        char[] ch = s.toCharArray();
        int left = 0, right = n-1;
        while(left <= right){
            if(ch[left] == '0' && ch[right] == '1'){
                ch[left] ='1';
                ch[right] = '0';
                left++;
                right--;
            }else{
                if(ch[left] == '1') left++;
                if(ch[right] == '0') right--;
            }
        }
        arr[right]='0';
        arr[n-1]='1';
        return new String(ch);
    }
}

//1496

class Solution {
    public boolean isPathCrossing(String path) {
        Set<String> set = new HashSet<>();
        set.add("0,0");
        int x=0,y=0;
        for(char ch : path.toCharArray()){
            if(ch=='N') y++;
            else if(ch == 'E') x++;
            else if(ch=='S') y--;
            else x--;

            String curr = x +"," + y;
            if(set.contains(curr)) return true;
            else set.add(curr);
        }
        return false;
    }
}