import java.util.*;

class Solution {
    public int solution(int[] mats, String[][] park) {
        int rows = park.length;
        int cols = park[0].length;
        Arrays.sort(mats);
        
        // 가장 큰 돗자리부터 순차적으로 검사
        for (int t = mats.length - 1; t >= 0; t--) {
            int matSize = mats[t];
            // 사실 이거 필요없음 boolean canPlaceMat = false;

            // 공원에서 matSize x matSize 크기의 정사각형 검사
            for (int i = 0; i <= rows - matSize; i++) {
                for (int j = 0; j <= cols - matSize; j++) {
                    boolean isFilledMinus = true;

                    for (int k = i; k < i + matSize; k++) {
                        for (int a = j; a < j + matSize; a++) {
                            if (!park[k][a].equals("-1")) {
                                isFilledMinus = false;
                                break;
                            }
                        }
                        if (!isFilledMinus) break;
                    }

                    if (isFilledMinus) {
                        // canPlaceMat = true;
                        return matSize;
                    }
                }
            }
        }

        // 모든 돗자리를 깔 수 없는 경우
        return -1;
    }
}
