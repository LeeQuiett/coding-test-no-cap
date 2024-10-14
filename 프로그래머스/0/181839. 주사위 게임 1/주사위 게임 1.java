class Solution {
    public int solution(int a, int b) {
        int answer = 0;
        int evenOrOddA = a % 2;
        int evenOrOddB = b % 2;
        //I LOVE JAVA!!!!!
        if (evenOrOddA != 0 && evenOrOddB != 0) {
            answer = (a * a) + (b * b);
        }
        else if (evenOrOddA != 0 || evenOrOddB != 0) {
            answer = 2 * (a + b);
        }
        else {
            answer = a - b;
            if (answer < 0)
                answer = -answer;
        }
        
        return answer;
    }
}