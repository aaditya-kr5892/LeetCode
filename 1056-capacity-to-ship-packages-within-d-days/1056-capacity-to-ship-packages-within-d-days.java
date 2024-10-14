class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int sum = 0 ;
        int max = Integer.MIN_VALUE;
        for(int i = 0 ; i < weights.length ; i++){
            max = Math.max(max,weights[i]);
            sum += weights[i];
        }
        int low = max;
        int high = sum ;
        while(low<=high){
            int sum1 = 0 ; 
            int count = 1 ;
            int mid = (low+high)/2;
            for(int i = 0 ; i < weights.length ; i++){
                //if(sum1<=mid)
                //sum1+=weights[i];
                if(sum1+weights[i]>mid){
                    sum1=0;
                    count++;
                }
                sum1+=weights[i];
            }
            if(count>days)
            low = mid + 1;
            else 
            high = mid -1;
            
        }
        return low;
    }
}