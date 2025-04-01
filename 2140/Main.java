class Solution {
    public long mostPoints(int[][] questions) {
        int n = questions.length;
        long[] dp = new long[n + 1];
        
        // 뒤에서부터 순회하며 dp 배열 채우기
        for (int i = n - 1; i >= 0; i--) {
            int points = questions[i][0];
            int brainpower = questions[i][1];
            int nextIndex = i + brainpower + 1;
            
            // 현재 문제를 풀 경우와 넘길 경우 중 최대값 선택
            long take = points + (nextIndex < n ? dp[nextIndex] : 0);
            long skip = dp[i + 1];
            
            dp[i] = Math.max(take, skip);
        }
        return dp[0];
    }
}
