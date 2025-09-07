class Solution {
    public int[] sumZero(int n) {
        // 더해서 0이되는 배열
        // 1000개 정도까지 존재함

        // 못 만드는 경우는 있나..? 
        // 홀수면 -1 0 1 
        // 짝수면 -1 1 이렇게 하면 될 듯?   

        var arr = new int[n]; 

        
        for(int i = 0; i < n / 2; i++) {
            arr[i] = n - i;
            arr[(n - 1) - i] = -(n - i);
        }

        return arr;
    }
}