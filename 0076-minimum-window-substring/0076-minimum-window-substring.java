class Solution {

    public String minWindow(String s, String t) {
        Map<Character, Integer> need = new HashMap<>(); 

        for(var c: t.toCharArray()) need.put(c, need.getOrDefault(c, 0) + 1); 


        var missing = t.length();
        var left = 0;
        var right = 0; 
        var start = 0; 
        var end = 0; 
        var minLen = Integer.MAX_VALUE;

        
        for(var c: s.toCharArray()){
            right++; 

            if(need.containsKey(c) && need.get(c) > 0) missing--; 

            need.put(c, need.getOrDefault(c, 0) - 1); 

            if(missing == 0){
                while(left < right && need.get(s.charAt(left)) < 0){
                    need.put(s.charAt(left), need.getOrDefault(s.charAt(left),0) + 1);
                    left++;
                }


                if(minLen > right - left + 1){
                    minLen = right - left + 1; 
                    start = left;
                    end = right; 
                }

                need.put(s.charAt(left), need.getOrDefault(s.charAt(left), 0) + 1 ); 
                missing++; 
                left++;
            }
        }
        return s.substring(start, end);
    }
}