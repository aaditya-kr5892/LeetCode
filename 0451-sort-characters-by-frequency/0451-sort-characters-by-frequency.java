class Solution {
    public String frequencySort(String s) {
        int arr[] = new int[128];
        char cmax =',' ;
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < s.length() ; i++){
            arr[(int)s.charAt(i)]++;
        }
        for(int i = 48 ; i < arr.length ; i++){
            for(int j = 48 ; j < arr.length ; j++){
                if(arr[j] > arr[cmax])
                cmax = (char)j;
            }
            while(arr[cmax]!=0){
                sb.append(cmax);
                arr[cmax]--;
            }
        }
        return sb.toString();
    }
}