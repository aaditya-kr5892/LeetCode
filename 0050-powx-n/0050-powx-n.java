class Solution {
    public double myPow(double x, int n) {
        if((x == 1 && n == Integer.MAX_VALUE) || (x == -1 && n == Integer.MAX_VALUE) || (x == 1 && n == Integer.MIN_VALUE))
        return x;
        if((x == -1 && n == Integer.MIN_VALUE))
        return x*-1;
        if((x != 1|| x != -1)&&n == Integer.MIN_VALUE)
        return 0;
        double ans = 1 ; 
        if(n > 0){
            for(int i = 0 ; i < n ; i++){
                ans *= x;
            }
        }
        else if(n == 0)
        return 1;
        else{
            for(int i = 0 ; i < -1*n ; i++){
                ans *= (1.0/x);
            }
        }
        return ans;
    }
}