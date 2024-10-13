class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        
        if(bloomDay.length < (long)m*k) return -1;
        for(int i = 0 ; i < bloomDay.length ; i++){
            max = Math.max(max,bloomDay[i]);
            min = Math.min(min,bloomDay[i]);
        }
        //int j = min;
        int low = min;
        int high = max;
        while(low<=high){
            int count = 0 ;
            int mid = (low+high)/2;
            int b = 0 ; 
            for(int i = 0 ; i < bloomDay.length ; i++){
                if(bloomDay[i]<=mid){
                    count++;
                }
                else{
                    b += count/k;
                    count = 0 ; 
                }
            }
            b+=count/k;
            if(b>=m) high = mid-1;
            else low = mid+1;
            //else high = mid - 1;
        }
        return low;
    }
}