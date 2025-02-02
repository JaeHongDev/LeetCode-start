class Solution {
    public String longestPalindrome(String s) {
        
        var size = s.length();

        if(size == 1 || size == 0) return s; 

        var answer = "" + s.charAt(0);
        for(int i = 0; i < size; i++) {
            if(i < size - 1 && s.charAt(i) == s.charAt(i + 1)) {
                var start = i;
                var end = i + 1; 

                while(start >= 0 && end < size && s.charAt(start) == s.charAt(end)) {
                    var temp = s.substring(start, end + 1);

                    if(temp.length() > answer.length()){
                        answer = temp;
                    }
                    start--;
                    end++;
                }

            }

            if(i < size - 2 && s.charAt(i) == s.charAt(i + 2)) {
                var start = i;
                var end = i + 2; 

                while(start >= 0 && end < size && s.charAt(start) == s.charAt(end)) {
                    var temp = s.substring(start, end + 1);

                    if(temp.length() > answer.length()){
                        answer = temp;
                    }
                    start--;
                    end++;
                }
            }
        }
        return answer;
    }
} 

// 가장 긴 팰린드롬 문자열을 구하는 문제

// babad
// ba