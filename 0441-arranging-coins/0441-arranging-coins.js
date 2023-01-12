/**
 * @param {number} n
 * @return {number}
 */
var arrangeCoins = function(n) {
    
    const calculateSumToArithmeticProgression = (n) => (n**2 + n) / 2 ;
    for(let i = 1 ; i <= n ; i ++){ 
        const result = calculateSumToArithmeticProgression(i)
        if(result === n) return i;
        if(result > n) return i-1;
    }
    return -1;
};

