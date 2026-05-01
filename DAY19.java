//396. Rotate Function

class Solution {
    public int maxRotateFunction(int[] nums) {
        int n = nums.length;
        if(n==1) return 0;
        int sum = 0;
        int f=0;
        for(int i=0; i<n; i++){
            sum += nums[i];
            f += i*nums[i];
        }
        int ans = f;
        for(int i=0; i<n; i++){
            int curr = f + sum - (n*nums[n-1-i]);
            ans = Math.max(ans, curr);
            f = curr;
        }
        return ans;
    }
}

//498. Diagonal Traverse

class Solution2 {
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length, n=mat[0].length;
        if(m==0) return new int[0];
        int[] ans = new int[m*n];
        int k=0;
        for(int d=0; d<m+n-1; d++){
            if(d%2==0){ //move up
                int row = Math.min(d, m-1);
                int col = d-row;

                while(row >= 0 && col < n){
                    ans[k++] = mat[row][col];
                    row--; col++;
                }
            }else{ //move down
                int col = Math.min(d, n-1);
                int row = d - col;

                while(row < m && col >= 0){
                    ans[k++] = mat[row][col];
                    row++; col--;
                }
            }
        }

        return ans;
    }
}