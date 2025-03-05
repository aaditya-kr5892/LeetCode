class Solution {
    public long coloredCells(int n) {
        long res = f(n);
        return res;
    }
    long f(int n){
        if(n==1){
            return 1;
        }
        return (n-1)*4 +f(n-1);
    }
}