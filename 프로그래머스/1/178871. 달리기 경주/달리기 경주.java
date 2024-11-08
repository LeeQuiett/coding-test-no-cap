import java.util.HashMap;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        int playersLen = players.length;
        
        HashMap<String,Integer> playerIndexMap = new HashMap<>();
        for (int i = 0; i < playersLen; i++) {
            playerIndexMap.put(players[i], i);
        }
        
        for (String calledPlayer : callings) {
            int currentIndex = playerIndexMap.get(calledPlayer);
            
            String tmp = players[currentIndex-1];
            players[currentIndex-1] = players[currentIndex];
            players[currentIndex] = tmp;
            
            playerIndexMap.put(calledPlayer, currentIndex -1);
            playerIndexMap.put(tmp, currentIndex);
        }
        /* 시간복잡도 이슈 ㅜ.ㅜ
        int callsLen = callings.length;
        
        for (int i = 0; i < callsLen; i++) {
            for (int k = 1; k < playersLen; k++) {
                if (callings[i].equals(players[k])) {
                    //if (k == 0) continue;
                    String tmp = players[k];
                    players[k] = players[k-1];
                    players[k-1] = tmp;
                }
            }
        } */
        
        String[] answer = players;
        return answer;
    }
}