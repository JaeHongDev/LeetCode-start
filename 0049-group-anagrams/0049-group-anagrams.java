class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for(var str: strs){
            var chars = str.toCharArray();
            Arrays.sort(chars);

            var key = String.valueOf(chars);
            
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(str);
        }

        return new ArrayList<>(map.values()); 
    }
}