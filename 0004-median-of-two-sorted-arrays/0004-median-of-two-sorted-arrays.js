/**
 * @param {number[]} nums1
 * @param {number[]} nums2
 * @return {number}
 */
var findMedianSortedArrays = function (nums1, nums2) {
    const nums1MaxLength = nums1.length;
    const nums2MaxLength = nums2.length;
    const maxLength = nums1.length + nums2.length;

    if(maxLength === 0){
        
        return 0;
    }
    if(maxLength === 1 ) {
        if(nums1MaxLength === 1){
            return nums1[0];
        }
        if(nums2MaxLength === 1){
            return nums2[0]
        }
    }

    let minMedian;

    // if nums1 -> [1,2,3,4]
    // nums2 -> [5,6,7,8]
    // minMedianCount = 4[3th index],5[4th index]
    // 8 / 2 -1
    if (maxLength % 2 === 0) {
        minMedian = maxLength / 2 - 1;
    } else {
        minMedian = (maxLength - 1) / 2;
    }


    let ll = 0;
    let rl = 0;

    if(ll === nums1MaxLength){
        if(maxLength %2 === 0){
            return (nums2[minMedian] + nums2[minMedian+1]) /2; 
        }
        return nums2[minMedian];
    }
    if(rl === nums2MaxLength){
        if(maxLength %2 === 0){
            return (nums1[minMedian] + nums1[minMedian+1]) /2;
        }
        return nums1[minMedian];
    }


    let count = 0;

    while (count++ < minMedian) {
        if (ll === nums1MaxLength) {
            rl++;
            continue;
        }
        if (rl === nums2MaxLength) {
            ll++;
            continue;
        }
        if (nums1[ll] < nums2[rl]) {
            ll++;
            continue;
        }
        if (nums1[ll] === nums2[rl]) {
            ll++;
            continue;
        }
        if (nums1[ll] > nums2[rl]) {
            rl++;
        }
    }

    console.log(count, ll, rl);
    if (maxLength % 2 === 0) {

        if (ll === nums1MaxLength) {
            return (nums2[rl] + nums2[rl + 1]) / 2;
        }
        if (rl === nums2MaxLength) {
            return (nums1[ll] + nums1[ll + 1]) / 2;
        }
        let sum = 0;
        let cnt = 0;
        while (cnt++ < 2) {
            if (nums1[ll] < nums2[rl]) {
                sum += nums1[ll++];
                console.log("-")
                if(cnt === 1 && ll === nums1MaxLength){
                    return (sum + nums2[rl]) /2;
                }
                continue;
            }
            if (nums1[ll] === nums2[rl]) {
                if(cnt === 2){
                    return (sum + Math.max(nums1[ll], nums2[rl])) /2
                }
                return (nums1[ll] + nums2[rl]) / 2;
            }
            if (nums1[ll] > nums2[rl]) {
                sum += nums2[rl++];
                if(cnt === 1 && rl === nums2MaxLength){
                    return (sum + nums1[ll]) /2;
                }
                continue;
            }
        }
        return sum / 2;
    }
    if(ll === nums1MaxLength){
        return nums2[rl];
    }
    if(rl === nums2MaxLength){
        return nums1[ll];
    }
    return Math.min(nums1[ll], nums2[rl]);
};