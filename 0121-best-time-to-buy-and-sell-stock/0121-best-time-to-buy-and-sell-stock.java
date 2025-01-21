class Solution {
    public int maxProfit(int[] prices) {
        var answer = 0;
        var min = prices[0];

        for(int i = 1; i < prices.length; i++){
            answer = Math.max(answer, prices[i] - min);
            min = Math.min(min, prices[i]);
        }

        return answer;
    }
}