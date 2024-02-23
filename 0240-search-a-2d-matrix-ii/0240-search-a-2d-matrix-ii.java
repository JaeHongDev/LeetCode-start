class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        for(int i = 0; i < matrix.length; i++){
            var arr = matrix[i];

            var left = 0;
            var right = arr.length -1; 

            while(left <= right){
                var mid = left + (right - left) / 2;

                if(arr[mid] == target) return true; 
                if(arr[mid] < target) left = mid + 1; 
                else right = mid - 1; 
            }
        }
        return false; 
    }
}