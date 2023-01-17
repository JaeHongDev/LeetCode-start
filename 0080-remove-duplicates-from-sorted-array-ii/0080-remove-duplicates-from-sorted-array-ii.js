/**
 * @param {number[]} nums
 * @return {number}
 */
var removeDuplicates = function(nums) {
    for(let i = nums.length-1; i >= 2; i--){
        if(nums[i] === nums[i-2]) nums.splice(i,1)
    }
    return nums.length;
};