class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        var left = 0; 
        var right = s.length() - 1;

        while(left < right) {

            var l = s.charAt(left);
            var r = s.charAt(right);

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