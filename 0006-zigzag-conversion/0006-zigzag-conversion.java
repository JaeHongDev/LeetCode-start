class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1) return s;
        var list = new StringBuilder[numRows];

        for(int i = 0; i < numRows; i++){
            list[i] = new StringBuilder();
        }
        
        var index = 0;
        var len = s.length();
        var row = 0;

        while(index < len) {
            if(row < numRows) {
                list[row++].append(s.charAt(index++));
                continue;
            }
            var cnt = numRows - 2;
            row -= 1;
            while(index < len && --row > 0) {
                list[row].append(s.charAt(index++));
            }
        }

        var sb = new StringBuilder();
        for(var item: list){
            sb.append(item);
        }
        return sb.toString();
    
    }
}