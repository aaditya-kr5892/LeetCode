class Solution {
    public int findLucky(int[] arr) {
        int freq[] = new int[501];
        int max = -1;
        for(int i = 0 ; i < arr.length ; i++){
            freq[arr[i]]++;
        }
        for(int i = 1 ; i < arr.length ; i++){
            if(freq[arr[i]] == arr[i])
            max = Math.max(max,freq[arr[i]]);
        }
        return max;
    }
}