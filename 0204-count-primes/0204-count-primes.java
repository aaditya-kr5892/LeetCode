class Solution {
    public int countPrimes(int n) {
        int arr[] = new int[n+1];
        int count = 0;
        if(n <2) return 0;
        for(int i = 2 ; i < n ; i++){
            if(arr[i] != 1){
                count++;
                int t = 1;
                int j = i;
                while(j <= n){
                    arr[j] = 1;
                    t++;
                    j=i*t;
                }
            }
        }
        return count;
    }
}