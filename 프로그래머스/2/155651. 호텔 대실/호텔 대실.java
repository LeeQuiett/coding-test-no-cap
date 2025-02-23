class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        int row = book_time.length;
        int[][] times = new int[row][2];
        
        for(int i = 0; i < row; i++) {
            for (int j = 0; j < 2; j++) {
                String[] timeParts = book_time[i][j].split(":");
                int hours = Integer.parseInt(timeParts[0]);
                int minutes = Integer.parseInt(timeParts[1]);
                
                if (j == 1) {
                    times[i][j] = hours * 60 + minutes + 10; // 청소 시간 고려    
                } else {
                    times[i][j] = hours * 60 + minutes;
                }
            }
        }
        
        /* for (int[] row2 : times) {
            for (int col2 : row2) {
                System.out.print(col2 + " ");
            } System.out.println();
        } */
        
        int[] timeline = new int[1440 + 10]; //하루는 최대 1440분 + 청소시간 10분
        
        for (int[] time : times) {
            int start = time[0];
            int end = time[1];
            
            timeline[start]++;
            timeline[end]--;
        }
        
        int maxOverlap = 0;
        int currentOverlap = 0;
        
        for (int i = 0; i < 1440; i++) {
            currentOverlap += timeline[i];
            maxOverlap = Math.max(currentOverlap, maxOverlap);
        }
        return maxOverlap;
    }
}
