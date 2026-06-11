class Solution {
    public int integerReplacement(int n1) {
        long n = (long)n1;
        int count = 0;
        while(n != 1){
            if(n % 2 == 0){
                n/=2;
            }
            else{
                if(n == 3){
                    count+=2;
                    return count;
                } 
                if(((n-1)/2 )%2== 0){
                    n-=1;
                }
                else if(((n+1)/2) % 2 == 0){
                    n+=1;
                }
            }
            count++;
        }
        return count;
    }
}