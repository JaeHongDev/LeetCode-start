/**
 * @param {number[]} nums
 * @return {void} Do not return anything, modify nums in-place instead.
 */
var sortColors = function (nums) {

    let index = 0
    for (let j = 0; j < nums.length; j++) {
        if (nums[j] == 0) {
            [nums[index], nums[j]] = [nums[j], nums[index]]
            index++
        }

    }
    let k = index
    for (let m = 0; m < nums.length; m++) {
        if (nums[m] == 1) {
            [nums [m], nums[k]] = [nums[k], nums[m]]
            k++
        }

    }
};
