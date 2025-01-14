class Solution {
    public int candy(int[] ratings) {
        int last = 1 ; 
        int total = 1;
        int sum = 0;
        int left[] = new int[ratings.length];
        for(int i = 1 ; i < ratings.length ; i++){
            if(ratings[i] > ratings[i-1]){
                last++;
                left[i] = last;
            }
            else{
                last = 1;
                left[i] = last;
            }
        }
        last = 1;
        for(int i = ratings.length-2 ; i >=0 ; i--){
            if(ratings[i] > ratings[i+1]){
                last++;
                sum+=(left[i]>last)?left[i]:last;
            }
            else{
                last = 1;
                sum+=(left[i]>last)?left[i]:last;
            }
        }
        sum+=(left[ratings.length-1]>1)?left[ratings.length-1]:1;
        return sum;
    }
}