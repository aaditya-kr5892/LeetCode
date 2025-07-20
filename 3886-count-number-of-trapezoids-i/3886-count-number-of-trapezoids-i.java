class Solution {
    public int countTrapezoids(int[][] points) {
        int MOD = 1_000_000_007;
        Map<Integer, Integer> map = new HashMap<>();
        Set<String> unique = new HashSet<>();
        for (int[] point : points) {
            unique.add(point[0] + "," + point[1]);
        }
        for (String s : unique) {
            int y = Integer.parseInt(s.split(",")[1]);
            map.put(y, map.getOrDefault(y, 0) + 1);
        }

        if(map.size()<2){
            return 0;
        }
        long S = 0;  
        long S2 = 0;

        for (int count : map.values()) {
            if (count >= 2) {
                long pairs = (1L * count * (count - 1)) % MOD;
                pairs = (pairs * inv2(MOD)) % MOD;
                S = (S + pairs) % MOD;
                S2 = (S2 + (pairs * pairs % MOD)) % MOD;
            }
        }


        long Ssq = (S * S) % MOD;
        long total = (Ssq - S2 + MOD) % MOD;
        total = (total * inv2(MOD)) % MOD;

        // total = (total * inv2(MOD)) % MOD;  

        return (int) total;
    }
    long inv2(int MOD) {
        return (MOD + 1) / 2;  
    }
}