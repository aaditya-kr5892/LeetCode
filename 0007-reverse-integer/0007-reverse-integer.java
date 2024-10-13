class Solution 
{
    public int reverse(int x) 
    {
        
           int rev = 0;
           int temp = x; 
            x = Math.abs(x);
            while(x>0)
            {
                int r = x%10;
            if(rev>(Math.pow(2,31)-1)/10 || rev <( Math.pow(-2,31))/10)
            {
                return 0;
            }
                rev = rev*10+r;
                x/=10;
            }
            
            if(temp>0)
            return rev;
            else
            return rev*-1;
        
        
    }
}