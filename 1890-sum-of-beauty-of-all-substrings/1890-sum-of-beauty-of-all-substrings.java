class Solution {
    public int beautySum(String s) {
        int sum = 0 ;
        for(int i = 0 ; i < s.length() ; i++){
            int hash[] = new int[26];
            for(int j = i ; j < s.length() ; j++){
                hash[s.charAt(j) -'a']++;
                sum+=fmax(hash)-fmin(hash);
            }
        }
        return sum;
    }
    static int fmin(int arr[]){
        int min = Integer.MAX_VALUE;
        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i] != 0)
            min = Math.min(min,arr[i]);
        }
        return min;
    }
    static int fmax(int arr[]){
        int max = 0;
        for(int i = 0 ; i < arr.length ; i++){
            max = Math.max(max,arr[i]);
        }
        return max;
    }
}