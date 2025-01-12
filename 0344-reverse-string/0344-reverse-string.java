class Solution {
    public void reverseString(char[] s) {
        var length = s.length;
        var size = length / 2;
        for(int i = 0; i < size; i++) {
            var temp = s[i];
            s[i] = s[length - (i + 1)];
            s[length - (i + 1)] = temp;
        }
    }
}