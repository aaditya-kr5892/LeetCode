class Solution {
    public int compress(char[] chars) {
        int count = 1;
        // List<Character> list = new ArrayList<>();
        int j = 0;
        int size = 0;
        for(int i = 0 ; i < chars.length-1 ; i++){
            if(chars[i] == chars[i+1]){
                count++;
            }
            else{
                size++;
                if(count == 1){
                    chars[j] = chars[i];
                    j++;
                    count = 1;
                    continue;
                } 
                chars[j] = chars[i];
                j++;
                int prev = j;
                while(count > 0){
                    size++;
                    chars[j++] = (char)((count%10)+'0');
                    count/=10;
                }
                int end = j-1;
                while(prev < end){
                    swap(prev, end, chars);
                    prev++;
                    end--;
                }
                if(count == 0) count = 1;
            }
        }
        if(count != 0){
            size++;
            if(count == 1){
                chars[j] = chars[chars.length-1];
                j++;
                count = 1;
                // continue;
                return size;
            } 
            chars[j] = chars[chars.length-1];
            j++;
            
            int prev = j;
            while(count > 0){
                size++;
                chars[j++] = (char)((count%10)+'0');
                count/=10;
            }
            int end = j-1;
            while(prev < end){
                swap(prev, end, chars);
                prev++;
                end--;
            }
            if(count == 0) count = 1;
        }
        return size;
    }
    void swap(int i, int j, char[] chars){
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}
