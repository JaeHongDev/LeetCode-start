class Solution {
    public long maximumTripletValue(int[] arr) {
    
        long sum = 0;

        var size = arr.length;

        for(int i = 0; i < size - 2; i++) {
            for(int j = i + 1; j < size - 1; j++){
                for(int k = j + 1; k < size; k++) {
                    var t = (long) (arr[i] - arr[j]) * arr[k];
                    sum = Math.max(sum, t);
                }
            }
        }
        return sum; 
    }
}