class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>(); 

        for(var num: nums) {
            map.putIfAbsent(num, 0); 
            map.put(num,map.get(num) + 1);
        }
        
        return map.entrySet()
                .stream()
                .sorted((e1,e2) -> e2.getValue().compareTo(e1.getValue()))
                .limit(k)
                .mapToInt(e -> e.getKey())
                .toArray(); 
    }
}