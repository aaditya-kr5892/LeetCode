class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        for(int i = 0 ; i < flowerbed.length ; i++){
            int k = 0;
            if(flowerbed[i] == 0){
                if(i - 1 >= 0){
                    if(flowerbed[i-1] == 1){
                        k = 1;
                        // continue;
                    }
                    
                }
                if(i + 1 < flowerbed.length){
                    if(flowerbed[i+1] == 1){
                        k = 1;
                        // continue;
                    }
                }
                if(k == 0){
                    flowerbed[i] = 1;
                    count++;
                }
            }
        }
        return count >= n;
    }
}