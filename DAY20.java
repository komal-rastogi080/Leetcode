//788. Rotated Digits

class Solution {

    public boolean solve(int num){
        boolean f = false;

        while(num>0){
            int rem = num%10;
            if(rem==3 || rem == 7 || rem==4) return false;
            if(rem==2||rem==5||rem==6||rem==9){
                f = true;
            }

            num /= 10;
        }
        return f;
    }
    public int rotatedDigits(int n) {
        int count = 0;

        for(int i=1; i<=n; i++){
            if(solve(i)){
                count++;
            }
        }

        return count;
    }
}