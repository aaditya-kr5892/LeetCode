class Solution {
    public int minMaxDifference(int num) {
        String st = Integer.toString(num);
        int sum = 0 ;
        int sum1 = 0;
        for(int j = 0 ; j < st.length() ; j++){
            if(st.charAt(j)-'0' != 9){
                for(int i = 0 ; i < st.length() ; i++){
                    if(st.charAt(i) == st.charAt(j)){
                        sum += (9*Math.pow(10,st.length()-1-i));
                    }
                    else{
                        sum+=((st.charAt(i)-'0') * Math.pow(10,st.length()-1-i));
                    }
                }
                break;
            }
            
        }
        if(sum == 0)
        sum = num;
        for(int i = 0 ; i < st.length() ; i++){
            if(st.charAt(i) == st.charAt(0)){
                sum1+=0;
            }
            else{
                sum1+=((st.charAt(i)-'0') * Math.pow(10,st.length()-1-i));
            }
        }
        return sum-sum1;
    }
}