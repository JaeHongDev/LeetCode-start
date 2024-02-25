class Solution {
    public boolean isPalindrome(String s) {
        var left = 0; 
        var right = s.length() - 1;

        while(left < right) {

            var l = Character.toLowerCase(s.charAt(left));
            var r = Character.toLowerCase(s.charAt(right));

            if(!(Character.isAlphabetic(l) || Character.isDigit(l))) left++;
            else if(!(Character.isAlphabetic(r) || Character.isDigit(r))) right--;
            else if(l != r) return false;
            else {
                left++;
                right--; 
            }
        }

            
        return true; 
    }

}