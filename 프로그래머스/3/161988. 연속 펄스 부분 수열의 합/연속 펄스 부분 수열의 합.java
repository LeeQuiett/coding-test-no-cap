//카데인 알고리즘 적용
class Solution {
    public long solution(int[] sequence) {
        int seqLen = sequence.length;
        long currentSum1 = sequence[0];
        long currentSum2 = -sequence[0]; // 0, 2, 4, 6
        long maxSum = Math.max(currentSum1, currentSum2);
        
        for (int i = 1; i < seqLen; i++) {
            if (i % 2 == 0) {
                currentSum1 = Math.max(sequence[i], currentSum1 + sequence[i]);
                currentSum2 = Math.max(-sequence[i], currentSum2 - sequence[i]);
            } else {
                currentSum1 = Math.max(-sequence[i], currentSum1 - sequence[i]);
                currentSum2 = Math.max(sequence[i], currentSum2 + sequence[i]);
            }
            maxSum = Math.max(maxSum, Math.max(currentSum1, currentSum2));
        }
        
        long answer = maxSum;
        return answer;
    }
}