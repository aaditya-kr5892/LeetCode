class Solution {
    public int myAtoi(String s) {
        s = s.trim();
        int i = 0;
        if(s.isEmpty()) return 0;
        int digit = 0;
        int result = 0;
        int sign = 1;
            if(s.charAt(i) == '-'){
                i++;
                sign = -1;
            }
            else if(s.charAt(i) == '+'){
                i++;
                sign = 1;
            }
            while(i<s.length() &&(s.charAt(i) <= 57 && s.charAt(i) >= 48)){
                digit = s.charAt(i) -'0';
                
                if((result > Integer.MAX_VALUE/10) || (result == Integer.MAX_VALUE/10 && digit >7))
                return sign == 1 ? Integer.MAX_VALUE :Integer.MIN_VALUE;
                result = result * 10 + digit;
                i++;
            }
            return result*sign;
        }

    }