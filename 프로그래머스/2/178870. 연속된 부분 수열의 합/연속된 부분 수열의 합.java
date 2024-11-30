class Solution {
    public int[] solution(int[] sequence, int k) {
        /* 시간복잡도이슈로 테스트코드 일부 통과 못함ㅠ.ㅠ
        int cnt = 0;
        int Lindex = 0;
        int Rindex = 0;
        int len = Integer.MAX_VALUE;
        
        for (int i = 0; i < sequence.length; i++) {
            for (int j = i; j >= 0; j--) {
                cnt += sequence[j];
                if (cnt == k) {
                    int tmpLen = i - j;
                    if (tmpLen < len) {
                        len = tmpLen;
                        Lindex = j;
                        Rindex = i;
                    }
                }
            }
            cnt = 0;
        }
        
        int[] answer = {Lindex, Rindex};
        return answer;
        */
        
        //Two Pointer 기법을 사용하였다.
        int Lindex = 0;
        int Rindex = 0;
        int sum = 0;
        int minLen = Integer.MAX_VALUE;
        int[] result = new int[2];
        
        while (Rindex < sequence.length) {
            sum += sequence[Rindex];
            
            while (sum >= k) {
                if (sum == k && Rindex - Lindex < minLen) {
                    minLen = Rindex - Lindex;
                    result[0] = Lindex;
                    result[1] = Rindex;
                }
                sum -= sequence[Lindex];
                Lindex++;
            }
            
            Rindex++;
        }
        return result;
    }
}