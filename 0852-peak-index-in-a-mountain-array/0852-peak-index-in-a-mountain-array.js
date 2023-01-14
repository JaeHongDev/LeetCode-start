/**
 * @param {number[]} arr
 * @return {number}
 */
var peakIndexInMountainArray = function(arr) {
    let index = arr.length - 1;
    while(index-- > 0){
        if(arr[index] < arr[index+1]) {
            return index+1;
        }
    }
};