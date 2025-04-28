class Solution {
    public long countSubarrays(int[] nums, long K) {
        int n = nums.length;
        int i = 0;
        long sum = 0;
        long count = 0;

        for (int j = 0; j < n; j++) {
            sum += nums[j];
            while (i <= j && sum * (j - i + 1) >= K) {
                sum -= nums[i];
                i++;
            }
            count += (j - i + 1);
        }
        return count;
    }
}
