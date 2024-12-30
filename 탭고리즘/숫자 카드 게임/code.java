import java.util.*;
import java.io.*;

public class CardSorting {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 카드 개수 입력
        int N = Integer.parseInt(br.readLine());
        
        // 카드 배열 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] cards = new int[N];
        for (int i = 0; i < N; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }
        
        // 최소 제거 카드 수 출력
        System.out.println(minRemovalsToSort(N, cards));
    }

    public static int minRemovalsToSort(int n, int[] cards) {
        ArrayList<Integer> lis = new ArrayList<>();

        // LIS(Longest Increasing Subsequence) 계산
        for (int card : cards) {
            // 현재 카드가 들어갈 위치 찾기
            int pos = Collections.binarySearch(lis, card);
            
            // 위치가 음수일 경우 삽입 위치로 변환
            if (pos < 0) pos = -(pos + 1);
            
            // 새로운 숫자를 추가하거나 기존 숫자를 대체
            if (pos == lis.size()) {
                lis.add(card); // 새로운 증가 부분 수열 생성
            } else {
                lis.set(pos, card); // 기존 값 갱신
            }
        }
        
        // 최소 제거 카드 수 = 전체 카드 수 - LIS 길이
        return n - lis.size();
    }
}
