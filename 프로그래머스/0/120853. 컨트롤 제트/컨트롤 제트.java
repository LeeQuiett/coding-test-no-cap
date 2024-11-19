class Solution {
    public int solution(String s) {
        String[] sArray = s.split(" ");
        int answer = 0;
        int lastNumber = 0;
        
        for (String e : sArray) {
            if (e.equals("Z")) {
                answer -= lastNumber;
            } else {
                int number = Integer.parseInt(e);
                answer += number;
                lastNumber = number;
            }
        }
        return answer;
    }
}