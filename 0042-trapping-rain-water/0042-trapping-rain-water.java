class Solution {
    public int trap(int[] height) {
        if (height.length == 0) return 0;
        
        int prev[] = new int[height.length];
        int next[] = new int[height.length];
        
        prev[0] = height[0];
        for(int i = 1 ; i < height.length ; i++){
            prev[i] = Math.max(prev[i - 1], height[i]);
        }
        
        next[height.length - 1] = height[height.length - 1];
        for(int i = height.length - 2 ; i >= 0 ; i--){
            next[i] = Math.max(next[i + 1], height[i]);
        }
        
        int sum = 0;
        int min;
        for(int i = 0 ; i < height.length ; i++){
            min = Math.min(prev[i], next[i]);
            sum += min - height[i];
        }
        
        return sum;
    }
}