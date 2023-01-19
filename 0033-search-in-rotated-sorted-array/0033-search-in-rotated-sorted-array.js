/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
var search = function (nums, target) {
    if (nums.length === 1) return nums[0] === target ? 0 : -1;

    let low = 0;
    let high = nums.length - 1;
    let mid;

    while (low <= high) {
        mid = Math.floor((low + high) / 2);
        if (nums[mid] === target) return mid;

        if (nums[low] <= nums[mid]) {
            if (nums[low] <= target && target <=  nums[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        } else {
            if (nums[mid] <= target && target <=  nums[high]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
    }
    return -1;
};


// 0 1 2 3 4 5 6 7 
// 3 
// 