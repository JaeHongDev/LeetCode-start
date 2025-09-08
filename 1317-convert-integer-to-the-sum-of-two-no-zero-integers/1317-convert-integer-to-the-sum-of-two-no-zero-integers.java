class Solution {
    public int[] getNoZeroIntegers(int n) {
        
        // 0이 포함되지 않은 정수
        
        // 1001
        
        for(int i = 1; i <= n; i++){
            var d = n - i; 

            var c = d; 
            var flag = true;
            while(flag && c > 0) {
                if(c % 10 == 0) flag = false;
                c /= 10;
            }
            if(flag) {
                return new int[] {i, d};
            }
        }
        return null;
    }
}