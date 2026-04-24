import java.util.*;

//3783. Mirror Distance of an Integer

class Solution {
    public int mirrorDistance(int n) {
        int rev=0, num=n;
        while(num>0){
            int mod = num%10;
            rev = (rev*10)+mod;
            num /= 10;
        }
        return Math.abs(rev-n);
    }
}