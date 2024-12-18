class Solution {
    public double myPow(double x, int n) {
        int c = 0 ; 
        if(n < 0 && n != Integer.MIN_VALUE){
            n *= -1;
            c = 1;
        }
        double ans = 1; 
        if(x == 1)
        return 1;
        if(x == -1) 
        return n % 2 == 0?1:-1;
        if(n == Integer.MIN_VALUE)
        return 0;
        while(n > 0){
            if(n % 2 == 1){
                ans *= x;
                n = n-1;
            }
            else{
                x = x*x;
                n /= 2;
            }
        }
        return c == 0?ans:1/ans;
    }
}