class Solution {
    public boolean isPalindrome(String s) {
        var len = s.length();
        // 공백을 제외하고 대소문자가 같아야 함

        var ll = 0;
        var rl = s.length() -1;

        while(ll <= rl) {
            var l = s.charAt(ll);
            var r = s.charAt(rl);

            if(!Character.isLetterOrDigit(l)) ll++;
            else if(!Character.isLetterOrDigit(r)) rl--;
            else if(Character.toLowerCase(l) == Character.toLowerCase(r))  {
                ll++;
                rl--;
            }
            else return false;
        }

        return true;
   }
}