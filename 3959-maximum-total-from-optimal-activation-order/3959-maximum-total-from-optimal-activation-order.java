
class Solution {
    public long maxTotal(int[]value, int []limit) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < value.length; i++) {
            map.computeIfAbsent(limit[i], k -> new ArrayList<>()).add(value[i]);
        }

        long ans = 0;
        for (int lim = 1; lim <= value.length; lim++) {
            List<Integer> list = map.get(lim);
            if (list == null) continue;

            list.sort(Collections.reverseOrder()); 
            for (int i = 0; i < Math.min(lim, list.size()); i++) {
                ans += list.get(i);
            }
        }
        return ans;
    }
}
