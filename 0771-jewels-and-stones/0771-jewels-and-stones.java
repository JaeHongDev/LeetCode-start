class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        HashMap<Character,Integer> maps = new HashMap<>(); 
        int answer = 0; 

        for(var c: stones.toCharArray()) maps.put(c, maps.getOrDefault(c, 0) + 1); 
        for(var c: jewels.toCharArray()) answer += maps.getOrDefault(c, 0); 
        return answer;
    }
}