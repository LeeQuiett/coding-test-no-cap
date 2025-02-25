class Solution {
    public int solution(int n, int[] tops) {
        final int MOD = 10007;
        int answer = 0;
        int[][] dp = new int[n + 1][2];
        dp[0][0] = 1;
        dp[0][1] = 0;
        
        for (int i = 0; i < n; i++) {
            dp[i + 1][0] = (dp[i][0] * (2 + tops[i]) % MOD + dp[i][1] * (1 + tops[i]) % MOD) % MOD;
            dp[i + 1][1] = (dp[i][0] + dp[i][1]) % MOD;
        }
        
        answer = dp[n][0] + dp[n][1];
        answer = answer % MOD;
        
        return answer;
    }
}