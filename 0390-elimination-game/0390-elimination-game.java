class Solution {
    public int lastRemaining(int n) {
        return fun(n, true);
    }

    public static int fun(int n, boolean left){
        if(n==1) return 1;

        if(left || n%2==1){
            return 2*fun(n/2, !left);
        }
        else return 2*fun(n/2, !left)-1;
    }
}