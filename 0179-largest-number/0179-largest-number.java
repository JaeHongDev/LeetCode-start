class Solution {
    public String largestNumber(int[] nums) {
        var r = Arrays.stream(nums)
            .mapToObj(String::valueOf)
            .sorted((i, j) -> {
                var s1 = i + j;
                var s2 = j + i; 
                return s2.compareTo(s1);
            })
            .collect(Collectors.joining("")); 
        
        if(r.charAt(0) == '0') return "0";
        return r;
    }
} 

// 3
// 34
// 32