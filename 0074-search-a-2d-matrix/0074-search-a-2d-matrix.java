class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int arr[] = new int[matrix.length*matrix[0].length];
    
        for(int i = 0 ; i < matrix.length ; i++){
            for(int j = 0 ; j < matrix[0].length ; j++){
                arr[matrix[0].length*i+j] = matrix[i][j];
            }
        }
    
        int l = 0; 
        int r = arr.length-1;
        while(l <= r){
            int mid = (l+r)/2;
            if(arr[mid] > target){
                r= mid-1;
            }
            else if(arr[mid] < target){
                l = mid+1;
            }
            else{
                return true;
            }
        }
        return false;
    }
}