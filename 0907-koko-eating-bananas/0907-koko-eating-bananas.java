class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1 ;
        int high = Integer.MIN_VALUE;
        
        for(int i = 0 ; i < piles.length ; i++){
            high = Math.max(piles[i],high);
        } 
        int k = high ;
        while(low<=high){
            double mid = (low +high)/2;
            int sum = 0 ; 
            for(int i = 0 ; i < piles.length ; i++){
                sum+=Math.ceil(piles[i]/mid);
            }
            if(sum <= h){
                k = Math.min((int)mid,k);
                high = (int)mid-1;
            }
            if(sum > h){
                low = (int)mid+1;
            }
        }
        return k;
    }
}