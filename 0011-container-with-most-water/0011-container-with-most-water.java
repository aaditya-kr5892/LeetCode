class Solution {
    public int maxArea(int[] height) {
        int l = 0 ; 
        int r = height.length-1;
        int max = 0;
        while(l < r){
            int dis = r-l;
            int pro = Math.min(height[r], height[l])*dis;
            max = Math.max(max, pro);
            if(height[r] < height[l]){
                r--;
            }
            else{
                l++;
            }
        }
        return max;
    }
}