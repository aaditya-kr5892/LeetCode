class Solution {
public:
    int tribonacci(int n) {
        int t0 = 0;
        int t1 = 1;
        int t2 = 1;
        if(n <= 2){
            if(n == 2){
                return t2;
            }
            else if(n == 1){
                return t1;
            }
            else{
                return t0;
            }
        }
        int sum = 0;
        for(int i = 3 ; i <= n ; i++){
            sum = t0 + t1 + t2;
            t0 = t1;
            t1 = t2;
            t2 = sum;
        }
        return sum;
    }
};