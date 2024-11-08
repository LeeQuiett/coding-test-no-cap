import java.util.Arrays;
class Solution {
    public int solution(String[] friends, String[] gifts) {
        /*
        전달에 선물을 더 많이 줬던 사람이 다음달에 선물을 하나 받음
        기록X 또는 수가 같다면, 선물 지수가 큰 사람이 하나 받음, 선물 지수도 같다면 담달에 선물 안주고받음
        A가 3개 주고 10개 받았다면 선물지수가 -7
        */
        int len = friends.length;
        int giftScore[] = new int[len];
        int giftExchangeMatrix[][] = new int[len][len];
        int forAnswerArr[] = new int[len];
        
        getGiftScore(giftScore, gifts, len, friends);
        getGiftExchangeMatrix(gifts, len, friends, giftExchangeMatrix);
        
        System.out.println(Arrays.toString(giftScore));
        System.out.println(Arrays.deepToString(giftExchangeMatrix));
        
        for (int i = 0; i < len; i++) {
            for (int k = 0 ; k < len; k++) {
                if (i == k) continue;
                if (giftExchangeMatrix[i][k] > giftExchangeMatrix[k][i]) {
                    forAnswerArr[i]++;
                } else if (giftExchangeMatrix[i][k] < giftExchangeMatrix[k][i]) {
                    forAnswerArr[k]++;
                } else {
                    if (giftScore[i] > giftScore[k]) {
                        forAnswerArr[i]++;
                    } else if (giftScore[i] < giftScore[k]) {
                        forAnswerArr[k]++;
                    } else {
                        // 주고받지 않음
                    }
                }
            }
        }
        
        int max = Arrays.stream(forAnswerArr).max().getAsInt();
        System.out.println(Arrays.toString(forAnswerArr));
        
        int answer = max / 2; // 주고받은 선물을 루프돌때 중복 계산하게되어 나눔
        return answer;
    }
    
    private void getGiftScore(int[] giftScore, String[] gitfs, int len, String[] friends) {
        for (String gifterNames : gitfs) {
            String[] names = gifterNames.split(" ");
            
            for (int i = 0; i < len; i++) {
                if (friends[i].equals(names[0])) {
                    giftScore[i]++;
                }
                if (friends[i].equals(names[1])) {
                    giftScore[i]--;
                }
            }
        }
    }
    
    private void getGiftExchangeMatrix(String [] gifts, int len, String[] friends, int[][] giftExchangeMatrix)
    {
        for (String s : gifts) {
            String[] names = s.split(" ");
            
            for (int i = 0; i < len; i++) {
                if (friends[i].equals(names[0])) {
                    for (int k = 0; k < len; k++) {
                        if (friends[k].equals(names[1])) {
                            giftExchangeMatrix[i][k]++;
                        }
                    }    
                }
            }
        }
    }
    
}