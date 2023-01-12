/**
 * @param {number} n
 * @return {number}
 */
var arrangeCoins = function(n) {
    
    for(let i = 1 ; i <= n ; i ++){ 
        const result = (i ** 2 + i ) / 2;
        if(result === n) return i;
        if(result > n) return i-1;
    }
    return -1;
};

