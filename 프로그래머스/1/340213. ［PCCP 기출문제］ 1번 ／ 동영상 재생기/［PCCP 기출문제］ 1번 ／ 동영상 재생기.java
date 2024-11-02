class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int intVideoLen = timeToSeconds(video_len);
        int intPos = timeToSeconds(pos);
        int intOpStart = timeToSeconds(op_start);
        int intOpEnd = timeToSeconds(op_end);
        
        for (String command : commands) {
             if (intOpStart <= intPos && intPos <= intOpEnd) {
                intPos = intOpEnd;
            }
            if (command.equals("prev")) {
                if (intPos < 10) {
                    intPos = 0;
                } else {
                    intPos -= 10;
                }
            } else if (command.equals("next")) {
                if ((intVideoLen - intPos) < 10) {
                    intPos = intVideoLen;
                } else {
                    intPos += 10;
                }
            } else {
                
            }
            if (intOpStart <= intPos && intPos <= intOpEnd) {
                intPos = intOpEnd;
            }
        }
        
        
        String answer = secondsToTime(intPos);
        return answer;
    }
    
    private int timeToSeconds(String time) {
        String[] parts = time.split(":");
        return Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
    }
    
    private String secondsToTime(int seconds) {
        int minutes = seconds / 60;
        int remainingSeconds = seconds % 60;
        return String.format("%02d:%02d", minutes, remainingSeconds);
    }
}