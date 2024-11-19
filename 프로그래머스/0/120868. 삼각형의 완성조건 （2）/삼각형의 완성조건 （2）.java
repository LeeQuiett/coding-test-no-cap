import java.util.Arrays;

class Solution {
    public int solution(int[] sides) {
        int max = Arrays.stream(sides).max().getAsInt();
        int min = Arrays.stream(sides).min().getAsInt();
        int cnt = 0;
        
        int k = max - min + 1; // 5
        int i = max - (max - min); // 7
        int j = (max + min - 1); // 17
        
        for (; k <= j; k++) {
            cnt++;
        }
        int answer = 0;
        return cnt;
    }
}