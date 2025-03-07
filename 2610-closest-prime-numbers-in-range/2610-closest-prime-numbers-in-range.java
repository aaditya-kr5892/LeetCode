class Solution {
    public int[] closestPrimes(int left, int right) {
        int arr[] = new int[right+1];
        f(arr);
        int res[] = new int[2];
        int p1 = 0; 
        int p2 = 0;
        int min = Integer.MAX_VALUE;
        int c = 0 ;
        for(int i = left ; i < arr.length ; i++){
            if(arr[i] == 0){  
                if(p1 == -1){
                    p1 = i;
                } 
                else {
                    p2 = i;
                    if(p2 - p1 < min){
                        res[0] = p1;
                        res[1] = p2;
                        min = p2 - p1;
                    }
                    p1 = p2; 
                }
            }
        }
        if(res[0] == 0||res[1] == 0){
            res[0] = -1;
            res[1] = -1;
        }
        return res;
    }
    void f(int arr[]){
        arr[0] = 1;
        arr[1] = 1;
        for(int i = 2 ; i*i < arr.length ; i++){
            if(arr[i] == 0){
                for(int j = i*i ; j < arr.length ; j+=i){
                    arr[j] = 1;
                }
            }
        }
    }
}