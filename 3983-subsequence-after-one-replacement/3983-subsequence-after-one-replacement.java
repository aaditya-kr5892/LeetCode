class Solution {
    public boolean canMakeSubsequence(String s, String t) {
        int i = 0, j = 0 ;
        int left[] = new int[s.length()];
        int right[] = new int[s.length()];
        Arrays.fill(left, -1);
        Arrays.fill(right, -1);
        while(i < s.length() && j < t.length()){
            if(s.charAt(i) == t.charAt(j)){
                left[i] = j;
                i++;
                j++;
            }
            else{
                j++;
            }
        }
        i = s.length()-1;
        j = t.length()-1;
        while(i >= 0 && j >= 0){
            if(s.charAt(i) == t.charAt(j)){
                right[i] = j;
                i--;
                j--;
            }
            else{
                j--;
            }
        }
        int l_ind = -1, r_ind = -1;
        for(int i1 = 0 ; i1 < left.length ; i1++){
            if(left[i1] == -1){
                l_ind = i1;
                break;
            }

        }
        // for(int i1 = right.length-1 ; i1 >= 0 ; i1--){
        //     if(right[i1] == -1){
        //         r_ind = i1;
        //     }
        // }

        if(l_ind == -1) return true;
        for (int k = 0; k < s.length(); k++) {
            boolean validLeft = (k == 0) || (left[k - 1] != -1);
            boolean validRight = (k == s.length() - 1) || (right[k + 1] != -1);
            if (validLeft && validRight) {
                int leftEnd = (k == 0) ? -1 : left[k - 1];
                int rightStart = (k == s.length() - 1) ? t.length() : right[k + 1];

                if (rightStart - leftEnd >= 2) {
                    return true;
                }
            }
        }
        return false;
    }
}