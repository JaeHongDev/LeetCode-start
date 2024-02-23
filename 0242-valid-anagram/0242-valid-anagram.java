class Solution {
    public boolean isAnagram(String s, String t) {
        var ca1 = s.toCharArray();
        var ca2 = t.toCharArray();

        Arrays.sort(ca1);
        Arrays.sort(ca2);

        var size1 = ca1.length;
        var size2 = ca2.length; 

        if(size1 != size2) return false; 

        for(int i = 0; i < size1; i++) {
            if(ca1[i] != ca2[i]) return false; 
        }
        return true; 
    }
}