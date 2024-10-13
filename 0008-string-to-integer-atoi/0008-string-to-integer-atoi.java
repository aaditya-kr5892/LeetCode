class Solution 
{
    public int myAtoi(String s) 
    {
        s = s.trim();
        if (s.isEmpty()) return 0;

        int sign = 1, n = 0, i = 0;
        if (s.charAt(i) == '+' || s.charAt(i) == '-') {
            sign = (s.charAt(i) == '-') ? -1 : 1;
            i++;
        }

        while (i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
            int digit = s.charAt(i) - '0';
            if (n > (Integer.MAX_VALUE - digit) / 10) {
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            n = n * 10 + digit;
            i++;
        }
        
        return n * sign;
    }
}
