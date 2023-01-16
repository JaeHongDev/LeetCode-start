/**
 * @param {number[]} nums
 * @return {number}
 */
var findMin = function (nums) {
    
    const maxLength = nums.length - 1;
    
    if(maxLength === 0) return nums[0];
    if(maxLength === 1) return Math.min(nums[0], nums[1]);

    let low = 0;
    let high = maxLength;
    let mid = 0;
    const compare = (index) => {
        let before = index === 0 ? maxLength : index - 1;
        let after = index === maxLength ? 0 : index + 1;

        return (nums[index] < nums[after]) && (nums[index] < nums[before])
    }

    while (low <= high) {
        
        mid = Math.floor((low + high) / 2);
       
        if(compare(mid)) return nums[mid];
        if(compare(low)) return nums[low];
        if(compare(high)) return nums[high];

        // 왼쪽이 오른쪽 보다 큰 경우 mid의 왼쪽이 왼쪽보다 작은 경우
        if(nums[low] > nums[mid-1]){
            high = mid -1;
        }
        else if(nums[mid] < nums[mid+1]){
            low = mid +1;
        }
        else if(nums[low] > nums[high]) {
            low = mid;
        }
        else { 
            return nums[low]; // 로테이션을 발견 못한 경우
        }

    }
    return -1;
};

// 4 5 6 7 0 1 2
// 좌우에서 제일 작은 수

// 1 2 3 4 5 6